-- Create table
create table B_POWER_ITEM
(
  ITEM_ID       VARCHAR2(32) not null,
  ITEM_NAME     VARCHAR2(500) not null,
  ITEM_TYPE     VARCHAR2(2) not null,
  ITEM_STATUS   VARCHAR2(1) not null,
  PARENT_ID     VARCHAR2(32),
  ISCONTAINSUB  VARCHAR2(1),
  ORGID         VARCHAR2(10),
  SP_OBJECT     VARCHAR2(200),
  USE_LEVEL     VARCHAR2(200),
  USE_UNIT      VARCHAR2(500),
  LINK_PHONE    VARCHAR2(100),
  MONITOR_PHONE VARCHAR2(100),
  HTTP_URL      VARCHAR2(500),
  DEAL_ADDRESS  VARCHAR2(500),
  DEAL_TIME     VARCHAR2(200),
  LAW_ACCORDING CLOB,
  REMARK        CLOB,
  PARENT_NAME   VARCHAR2(500),
  CREATE_TIME   DATE,
  MODIFY_TIME   DATE,
  ISNETWORK     VARCHAR2(1)
);
-- Add comments to the columns 
comment on column B_POWER_ITEM.ITEM_ID
  is '事项序号';
comment on column B_POWER_ITEM.ITEM_NAME
  is '事项名称';
comment on column B_POWER_ITEM.ITEM_TYPE
  is '许可01，处罚02，强制03，征收04，给付05，奖励06，确认07，裁决08，征用09，其它10';
comment on column B_POWER_ITEM.ITEM_STATUS
  is '新增1，在用2，挂起3，废止4（根据情况调整状态）';
comment on column B_POWER_ITEM.PARENT_ID
  is '主事项id(子项需填写)';
comment on column B_POWER_ITEM.ISCONTAINSUB
  is '主项是否包含子项：是1，不是2；当为null时表示是子项';
comment on column B_POWER_ITEM.ORGID
  is '所属部门（f_unitinfo的depno）';
comment on column B_POWER_ITEM.SP_OBJECT
  is '审批对象';
comment on column B_POWER_ITEM.USE_LEVEL
  is '行使层级';
comment on column B_POWER_ITEM.USE_UNIT
  is '办理处室';
comment on column B_POWER_ITEM.LINK_PHONE
  is '联系电话';
comment on column B_POWER_ITEM.MONITOR_PHONE
  is '监督电话';
comment on column B_POWER_ITEM.HTTP_URL
  is '网上申报链接';
comment on column B_POWER_ITEM.DEAL_ADDRESS
  is '办理地点';
comment on column B_POWER_ITEM.DEAL_TIME
  is '办理时间';
comment on column B_POWER_ITEM.LAW_ACCORDING
  is '设定依据';
comment on column B_POWER_ITEM.REMARK
  is '备注';
comment on column B_POWER_ITEM.PARENT_NAME
  is '主事项名称（子项需填写）';
comment on column B_POWER_ITEM.CREATE_TIME
  is '创建时间';
comment on column B_POWER_ITEM.MODIFY_TIME
  is '修改时间';
comment on column B_POWER_ITEM.ISNETWORK
  is '是否网上公示：1是，2不是';
-- Create/Recreate primary, unique and foreign key constraints 
alter table B_POWER_ITEM
  add constraint B_POWER_ITEM_PK primary key (ITEM_ID);
  
