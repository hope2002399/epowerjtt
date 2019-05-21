drop table M_DISPATCH_DOC;

-- Create table
create table M_DISPATCH_DOC
(
  NO                     VARCHAR2(50) not null,
  INTERNAL_NO            VARCHAR2(100) not null,
  ITEM_ID                VARCHAR2(100) not null,
  DISPATCH_DOC_NO        VARCHAR2(100),
  DISPATCH_DOC_TITLE     VARCHAR2(200),
  DISPATCH_FILE_TYPE     VARCHAR2(2),
  DISPATCH_DOC_TYPE      VARCHAR2(2),
  DISPATCH_CAN_OPEN      CHAR(1),
  DISPATCH_OPEN_TYPE     CHAR(1),
  NOT_OPEN_REASON        VARCHAR2(2000),
  IS_UNION_DISPATCH      CHAR(1),
  UNION_OTHERS           VARCHAR2(1000),
  IS_COUNTERSIGN         CHAR(1),
  DISPATCH_DOC_SUMMARY   VARCHAR2(2000),
  DRAFT_DATE             DATE,
  OPT_UNIT_NAME          VARCHAR2(400),
  DRAFT_USER_NAME        VARCHAR2(50),
  SECRETS_DEGREE         VARCHAR2(2),
  COPIES                 NUMBER(6),
  MAIN_NOTIFY_UNIT       VARCHAR2(400),
  OTHER_UNITS            VARCHAR2(1000),
  RETENTION_PERIOD       DATE,
  CHECK_USER_NAME        VARCHAR2(50),
  DISPATCH_DOC_FILE      BLOB,
  CREATE_DATE            DATE not null,
  UPDATE_DATE            DATE not null,
  SYNC_DATE              DATE,
  SYNC_SIGN              VARCHAR2(1),
  SYNC_ERROR_DESC        VARCHAR2(1000),
  DISPATCH_DOC_FILE_NAME VARCHAR2(200),
  DISPATCH_DOC_RED       VARCHAR2(200),
  PRINT_DATE             DATE,
  CRITICAL_LEVEL         VARCHAR2(1),
  WFCODE                 VARCHAR2(8)
)
tablespace EPOWER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column M_DISPATCH_DOC.DISPATCH_FILE_TYPE
  is '1：一般公文  2：甬发改审批 3：甬物价审批
';
comment on column M_DISPATCH_DOC.DISPATCH_DOC_TYPE
  is '1、请示2、意见4、报告5、通知6、决定7、决议8、通报9、批复10、函11、纪要12、答复13、其它14、指示
';
comment on column M_DISPATCH_DOC.DISPATCH_CAN_OPEN
  is '1 是 2 否';
comment on column M_DISPATCH_DOC.DISPATCH_OPEN_TYPE
  is '数据字典   1、全文公开2、摘要公开 ';
comment on column M_DISPATCH_DOC.IS_UNION_DISPATCH
  is '1 是 2 否';
comment on column M_DISPATCH_DOC.UNION_OTHERS
  is '多个文号用'',''分开';
comment on column M_DISPATCH_DOC.IS_COUNTERSIGN
  is '1 是 2 否';
comment on column M_DISPATCH_DOC.SECRETS_DEGREE
  is '01、秘密02、机密03、绝密
';
comment on column M_DISPATCH_DOC.OTHER_UNITS
  is '多个单位'',''分开';
comment on column M_DISPATCH_DOC.SYNC_SIGN
  is '0－未同步
1－已同步
2－同步失败 ';
comment on column M_DISPATCH_DOC.DISPATCH_DOC_FILE_NAME
  is '包括文件扩展名， doc,pdf,docx 等等';
comment on column M_DISPATCH_DOC.CRITICAL_LEVEL
  is '数字字典 1：一般 2：紧急 3：特急
';


-- Create/Recreate indexes 
create index IND_DIS_DOC_INTERNALNO on M_DISPATCH_DOC (INTERNAL_NO, ITEM_ID)
  tablespace EPOWER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

 
drop table M_DOC_RELATIVE;
create table M_DOC_RELATIVE
(
  INCOME_NO     VARCHAR2(50) not null,
  DISPATCH_NO   VARCHAR2(50) not null,
  RELATIVE_TYPE CHAR(1),
  RELATIVE_DESC VARCHAR2(500)
)
tablespace EPOWER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column M_DOC_RELATIVE.RELATIVE_TYPE
  is 'A： 多个收文合并发文， B：收文的再次发文';
-- Create/Recreate primary, unique and foreign key constraints 
alter table M_DOC_RELATIVE
  add constraint PK_M_DOC_RELATIVE primary key (INCOME_NO, DISPATCH_NO)
  using index 
  tablespace EPOWER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

drop table M_INCOME_DOC;
-- Create table
create table M_INCOME_DOC
(
  NO                   VARCHAR2(50) not null,
  INTERNAL_NO          VARCHAR2(100) not null,
  ITEM_ID              VARCHAR2(100) not null,
  ACCEPT_NO            VARCHAR2(100),
  INCOME_DOC_NO        VARCHAR2(100),
  INCOME_DOC_TITLE     VARCHAR2(400),
  INCOME_DEPT_NAME     VARCHAR2(400),
  INCOME_DOC_FILE      BLOB,
  SYNC_ERROR_DESC      VARCHAR2(1000),
  CREATE_DATE          DATE not null,
  UPDATE_DATE          DATE not null,
  SYNC_DATE            DATE,
  SYNC_SIGN            VARCHAR2(1),
  INCOME_DOC_FILE_NAME VARCHAR2(200),
  WFCODE               VARCHAR2(8)
)
tablespace EPOWER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

 

create sequence S_DISPATCH_DOC
minvalue 1
maxvalue 999999999999999999999
start with 1
increment by 1
cache 20;


-- Create sequence 
create sequence S_INCOME_DOC
minvalue 1
maxvalue 999999999999999999999
start with 1
increment by 1
cache 20;
