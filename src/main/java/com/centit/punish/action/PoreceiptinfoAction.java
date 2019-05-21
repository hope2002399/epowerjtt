package com.centit.punish.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Poreceiptinfo;
import com.centit.punish.po.PoreceiptinfoId;
import com.centit.punish.service.PodiscussbasicManager;
import com.centit.punish.service.PofinishbasicManager;
import com.centit.punish.service.PoreceiptinfoManager;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.NodeInstance;

public class PoreceiptinfoAction extends PunishCommonBizAction<Poreceiptinfo> {
    private static final Log log = LogFactory.getLog(PoreceiptinfoAction.class);
    private static final long serialVersionUID = 1L;
    private PoreceiptinfoManager poreceiptinfoMag;
    private PodiscussbasicManager podiscussbasicManager;
    private PofinishbasicManager pofinishbasicManager;

    public void setPoreceiptinfoManager(PoreceiptinfoManager basemgr) {
        poreceiptinfoMag = basemgr;
        this.setBaseEntityManager(poreceiptinfoMag);
    }

    public void setPodiscussbasicManager(
            PodiscussbasicManager podiscussbasicManager) {
        this.podiscussbasicManager = podiscussbasicManager;
    }

    public void setPofinishbasicManager(
            PofinishbasicManager pofinishbasicManager) {
        this.pofinishbasicManager = pofinishbasicManager;
    }

    OptProcInfo opi = new OptProcInfo();
    private String roleCode = "";
    private String nodeName = "";
    private File poreceiptdoc_;
    private String poreceiptdoc_FileName;

    /**********************************************************/
    /**
     * 送达处罚决定书 Poreceiptstate:2、处罚决定书
     * 
     * @return
     */
    public String sendPunishDoc() {
        /**
         * 多模板情况加载
         */
        super.initTemplateFromNode();
        super.initalDocJson("处罚决定书", object.getPunishobjectid());
        object.setPoreceiptstate((long) 2); // 给个默认值:处罚决定书
        this.initalObject();
        return "sendPunishDoc";
    }

    private String archivetypes;// 文书类型