-- Create table
create table B_POWER_ITEM_SERVICE
(
  ITEM_ID              VARCHAR2(34) not null,
  ORG_ID               VARCHAR2(10) not null,
  ITEM_NAME            VARCHAR2(1000) not null,
  ITEM_STA_NAME        VARCHAR2(1000),
  ITEM_TYPE            VARCHAR2(2) not null,
  TIME_LIMIT           NUMBER(8),
  IS_NETWORK           CHAR(1),
  IS_FORMULA           CHAR(1),
  PHONE                VARCHAR2(1000),
  ADDRESS              VARCHAR2(2000),
  LASTMODIFYTIME       DATE,
  FILE_NAME            VARCHAR2(200),
  AUDIT_SIGN           VARCHAR2(1000),
  MONITOR_PHONE        VARCHAR2(200),
  ACCEPT_LINK          VARCHAR2(500),
  LEGAL_TIME_LIMIT     NUMBER(8),
  CHARGE               VARCHAR2(2000),
  FORM_NAME            VARCHAR2(200),
  IN_FLOW_IMG_NAME     VARCHAR2(200),
  ISCHARGE             CHAR(1),
  TRANSACT_DEPNAME     VARCHAR2(400),
  PROMISE_TYPE         VARCHAR2(2),
  ANTICIPATE_TYPE      VARCHAR2(2),
  QL_DEPID             VARCHAR2(10),
  QL_DEPSTATE          CHAR(1),
  ENTRUST_NAME         VARCHAR2(200),
  QL_STATE             CHAR(1),
  VERSION              NUMBER(6) not null,
  BEGIN_TIME           DATE,
  END_TIME             DATE,
  PROCESS_DESC         BLOB,
  ZF_ACCORDING         CLOB,
  XW_ACCORDING         CLOB,
  SRV_DIRECTORY        CLOB,
  APPLY_FORM           BLOB,
  QUESTION             CLOB,
  REMARK               CLOB,
  FREE_JUDGE           CLOB,
  LEVY_UPON            CLOB,
  CONDITION            CLOB,
  IN_FLOW_INFO         CLOB,
  IN_FLOW_IMG          BLOB,
  CHARGE_BASIS         CLOB,
  CHARGE_STANDARD      CLOB,
  ACCEPT_CONDITION     CLOB,
  PUNISHOBJECT         NUMBER(1),
  PUNISHBASISCONTENT   CLOB,
  PUNISHBASIS          VARCHAR2(1000),
  ISLAWSUIT            CHAR(1),
  ISRECONSIDER         CHAR(1),
  PUNISH_CLASS         CLOB,
  DIS_STANDARD         CLOB,
  DIS_DETAIL           CLOB,
  ACCEPT_DEPNAME       VARCHAR2(400),
  COMPATIBLE_TYPE      CHAR(1),
  ACCEPT_TIME_SCOPE    VARCHAR2(100),
  PROCESS_WORK_DESC    CLOB,
  APPLY_FORM_DEMO      BLOB,
  STATE_QUERY_URL      VARCHAR2(200),
  RESULT_QUERY_URL     VARCHAR2(200),
  REGULATORY_MEASURES  CLOB,
  HAS_ITEM             CHAR(1),
  SRV_DIRECTORY_STUFF  BLOB,
  ITEM_CLASS           VARCHAR2(2),
  APPLY_MATERIAL       CLOB,
  RISK                 CLOB,
  OUT_ITEM_ID          VARCHAR2(20),
  APPLY_FORM_DEMO_NAME VARCHAR2(200),
  BPOWERITEMID         VARCHAR2(32),
  BPOWERITEMNAME       VARCHAR2(1000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table B_POWER_ITEM_SERVICE
  add constraint PK_B_POWER_ITEM_SERVICE primary key (VERSION, ITEM_ID);  
-- Create table
create table B_POWER_ITEM_QLDY
(
  SERVICEID         VARCHAR2(34) not null,
  SERVICENAME       VARCHAR2(500),
  ITEM_MAIN_ID      VARCHAR2(32),
  ITEM_MAIN_NAME    VARCHAR2(500),
  ITEM_SUB_ID       VARCHAR2(32),
  ITEM_SUB_NAME     VARCHAR2(500),
  ITEM_QLDY_POWERID VARCHAR2(50),
  STATUS            VARCHAR2(1)
);
-- Add comments to the columns 
comment on column B_POWER_ITEM_QLDY.SERVICEID
  is '业务项编码';
comment on column B_POWER_ITEM_QLDY.SERVICENAME
  is '业务项名称';
comment on column B_POWER_ITEM_QLDY.ITEM_MAIN_ID
  is '主项编码';
comment on column B_POWER_ITEM_QLDY.ITEM_MAIN_NAME
  is '主项名称';
comment on column B_POWER_ITEM_QLDY.ITEM_SUB_ID
  is '子项编码';
comment on column B_POWER_ITEM_QLDY.ITEM_SUB_NAME
  is '子项名称';
comment on column B_POWER_ITEM_QLDY.ITEM_QLDY_POWERID
  is '对应b_power中的item_id';
comment on column B_POWER_ITEM_QLDY.STATUS
  is '新增1，在用2，挂起3，废止4（根据情况调整状态）';
-- Create/Recreate primary, unique and foreign key constraints 
alter table B_POWER_ITEM_QLDY
  add constraint BPOWERITEMQLDY_PK primary key (SERVICEID); 
  
create or replace view v_poweritemservicewithoutlob as
select
   ITEM_ID,
   version,
   begin_time,
   end_time,
   ORG_ID,
   ITEM_NAME,
   ITEM_STA_NAME,
   ITEM_TYPE,
   TIME_LIMIT,
   IS_NETWORK,
   IS_FORMULA,
   PHONE,
   ADDRESS,
   LASTMODIFYTIME,
   audit_Sign,
   MONITOR_PHONE,
   ACCEPT_LINK,
   LEGAL_TIME_LIMIT,
   CHARGE,
   FORM_NAME,
   file_name,
   In_Flow_img_Name,
   ISCHARGE,
   PUNISH_CLASS,
   Transact_DEPNAME,
   Promise_Type,
   Anticipate_Type,
   QL_DepID,
   QL_DepState,
   ENTRUST_Name,
   QL_State
from
   b_power_item_service;
comment on column V_POWERITEMSERVICEWITHOUTLOB.BEGIN_TIME is '版本正式启用时间';
comment on column V_POWERITEMSERVICEWITHOUTLOB.END_TIME is '本版本停用时间（或者下一版本启用时间）';
comment on column V_POWERITEMSERVICEWITHOUTLOB.ORG_ID is '这个字段应该没有用了，在界面中可以不用显示(所属部门)';
comment on column V_POWERITEMSERVICEWITHOUTLOB.ITEM_TYPE is 'XK：行政许可、CF：行政处罚、QZ：行政强制、ZS：行政征收、SP：非许可审批、GF：行政给付、JL：行政奖励、QR：行政确认、ZY：行政征用、CJ：行政裁决、QT：其他';
comment on column V_POWERITEMSERVICEWITHOUTLOB.IS_NETWORK is '0: 否
1：是';
comment on column V_POWERITEMSERVICEWITHOUTLOB.IS_FORMULA is '0: 否
1：是';
comment on column V_POWERITEMSERVICEWITHOUTLOB.AUDIT_SIGN is '这个有什么用啊';
comment on column V_POWERITEMSERVICEWITHOUTLOB.QL_DEPSTATE is '1：法定；2：授权；3：受委托';
comment on column V_POWERITEMSERVICEWITHOUTLOB.QL_STATE is 'A：在用(正常状态)、N 新版本未启用 、U 已升级  T：挂起、X：废止  ';

create or replace view v_poweritemservicechange as
select
s.ITEM_ID ,s.version , s.begin_time , s.end_time   , s.ORG_ID  ,
s.ITEM_NAME   ,s.ITEM_STA_NAME  ,s.ITEM_TYPE , s.TIME_LIMIT  ,s.IS_NETWORK,
s.IS_FORMULA , s.PHONE, s.ADDRESS , s.LASTMODIFYTIME ,s.audit_Sign ,
MONITOR_PHONE ,ACCEPT_LINK , LEGAL_TIME_LIMIT  , s.CHARGE  , s.FORM_NAME  ,
s.file_name ,s.In_Flow_img_Name  , s.ISCHARGE  ,s.PUNISH_CLASS  , s.Transact_DEPNAME ,
s.Promise_Type , s.Anticipate_Type , s. QL_DepID  , s.QL_DepState , s.ENTRUST_Name ,
s.QL_State,B_PowerChgLog.reply_people,B_PowerChgLog.auditor,B_PowerChgLog.requester,chg_type,
B_PowerChgLog.Request_Time,B_PowerChgLog.Chg_Reason,B_PowerChgLog.Chg_Content,B_PowerChgLog.Chg_Result,B_PowerChgLog.Reply_Time,B_PowerChgLog.reply_content,
B_PowerChgLog.Audit_Time,B_PowerChgLog.Audit_Content,B_PowerChgLog.Change_Id,B_PowerChgLog.beginTime
from B_PowerChgLog
left join B_power_item_service s on s.item_id=B_PowerChgLog.item_id and s.version=B_PowerChgLog.version
where 1=1  and B_PowerChgLog.reply_people is  null;

create or replace view v_poweritemserviceinusing as
select
a.ITEM_ID ,a.version , a.begin_time , a.end_time   , a.ORG_ID  ,
a.ITEM_NAME   ,a.ITEM_STA_NAME  ,a.ITEM_TYPE , a.TIME_LIMIT  ,a.IS_NETWORK,
a.IS_FORMULA , a.PHONE, ADDRESS , a.LASTMODIFYTIME ,a.audit_Sign ,
a.MONITOR_PHONE ,a.ACCEPT_LINK , a.LEGAL_TIME_LIMIT  , a.CHARGE  , a.FORM_NAME  ,
a.file_name ,a.In_Flow_img_Name  , a.ISCHARGE  ,a.PUNISH_CLASS  , a.Transact_DEPNAME ,
a.Promise_Type , a.Anticipate_Type ,  a.QL_DepID  ,a. QL_DepState , a.ENTRUST_Name ,
a.QL_State,a.PunishBasis,a.PunishBasisContent,a.punishobject, nvl(substr(a.QL_DepID, 9), 'QT') as QL_DepType, nvl(substr(a.ITEM_ID, 0, 13), 'error') as item_id_ex
from b_Power_item_service a
--where QL_State = 'A' and version > 0 and begin_time <= sysdate and (end_time is null or end_time > sysdate)
;

alter table B_POWERCHGLOG modify ITEM_ID VARCHAR2(34);
alter table B_FreeUmpireDegree modify ITEM_ID VARCHAR2(34);
alter table B_PUNISHSTANDARD modify ITEM_ID VARCHAR2(34);
alter table C_POWER_ORG_INFO modify ITEM_ID VARCHAR2(34);
alter table s_power_risk modify ITEM_ID VARCHAR2(34);
alter table B_PowerStateChgLog modify ITEM_ID VARCHAR2(34);

insert into F_DATACATALOG (catalogcode,catalogname,catalogstyle,catalogtype,catalogdesc,isupload)
values('ITEM_TYPE_NEW','事项类型','U','L','事项类型','0');

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '01',null, null, 'T', '许可', null, null);

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '02', null, null, 'T', '处罚', null, null);

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '03', null, null, 'T', '强制', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '04', null, null, 'T', '征收', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '05', null, null, 'T', '给付', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '06', null, null, 'T', '奖励', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '07', null, null, 'T', '确认', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '08', null, null, 'T', '裁决', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '09', null, null, 'T', '征用', null, null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_TYPE_NEW', '10', null, null, 'T', '其它', null, null);


insert into F_DATACATALOG (catalogcode,catalogname,catalogstyle,catalogtype,catalogdesc,isupload)
values('ITEM_STATUS_NEW','事项状态','U','L','事项状态','0');

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_STATUS_NEW', '2',null, null, 'T', '在用', null, null);

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('ITEM_STATUS_NEW', '4', null, null, 'T', '已删除', null, null);




commit;
-- URL链接      /poweritem/bpowerItem!listBpowerItem.do?s_itemStatus=