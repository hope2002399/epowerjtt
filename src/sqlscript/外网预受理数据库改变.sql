--新增表    ： opt_apply_info_net、opt_base_info_net、opt_stuff_info_net
-- Create table
create table OPT_APPLY_INFO_NET
(
  NET_ID              VARCHAR2(64) not null,
  DJ_ID               VARCHAR2(32),
  APPLY_DATE          DATE,
  PROPOSER_NAME       VARCHAR2(64),
  APPLY_ITEM_TYPE     VARCHAR2(4),
  APPLY_REASON        VARCHAR2(1024),
  APPLY_WAY           VARCHAR2(2),
  PROPOSER_TYPE       VARCHAR2(2),
  PROPOSER_PAPER_TYPE VARCHAR2(2),
  PROPOSER_PAPER_CODE VARCHAR2(32),
  PROPOSER_PHONE      VARCHAR2(32),
  PROPOSER_MOBILE     VARCHAR2(64),
  PROPOSER_ADDR       VARCHAR2(256),
  PROPOSER_ZIPCODE    VARCHAR2(6),
  PROPOSER_EMAIL      VARCHAR2(128),
  PROPOSER_UNITCODE   VARCHAR2(64),
  AGENT_NAME          VARCHAR2(64),
  AGENT_PAPER_TYPE    VARCHAR2(2),
  AGENT_PAPER_CODE    VARCHAR2(32),
  AGENT_PHONE         VARCHAR2(32),
  AGENT_MOBILE        VARCHAR2(64),
  AGENT_ADDR          VARCHAR2(256),
  AGENT_ZIPCODE       VARCHAR2(6),
  AGENT_EMAIL         VARCHAR2(128),
  AGENT_UNITCODE      VARCHAR2(6),
  APPLY_MEMO          VARCHAR2(512),
  ACCEPT_DATE         DATE,
  AUDITING_DATE       DATE,
  HEAD_USERCODE       VARCHAR2(32),
  HEAD_AUDITING_IDEA  VARCHAR2(256),
  CHECK_IDEA_DATE     DATE,
  CHECK_USERCODE      VARCHAR2(32),
  CHECK_IDEA          VARCHAR2(256),
  CHECK_DETAIL        VARCHAR2(256),
  CHECK_ADDR          VARCHAR2(256),
  CHECK_DATE          DATE,
  CHECK_MEMO          VARCHAR2(512),
  BOOK_DATE           DATE,
  LEGAL_PERSON        VARCHAR2(64)
);
-- Add comments to the columns 
comment on column OPT_APPLY_INFO_NET.NET_ID
  is '办件信息外网登记id';
comment on column OPT_APPLY_INFO_NET.DJ_ID
  is '办件信息内网登记id';
comment on column OPT_APPLY_INFO_NET.APPLY_ITEM_TYPE
  is '对应权力表的申请事项类别，作为业务数据分类';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_APPLY_INFO_NET
  add constraint PK_OPT_APPLY_INFO_NET primary key (NET_ID);

  
  -- Create table
create table OPT_BASE_INFO_NET
(
  NET_ID              VARCHAR2(64) not null,
  DJ_ID               VARCHAR2(32),
  FLOWINSTID          NUMBER(12),
  TRANSAFFAIRNAME     VARCHAR2(200),
  BIZSTATE            CHAR(1),
  BIZTYPE             VARCHAR2(8),
  ORGCODE             VARCHAR2(6),
  ORGNAME             VARCHAR2(100),
  HEADUNITCODE        VARCHAR2(6),
  HEADUSERCODE        VARCHAR2(8),
  CONTENT             VARCHAR2(200),
  POWERID             VARCHAR2(100),
  POWERNAME           VARCHAR2(200),
  SOLVESTATUS         VARCHAR2(4),
  SOLVETIME           DATE,
  SOLVENOTE           VARCHAR2(2000),
  CREATEUSER          VARCHAR2(8),
  CREATEDATE          DATE,
  OPTNO               VARCHAR2(60),
  OPTQUERYKEY         VARCHAR2(8),
  RISKTYPE            VARCHAR2(50),
  RISKDESC            VARCHAR2(200),
  RISKRESULT          VARCHAR2(200),
  TRANSAFFAIRNO       VARCHAR2(60),
  TRANSAFFAIRQUERYKEY VARCHAR2(8),
  OPTID               VARCHAR2(20),
  SENDARCHIVENO       VARCHAR2(128),
  ACCEPTARCHIVENO     VARCHAR2(128),
  CASENO              VARCHAR2(128),
  FLOWCODE            VARCHAR2(8),
  ISUPLOAD            CHAR(1),
  SIGN                VARCHAR2(1),
  SIGN2               VARCHAR2(1),
  CHARGE_ACCOUNT      VARCHAR2(400),
  RECEIVABLE          VARCHAR2(40),
  PAID                VARCHAR2(40),
  RELIEF_REASONS      VARCHAR2(4000),
  REMOTEADDR          VARCHAR2(40)
);
-- Add comments to the columns 
comment on column OPT_BASE_INFO_NET.NET_ID
  is '办件信息外网登记id';
