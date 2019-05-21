-- Create table
create table OPT_DOBASIC_MESSAGE
(
  dobasicid   VARCHAR2(32) not null,
  internalno  VARCHAR2(32),
  zwfwzx_code VARCHAR2(32),
  expressid   VARCHAR2(32)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_DOBASIC_MESSAGE
  add constraint PK_OPT_DOBASIC_MESSAGE primary key (DOBASICID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

-- Create table
create table OPT_DOUBLE_ITEMS
(
  itemid         VARCHAR2(32) not null,
  applydate      DATE,
  applyarea      VARCHAR2(100),
  enterprisename VARCHAR2(1000),
  options        VARCHAR2(1000),
  itemname       VARCHAR2(200),
  itemnumber     VARCHAR2(32),
  applynumber    VARCHAR2(16),
  linkman        VARCHAR2(100),
  applyphone     VARCHAR2(16),
  remark         CLOB,
  county         VARCHAR2(32),
  district       VARCHAR2(64)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 640K
    next 1M
    minextents 1
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_DOUBLE_ITEMS
  add constraint PK_OPT_DOUBLE_ITEMS primary key (ITEMID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
  );
-- Create table
create table OPT_EXPRESS_MESSAGE
(
  expressid   VARCHAR2(32) not null,
  emsordno    VARCHAR2(30),
  govtbname   VARCHAR2(30),
  posttype    VARCHAR2(1),
  nettype     VARCHAR2(1),
  busstype    VARCHAR2(1),
  sendname    VARCHAR2(20),
  rcvname     VARCHAR2(30),
  item        VARCHAR2(200),
  chkcode     VARCHAR2(6),
  issend      VARCHAR2(1),
  showmore    VARCHAR2(2000),
  expresstime DATE,
  sendprov    VARCHAR2(10),
  sendcity    VARCHAR2(10),
  sendcountry VARCHAR2(10),
  sendstrect  VARCHAR2(200),
  sendphone   VARCHAR2(15),
  sendcall    VARCHAR2(30),
  rcvprov     VARCHAR2(10),
  rcvcity     VARCHAR2(10),
  rcvcountry  VARCHAR2(10),
  rcvstrect   VARCHAR2(200),
  rcvphone    VARCHAR2(11),
  rcvcall     VARCHAR2(30),
  rcvpostcode VARCHAR2(20),
  state       VARCHAR2(1),
  djid        VARCHAR2(32)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_EXPRESS_MESSAGE
  add constraint PK_OPT_EXPRESS_MESSAGE primary key (EXPRESSID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
-- Create table
create table OPT_SEND_MESSAGE
(
  sendid       VARCHAR2(32) not null,
  sendname     VARCHAR2(20),
  sendprov     VARCHAR2(10),
  sendcity     VARCHAR2(10),
  send_country VARCHAR2(10),
  sendstrect   VARCHAR2(200),
  sendphone    VARCHAR2(15),
  sendcall     VARCHAR2(30)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_SEND_MESSAGE
  add constraint PK_OPT_SEND_MESSAGE primary key (SENDID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create table
create table OPT_PICKUP_MESSAGE
(
  pickupid    VARCHAR2(32) not null,
  rcvname     VARCHAR2(20),
  rcvprov     VARCHAR2(10),
  rcvcity     VARCHAR2(10),
  rcvcountry  VARCHAR2(10),
  rcvstrect   VARCHAR2(200),
  rcvphone    VARCHAR2(11),
  rcvcall     VARCHAR2(30),
  rcvpostcode VARCHAR2(20),
  djid        VARCHAR2(32)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_PICKUP_MESSAGE
  add constraint PK_OPT_PICKUP_MESSAGE primary key (PICKUPID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

  create or replace view v_opt_apply_task_list as
select rownum as taskid, t.WFINSTID,t.WFOPTNAME,t.WFOPTTAG,t.NODEINSTID,t.UNITCODE,t.USERCODE,
       t.ROLETYPE,t.ROLECODE,t.AUTHDESC,t.NODENAME,t.NODETYPE,t.NODEOPTTYPE,t.OPTID,t.OPTNAME,
       t.METHODNAME,t.OPTURL,t.OPTMETHOD,t.OPTPARAM,t.OPTDESC,t.CREATETIME,t.PROMISETIME,
       t.TIMELIMIT,t.EXPIREOPTSIGN,t.OPTCODE,t.EXPIREOPT,t.FLOWPHASE,t.GRANTOR,t.LASTUPDATEUSER,t.LASTUPDATETIME,t.inststate,e.dj_id,e.transaffairname,e.bizstate,e.biztype,e.orgcode,e.orgname,e.headunitcode,e.headusercode,e.content,e.powerid,e.powername,e.solvestatus,e.solvetime,e.solvenote,e.createuser,e.createdate,e.optno,e.optquerykey,e.risktype,e.riskdesc,e.riskresult,e.transaffairno,e.transaffairquerykey,e.sendarchiveno,e.acceptarchiveno,a.apply_item_type,a.proposer_name
    from v_user_task_list t
    left join opt_base_info e on t.WFINSTID=e.flowinstid,opt_apply_info a
   where t.OPTID =e.optid and e.dj_id = a.dj_id;
 
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('busstype', '收费类型', 'U', 'L', '收费类型', null, '0', null);

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('nettype', '寄件内容类型', 'U', 'L', '寄件内容类型', null, '0', null);

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('posttype', '邮寄类型', 'U', 'L', '邮寄类型', null, '0', null);

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('reportstate', '上报状态', 'U', 'L', '上报状态', null, '0', null);

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('status', '物流状态', 'U', 'L', '物流状态', null, '0', null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('status', 'A', '1', '1', 'T', '已收件', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('status', 'B', '2', '2', 'T', '已收寄', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('status', 'E', '4', '4', 'T', '投递中', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('status', 'D', '3', '3', 'T', '运输中', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('status', 'F', '6', '6', 'T', '寄件人已签收（退回）', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '0', '1', '1', 'T', '成功', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '1', '2', '2', 'T', '数据保存错误', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '2', '3', '3', 'T', '必填字段为空或无效', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '3', '4', '4', 'T', '发送字段格式错误或字符超出定义长度', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '4', '5', '5', 'T', '其他未知错误', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reportstate', '5', '6', '6', 'T', '重复数据', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('posttype', '1', '1', '1', 'T', '政务服务中心邮寄', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('posttype', '2', '2', '2', 'T', '行政相对人邮寄', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('nettype', '1', '1', '1', 'T', '申请材料寄送', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('nettype', '2', '2', '2', 'T', '审批结果寄送', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('busstype', '1', '1', '1', 'T', '寄件人付费', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('busstype', '2', '2', '2', 'T', '收件人付费', null, null);

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('EMSPARAM', 'emswebservice参数设置', 'U', 'L', 'emswebservice参数设置', null, '0', null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('EMSPARAM', 'KEY', '4', null, 'T', 'GOV17EMS', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('EMSPARAM', 'PATH', '3', null, null, 'onlineGovEMS/services/CityToGovService', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('EMSPARAM', 'PORT', '2', null, null, '8086', null, null);

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('EMSPARAM', 'URL', '1', null, 'T', '218.2.177.210', null, null);

--修改文件目录：com.centit.webserice.*; com.centit.poerruntime.*
 