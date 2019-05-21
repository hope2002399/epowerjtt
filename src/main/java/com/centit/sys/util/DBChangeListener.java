package com.centit.sys.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.dcn.RowChangeDescription;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import com.centit.supervise.po.SuperviseReply;
import com.centit.supervise.service.SuperviseReplyManager;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.sample.SampleFlowManager;
import com.goldgrid.weboffice.iDBManager2000;

public class DBChangeListener extends ContextLoaderListener implements
        ServletContextListener {
    private static final Log log = LogFactory.getLog(DBChangeListener.class);
    static final ApplicationContext context = new ClassPathXmlApplicationContext(
            "spring-hibernate.xml");
    static final BasicDataSource basicDataSource = (BasicDataSource) context
            .getBean("dataSource");
    static final String USERNAME = basicDataSource.getUsername();
    static final String PASSWORD = basicDataSource.getPassword();
    static final String URL = basicDataSource.getUrl();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("DBChangeListener Init...");
        DBChangeListener demo = new DBChangeListener();
        try {
            demo.run();
        } catch (SQLException mainSQLException) {
            mainSQLException.printStackTrace();
        }
    }

    /**
     * 在Web应用结束时停止任务
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // runTimer.cancel(); // 定时器销毁
        /*
         * OracleConnection conn3 = connect();
         * conn3.unregisterDatabaseChangeNotification(dcr); conn3.close();
         */
        super.contextDestroyed(event);
    }

    void run() throws SQLException {
        log.info("DBChangeListener running...");
        OracleConnection conn = connect();

        // first step: create a registration on the server:
        Properties prop = new Properties();

        // if connected through the VPN, you need to provide the TCP address of
        // the client.
        // For example:
        // prop.setProperty(OracleConnection.NTF_LOCAL_HOST,"14.14.13.12");

        // Ask the server to send the ROWIDs as part of the DCN events (small
        // performance
        // cost):

        // 指定端口号，端口被占用会报 “ORA-29972: 用户没有更改/创建注册的权限”
        // prop.setProperty(OracleConnection.NTF_LOCAL_TCP_PORT,"38665");

        prop.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        prop.setProperty(OracleConnection.DCN_IGNORE_DELETEOP, "true"); // 忽略delete
        //
        // Set the DCN_QUERY_CHANGE_NOTIFICATION option for query registration
        // with finer granularity.
        prop.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");

        // The following operation does a roundtrip to the database to create a
        // new
        // registration for DCN. It sends the client address (ip address and
        // port) that
        // the server will use to connect to the client and send the
        // notification
        // when necessary. Note that for now the registration is empty (we
        // haven't registered
        // any table). This also opens a new thread in the drivers. This thread
        // will be
        // dedicated to DCN (accept connection to the server and dispatch the
        // events to
        // the listeners).
        DatabaseChangeRegistration dcr = conn
                .registerDatabaseChangeNotification(prop);

        try {
            // add the listenerr:
            DCNDemoListener list = new DCNDemoListener(this);
            dcr.addListener(list);

            // second step: add objects in the registration:
            Statement stmt = conn.createStatement();
            // associate the statement with the registration:
            ((OracleStatement) stmt).setDatabaseChangeRegistration(dcr);
            log.info("DB:" + URL + ";" + USERNAME + "/" + PASSWORD);
            ResultSet rs = stmt
                    .executeQuery("select * from INF_SUPBACK where 1=2"); // 仅是为了添加被监视的表，不需要真的查出数据
            while (rs.next()) {
            }
            String[] tableNames = dcr.getTables();
            for (int i = 0; i < tableNames.length; i++)
                System.out.println(tableNames[i]
                        + " is part of the registration.");
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            // if an exception occurs, we need to close the registration in
            // order
            // to interrupt the thread otherwise it will be hanging around.
            if (conn != null)
                conn.unregisterDatabaseChangeNotification(dcr);
            throw ex;
        } finally {
            try {
                // Note that we close the connection!
                conn.close();
            } catch (Exception innerex) {
                innerex.printStackTrace();
            }
        }

        // At the end: close the registration (comment out these 3 lines in
        // order
        // to leave the registration open).
        /*
         * OracleConnection conn3 = connect();
         * conn3.unregisterDatabaseChangeNotification(dcr); conn3.close();
         */
    }

    /**
     * Creates a connection the database.
     */
    OracleConnection connect() throws SQLException {
        OracleDriver dr = new OracleDriver();
        Properties prop = new Properties();
        prop.setProperty("user", DBChangeListener.USERNAME);
        prop.setProperty("password", DBChangeListener.PASSWORD);
        return (OracleConnection) dr.connect(DBChangeListener.URL, prop);
    }
}

/**
 * DCN listener: it prints out the event details in stdout.
 */
class DCNDemoListener implements DatabaseChangeListener {
    DBChangeListener demo;
    ApplicationContext ctxSampleflow, ctxSupervise;