comment on column OPT_BASE_INFO_NET.DJ_ID
  is '办件信息内网登记id';
comment on column OPT_BASE_INFO_NET.SOLVESTATUS
  is '字典选项：1：不予受理；2：许可/同意；3：不许可/不同意';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_BASE_INFO_NET
  add constraint PK_OPT_BASE_INFO_NET primary key (NET_ID);

  -- Create table
create table OPT_STUFF_INFO_NET
(
  STUFFID        VARCHAR2(32) not null,
  NET_ID         VARCHAR2(32) not null,
  STUFFNAME      VARCHAR2(256),
  STUFFCONTENT   BLOB,
  ISZHI          CHAR(1),
  FILENAME       VARCHAR2(150),
  NODEINSTID     NUMBER(12),
  UPLOADTIME     DATE,
  UPLOADUSERCODE VARCHAR2(8),
  NODENAME       VARCHAR2(50),
  FILETYPE       CHAR(1),
  ARCHIVETYPE    VARCHAR2(20),
  GROUPID        VARCHAR2(8),
  SORTID         VARCHAR2(8),
  ISUSE          CHAR(1),
  RECORDID       VARCHAR2(20),
  WSNO           VARCHAR2(128),
  ISUPLOAD       CHAR(1),
  SIGN           VARCHAR2(1)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_STUFF_INFO_NET
  add constraint PK_OPT_STUFF_INFO_NET primary key (STUFFID);

  
  --新增 view ：v_opt_apply_info_net;
  create or replace view v_opt_apply_info_net as
select a.net_id,a.dj_id,a.apply_date,a.proposer_name,a.apply_item_type,a.apply_reason,
a.apply_way,a.proposer_type,a.proposer_paper_type,a.proposer_paper_code,a.proposer_phone,a.proposer_mobile,a.proposer_addr,a.proposer_zipcode,a.proposer_email,
a.proposer_unitcode,a.agent_name,a.agent_paper_type,a.agent_paper_code,a.agent_phone,a.agent_mobile,a.agent_addr,a.agent_zipcode,a.agent_email,a.agent_unitcode,
a.apply_memo,a.accept_date,a.auditing_date,a.head_usercode,a.head_auditing_idea,a.check_idea_date,a.check_usercode,a.check_idea,a.check_detail,a.check_addr,
a.check_date,a.check_memo,a.book_date,b.transaffairno,b.transaffairname,b.orgcode,b.orgname,b.powerid,b.powername,b.biztype,substr(b.powerid, 12 ,2) item_type,b.bizstate
 from opt_apply_info_net a join opt_base_info_net b on a.net_id = b.net_id order by a.apply_date desc;

 
  
 --新增数据字典：YSLBIZSTATE，预受理处理状态
 --F 预受理未审查，T 预受理受理，W 预受理已删除
 insert into F_DATACATALOG (catalogcode,catalogname,catalogstyle,catalogtype,catalogdesc,isupload)
values('YSLBIZSTATE','预受理处理状态','U','L','预受理处理状态','0');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('YSLBIZSTATE', 'F', null, null, 'T', '预受理未审查', 'S', null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('YSLBIZSTATE', 'T', null, null, 'T', '预受理受理', 'S', null);
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('YSLBIZSTATE', 'W', null, null, 'T', '预受理已删除', 'S', null);

alter table opt_base_info_net add (sync_sign  varchar2(1),
                sync_date  date,
                sync_error_desc varchar2(1000));
 
 --新增配置链接：powerruntime/optApplyNet!list.do 外网预受理审查
 
 --20150515
 --OPT_BASE_INFO_NET增加一个字段yslblyj
 alter table opt_base_info_net add (
                yslblyj varchar2(4000));               
                
                