exp jttxq/jttxq@centora file='D:\jttxqapp.dmp' tables=(P_FILEINFO,M_INNERMSG,M_INNERMSG,OA_STAT_MONTH,OA_WORK_DAY,OA_WORKING_TIME,P_PUBLICINFO)

exp jttxq/jttxq@centora file='D:\jttxqcjjc.dmp' tables=(Departmentattribute,IOBASIC,JCRY_SUPERVISORYPERSONNEL,QL_JCRY_SUPERVISORYPERSONNEL,SUPINFOBASIC,SUP_JCRY_SUPERVISORYPERSONNEL)

create or replace view v_jcrypersonnel as
select  no,Q.USER_ID,Q.USER_NAME,Q.DEPTCODE,Q.BIRTH,Q.SEX,Q.POLITICAL_LANDSCAPE,Q.EDUCATION,Q.TEL,Q.POSITION,Q.ORGANIZATION,Q.CHANGE_DATE,Q.UPDATE_TYPE,Q.UPDATE_DATE,Q.SYNC_DATE,Q.SYNC_SIGN,Q.SYNC_ERROR_DESC from QL_JCRY_SUPERVISORYPERSONNEL Q
UNION
select  no,S.USER_ID,S.USER_NAME,S.DEPTCODE,S.BIRTH,S.SEX,S.POLITICAL_LANDSCAPE,S.EDUCATION,S.TEL,S.POSITION,S.ORGANIZATION,S.CHANGE_DATE,S.UPDATE_TYPE,S.UPDATE_DATE,S.SYNC_DATE,S.SYNC_SIGN,S.SYNC_ERROR_DESC from SUP_JCRY_SUPERVISORYPERSONNEL S;


exp jttxq/jttxq@centora file='D:\jttxqstat.dmp' tables=(Q_QUERYCOLUMN,Q_QUERYCONDITON,Q_QUERYMODEL)

exp jttxq/jttxq@centora file='D:\jttxqsys.dmp' tables=(F_ADDRESS_BOOK,F_DATACATALOG,F_DATADICTIONARY,F_OPTDEF,F_OPTFLOWNOINFO,F_OPTINFO,F_ROLEINFO,F_ROLEPOWER,F_UNITINFO,F_USERINFO,F_USERROLE,F_USERUNIT,F_OPT_RUN_REC,F_OPT_VARIABLE,F_USERSETTING)

create or replace view f_v_userroles as
select distinct b.*,a.usercode
from F_USERROLE a join F_ROLEINFO b on (a.ROLECODE=b.ROLECODE)
where a.OBTAINDATE <= sysdate and (a.SECEDEDATE is null or a.SECEDEDATE > sysdate) and b.ISVALID='T';

create or replace view f_v_useroptmoudlelist as
select  distinct a.UserCode,d.OptID, d.OptName , d.PreOptID ,d.OptType,
            d.FormCode  , d.opturl, d.MsgNo , d.MsgPrm, d.IsInToolBar ,
            d.ImgIndex,d.TopOptID ,d.OrderInd,d.PageType
from F_USERROLE a  join F_ROLEPOWER b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
        join F_OptInfo d on(c.OPTID=d.OptID)
where  d.opturl<> '...' and a.OBTAINDATE <= sysdate and (a.SECEDEDATE is null or a.SECEDEDATE > sysdate);

create or replace view f_v_useroptlist as
select  distinct a.UserCode,  c.OPTCODE,  c.OPTNAME  ,  c. OPTID ,  c.OPTMETHOD
from F_USERROLE a  join F_ROLEPOWER   b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
where a.OBTAINDATE <= sysdate and (a.SECEDEDATE is null or a.SECEDEDATE > sysdate);

/*
create or replace view f_v_userdatascope as
select  distinct a.UserCode, c.DataPowerCode ,c.DataPowerName,c.TBCODE ,
          c.OptID  ,c.IsInclude ,c.FilterRelation ,c.PowerDesc,
          d.ParamsNo, d.COLCODE, d.FilterType, d.DataType , d.AccessType, d.ParamValue
 from F_USERROLE a  join F_ROLEDATA   b on (a.RoleCode=b.RoleCode)
       join F_ROLEDATASCOPE  c on(b.DataPowerCode=c.DataPowerCode)
       join F_ROLEDATAFILTER  d  on(c.DataPowerCode=d.DataPowerCode );

CREATE OR REPLACE VIEW F_V_LASTVERTIONFLOW AS
SELECT WFCODE,VERSION,WFNAME,WFCLASS,WFSTATE,WFDESC,WFXMLDESC,WFPUBLISHDATE,OPTID,TIMELIMIT,EXPIREOPT,ATPUBLISHDATE 
FROM WF_FLOW_DEFINE WHERE (WFCODE,VERSION) IN (SELECT WF.WFCODE,MAX(WF.VERSION) AS VERSION 
FROM  WF_FLOW_DEFINE WF GROUP BY WF.WFCODE);

*/