    /**
     * 送达预先告知书 poreceiptstate:1、送达预先告知书
     * 
     * @return
     */
    public String sendAdvanceDoc() {
        try {
            /**
             * 多模板情况加载
             */
            super.initTemplateFromNode();
            super.initalDocJson("预先告知书", object.getPunishobjectid());
            object.setPoreceiptstate((long) 1); // 给个默认值:处罚决定书
            this.initalObject();
            return "sendPunishDoc";
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "送达预先告知书时出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 
     * @return 初始化 处罚文书以及人员角色信息
     */
    public String initalObject() {

        String punishobjectid = object.getPunishobjectid();
        Long poreceiptstate = object.getPoreceiptstate();

        object = poreceiptinfoMag.getObject(new Poreceiptinfo(object.getCid()));

        if (object == null) {
            object = new Poreceiptinfo();
            object.setPoreceiptstate(poreceiptstate);
            object.setPunishobjectid(punishobjectid);
            object.setSignineddate(new Date(System.currentTimeMillis()));
            object.setPunishobjectid(punishobjectid);
        }
        super.initalOptProcInfo();

        // 获取人员权限编号
        NodeInstance nit = flowEngine.getNodeInstById(curNodeInstId);
        FlowNodeInfo fif = flowEngine.getNodeInfoById(nit.getNodeId());
        if (fif != null) {
            roleCode = fif.getRoleCode();
            nodeName = fif.getNodeName();
        }
        /**
         * 获得办件角色人名单
         */
        Set<String> Rolecodes = flowEngine.viewFlowWorkTeam(
                nit.getFlowInstId(), roleCode);

        String RoleuserCodes = "";

        if (Rolecodes != null && Rolecodes.size() > 0) {
            for (String a : Rolecodes) {
                RoleuserCodes += a + ",";
                // RoleuserNames += CodeRepositoryUtil.getValue("usercode", a)
                // + ",";
            }
            teamRoleCode = RoleuserCodes.substring(0,
                    RoleuserCodes.length() - 1);
            // bjUserNames = RoleuserNames.substring(0, RoleuserNames.length() -
            // 1);
        }

        /**
         * 根据参数是否需要 办件人员
         */
        FUserDetail fUserDetail = (FUserDetail) getLoginUser();
        String roleCode = roleCodefromFlow;
        if (StringUtils.isBlank(roleCode) || "null".equals(roleCode)) {
            roleCode = "D(all)";
        }
        Set<String> users = SysUserFilterEngine.calcOperators(roleCode,
                fUserDetail.getPrimaryUnit(), null, null, null,
                fUserDetail.getUsercode(), null);
        JSONArray userjson = new JSONArray();
        if (users != null) {
            for (String user : users) {
                String username = CodeRepositoryUtil.getValue("usercode", user);
                JSONObject usermap = new JSONObject();
                usermap.put("name", username);
                usermap.put("nodeID", user);
                usermap.put("belongId", "-1");
                usermap.put("levle", 2);
                userjson.add(usermap);
            }
        }
        request.setAttribute("userjson", userjson);
        return "";
    }

    /**
     * 提交送达文书
     * 
     * @return
     */
    public String receiptModelSubmitOpt() {
        try {
            // 1、判断文书是否生成
            String[] archivetype = archivetypes.split(",");
            boolean falg = false;
            if (archivetype != null && archivetype.length > 0) {
                for (String type : archivetype) {
                    if (!StringUtils.isBlank(type)) {
                        List<OptStuffInfo> osf = optProcInfoManager
                                .listStuffsByArchiveType(
                                        object.getPunishobjectid(), type.trim());
                        if (osf != null && osf.size() > 0) {
                            falg = true;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (!falg) {
                this.postAlertMessage("文书上传不全，请检查！", response);
                return null;
            }
            // 2、保存文书回执信息：
            try {
                this.save();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // 3、如果是提交处罚决定书，则需要生成结案审批基础数据
            if (2 == object.getPoreceiptstate()) {
                this.savePOFinishBasic();
                // 处罚决定书
                super.initalOptNewlyIdea((long) 0, "", (long) 15,
                        "/punish/poreceiptinfo!view.do?poreceiptstate=2&punishobjectid="
                                + object.getPunishobjectid());
            } else {
                // 送达通知书
                super.initalOptNewlyIdea((long) 0, "", (long) 9,
                        "/punish/poreceiptinfo!view.do?poreceiptstate=1&punishobjectid="
                                + object.getPunishobjectid());
            }
            // 4、提交流程
            return super.submitOpt();
        } catch (Exception e) {
            log.error(e, e.getCause());
            request.setAttribute("error", "提交送达文书时出错，详见系统日志。");
            return ERROR;
        }
    }

    /**
     * 生成结案审批基础数据
     */
    private void savePOFinishBasic() {
        // 获取案件讨论的信息
        // VPODiscuss
        // vpod=podiscussbasicManager.getVPODiscussByCid(object.getPunishobjectid(),object.getPoreceiptstate());
        Podiscussbasic pb = new Podiscussbasic();
        pb.setPunishobjectid(object.getPunishobjectid());
        pb.setPodiscusstype(object.getPoreceiptstate());
        Podiscussbasic pbc = podiscussbasicManager.getObject(pb);

        Pofinishbasic pfb = new Pofinishbasic();
        pfb.setPunishobjectid(object.getPunishobjectid());
        if (pbc != null) {
            pfb.setConfirmtruth(pbc.getConfirmtruth());
            pfb.setDisobeyitem(pbc.getDisobeyitem());
            pfb.setPodiscussresult(pbc.getPodiscussresult());
        }
        pofinishbasicManager.saveObject(pfb);

    }

    public String save() {
        Poreceiptinfo bean = poreceiptinfoMag.getObject(object);
        if (bean != null) {
            bean.copyNotNullProperty(object);
            object = bean;
        }

        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        if (poreceiptdoc_ != null) {
            try {
                FileInputStream fis = new FileInputStream(poreceiptdoc_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setPoreceiptdoc(bbuf);
                    object.setPoreceiptname(poreceiptdoc_FileName);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        object.setEnregisterdate(new Date(System.currentTimeMillis()));
        object.setEnregisterid(loginInfo.getUsercode());
        try {
            poreceiptinfoMag.saveObject(object);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return "";
    }

    public OptProcInfo getOpi() {
        return opi;
    }

    public void setOpi(OptProcInfo opi) {
        this.opi = opi;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public File getPoreceiptdoc_() {
        return poreceiptdoc_;
    }

    public void setPoreceiptdoc_(File poreceiptdoc_) {
        this.poreceiptdoc_ = poreceiptdoc_;
    }

    public String getPoreceiptdoc_FileName() {
        return poreceiptdoc_FileName;
    }

    public void setPoreceiptdoc_FileName(String poreceiptdoc_FileName) {
        this.poreceiptdoc_FileName = poreceiptdoc_FileName;
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private InputStream stuffStream;

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String downloaddiscussstuff() {
        PoreceiptinfoId cid = new PoreceiptinfoId();
        cid.setPunishobjectid(object.getPunishobjectid());
        cid.setPoreceiptstate(object.getPoreceiptstate());
        object = this.poreceiptinfoMag.getObjectById(cid);
        String fn = object.getPoreceiptname();
        try {
            if (object.getPoreceiptdoc() != null) {
                inputStream = new ByteArrayInputStream(object.getPoreceiptdoc());
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        try {
            this.setFilename(new String(fn.getBytes("GBK"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "download";

    }

    public String getArchivetypes() {
        return archivetypes;
    }

    public void setArchivetypes(String archivetypes) {
        this.archivetypes = archivetypes;
    }
}
