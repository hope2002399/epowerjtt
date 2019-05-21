-- Create table
create table S_LAWEXECUTOR
(
  STAFFNO        VARCHAR2(20) not null,
  PASSCODE       VARCHAR2(30),
  STAFFNAME      VARCHAR2(20),
  SEX            VARCHAR2(6),
  NATION         VARCHAR2(6),
  IDCARD         VARCHAR2(18),
  POLITICS       VARCHAR2(6),
  EDUCATION      VARCHAR2(6),
  DEPTID         VARCHAR2(10),
  POSITION       VARCHAR2(50),
  TELEPHONE      VARCHAR2(30),
  PLAIT          VARCHAR2(100),
  GETPASSTIME    DATE,
  ISSUEDDEPT     VARCHAR2(50),
  EXECUTIONAREA  VARCHAR2(100),
  EXECUTIONCLASS VARCHAR2(100),
  EXECUTIONJOB   VARCHAR2(100),
  CHANGEPASSTIME DATE,
  PASSLIFE       DATE,
  MEMO           VARCHAR2(100),
  INPUTTIME      DATE,
  OPERATOR       VARCHAR2(6),
  STATUS         VARCHAR2(6),
  REPAIRDATE     DATE,
  CARDPHOTO      BLOB,
  CARDKIND       INTEGER,
  STAFFSTATUS    VARCHAR2(10),
  IF_RECORDNO    VARCHAR2(50),
  IF_DEPTCODE    VARCHAR2(10),
  DEPTNAME       VARCHAR2(100),
  HASEXPORT      VARCHAR2(1),
  DSOURCE        CHAR(1),
  RE_REASON      VARCHAR2(500),
  EXPORT_DATE    DATE,
  EXPTOWEB       VARCHAR2(1),
  EXPTOWEBTIME   DATE
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
comment on column S_LAWEXECUTOR.STAFFNO
  is '流水号';
comment on column S_LAWEXECUTOR.PASSCODE
  is '证件号码';
comment on column S_LAWEXECUTOR.STAFFNAME
  is '姓名';
comment on column S_LAWEXECUTOR.SEX
  is '性别';
comment on column S_LAWEXECUTOR.NATION
  is '民族';
comment on column S_LAWEXECUTOR.IDCARD
  is '身份证号';
comment on column S_LAWEXECUTOR.POLITICS
  is '政治面貌';
comment on column S_LAWEXECUTOR.EDUCATION
  is '学历';
comment on column S_LAWEXECUTOR.DEPTID
  is '执法主体';
comment on column S_LAWEXECUTOR.POSITION
  is '职务';
comment on column S_LAWEXECUTOR.TELEPHONE
  is '电话';
comment on column S_LAWEXECUTOR.PLAIT
  is '编制情况';
comment on column S_LAWEXECUTOR.GETPASSTIME
  is '发证时间';
comment on column S_LAWEXECUTOR.ISSUEDDEPT
  is '发证部门';
comment on column S_LAWEXECUTOR.EXECUTIONAREA
  is '执法区域';
comment on column S_LAWEXECUTOR.EXECUTIONCLASS
  is '执法种类';
comment on column S_LAWEXECUTOR.EXECUTIONJOB
  is '职级';
comment on column S_LAWEXECUTOR.CHANGEPASSTIME
  is '执法证变更时间';
comment on column S_LAWEXECUTOR.PASSLIFE
  is '有效期';
comment on column S_LAWEXECUTOR.MEMO
  is '备注';
comment on column S_LAWEXECUTOR.INPUTTIME
  is '录入时间';
comment on column S_LAWEXECUTOR.OPERATOR
  is '录入人员';
comment on column S_LAWEXECUTOR.STATUS
  is '状态';
comment on column S_LAWEXECUTOR.REPAIRDATE
  is '修改日期';
comment on column S_LAWEXECUTOR.CARDPHOTO
  is '证件照片';
comment on column S_LAWEXECUTOR.CARDKIND
  is '证件种类';
comment on column S_LAWEXECUTOR.STAFFSTATUS
  is '执法人员状态';
comment on column S_LAWEXECUTOR.IF_RECORDNO
  is '接口表中的ID';
comment on column S_LAWEXECUTOR.IF_DEPTCODE
  is '接口表中的报备部门';
comment on column S_LAWEXECUTOR.HASEXPORT
  is '导出标识';
comment on column S_LAWEXECUTOR.DSOURCE
  is '数据来源';
comment on column S_LAWEXECUTOR.RE_REASON
  is '回退原因';
-- Create/Recreate primary, unique and foreign key constraints 
alter table S_LAWEXECUTOR
  add constraint PK_LAWEXECUTOR primary key (STAFFNO)
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
-- Create/Recreate indexes 
create index IND_LAWEXECUTOR on S_LAWEXECUTOR (DEPTID, CARDKIND, STATUS)
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