    public DCNDemoListener(DBChangeListener dem) {
        demo = dem;
        ctxSampleflow = new ClassPathXmlApplicationContext(
                "sampleflowconfig/spring-manager.xml");
        ctxSupervise = new ClassPathXmlApplicationContext(
                "superviseconfig/spring-manager.xml");

    }

    public void onDatabaseChangeNotification(DatabaseChangeEvent event) {
        Thread t = Thread.currentThread();
        System.out.println("DCNDemoListener: got an event (" + this
                + " running on thread " + t + ")");
        RowChangeDescription[] rcds = event.getTableChangeDescription()[0]
                .getRowChangeDescription();
        SampleFlowManager flowManager = (SampleFlowManager) ctxSampleflow
                .getBean("flowManager");
        for (int i = 0; i < rcds.length; i++) {
            iDBManager2000 DbaObj = new iDBManager2000();
            if (DbaObj.OpenConnection()) {
                String mysql = "SELECT * from INF_SUPBACK Where RowID='"
                        + rcds[i].getRowid().stringValue() + "'";
                try {
                    ResultSet result = DbaObj.ExecuteQuery(mysql);
                    if (result.next()) {
                        if ("S".equals(result.getString("SYNC_SIGN")))
                            continue;
                        String sNO = result.getString("NO");
                        Date sRECEIPTDATE = result.getTimestamp("RECEIPTDATE");
                        String sSUPERVISEBACK = result
                                .getString("SUPERVISEBACK");
                        String sMONITOR_ID = result.getString("MONITOR_ID");
                        String sOPERATORNAME = result.getString("OPERATORNAME");
                        mysql = "SELECT MAX(NODEINSTID) as NODEINSTID, MAX(n.NodeName) as NodeName from WF_NODE_INSTANCE ni"
                                + " left join M_SUPERVISEBASIC s on s.FLOWINSTID = ni.WFINSTID"
                                + " left join WF_NODE n on n.nodeID = ni.nodeID"
                                + " where s.SUPERVISE_NO = '" + sNO + "'";
                        ResultSet rs = DbaObj.ExecuteQuery(mysql);
                        // System.out.println(result.getLong("nodeInstId"));
                        // TODO: 提交流程节点、保存业务相关数据
                        if (rs.next()) {
                            String sNodeName = rs.getString("NodeName");
                            flowManager.forceCommit(rs.getLong("NODEINSTID"),
                                    "数据交换");
                            rs = DbaObj.ExecuteQuery(mysql);
                            rs.next();
                            saveSuperviseReply(sNO, rs.getLong("NODEINSTID"),
                                    sRECEIPTDATE, sSUPERVISEBACK, sNodeName,
                                    sMONITOR_ID, sOPERATORNAME);
                            // 执行过的标记SYNC_SIGN为'S'
                            mysql = "update INF_SUPBACK set SYNC_SIGN='S', SYNC_DATE=SYSDATE where RowID='"
                                    + rcds[i].getRowid().stringValue() + "'";
                            DbaObj.ExecuteQuery(mysql);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        // System.out.println(event.toString()); /*
        // event.getTableChangeDescription()[0].getRowChangeDescription()[0].getRowid().stringValue()*/
        synchronized (demo) {
            demo.notify();
        }
    }

    /**
     * 保存督办过程信息
     * 
     * @return
     */
    @SuppressWarnings("unused")
    private void saveSuperviseReply(String supNo, Long nodeInstId,
            Date processDate, String operatorOpinion, String nodeName,
            String operatorId, String operatorName) {
        try {
            FlowEngine flowEngine = (FlowEngine) ctxSampleflow
                    .getBean("flowEngine");
            NodeInstance nit = flowEngine.getNodeInstById(nodeInstId);
            FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
            SuperviseReplyManager superviseReplyManager = (SuperviseReplyManager) ctxSupervise
                    .getBean("superviseReplyManager");
            SuperviseReply supervisereply = new SuperviseReply(nodeInstId,
                    processDate, operatorOpinion, new Date());
            supervisereply.setProcessNo(superviseReplyManager.getNextKey());
            supervisereply.setSuperviseNo(supNo);
            supervisereply.setProcessName(nodeName);
            supervisereply.setOperatorName(operatorName);
            supervisereply.setOperatorId(operatorId);
            superviseReplyManager.saveObject(supervisereply);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存办件人员
     */
    /*
     * public void saveTeamRolepeople() { try { ApplicationContext ctx = new
     * ClassPathXmlApplicationContext("sampleflowconfig/spring-manager.xml");
     * FlowEngine flowEngine = (FlowEngine) ctx.getBean("flowEngine"); //
     * flowEngine.deleteFlowWorkTeam(super.getFlowInstId(),"ajjbr");
     * NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId); if
     * (!StringUtils.isBlank(teamRoles)) { String[] teamRole =
     * teamRoles.split(","); if (teamRole.length > 0) { for (String a :
     * teamRole) { flowEngine.assignFlowWorkTeam(nit.getFlowInstId(), "jbr", a);
     * } } } } catch (Exception e) { e.printStackTrace(); } }
     */
}
