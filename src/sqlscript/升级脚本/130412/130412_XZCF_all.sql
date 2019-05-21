------------------------------------------
-- Export file for user JTTXQ2          --
-- Created by hx on 2013-4-12, 17:34:43 --
------------------------------------------

--spool 处罚脚本（表、视图）.log
drop table APPENTERPRISE;
drop table APPINDIVIDUAL;
drop table PCDEF;
drop table PCFREEUMPIREDEGREE;
drop table PCTYPE;
drop table PCFREEUMPIRETYPE;
drop table POAPPROVEBASIC;
drop table PODETAINWPBASICINFO;
drop table PODETAINWPTRANSINFO;
drop table PODISCUSSBASIC;
drop table POENTERPRISE;
drop table POEXCUCEBASIC;
drop table POFINISHBASIC;
drop table POINDAGATEREPBASIC;
drop table POINDIVIDUAL;
drop table POPUNISHBASIC;
drop table PORADIXBASIC;
drop table PORECEIPTINFO;
drop table POREGISTERBASIC;
drop table PORESULTBASIC;
drop table POTRANSLAWBASIC;
drop table POUNDERTAKEBASIC;
drop table POUNWITNESSBASIC;
drop table POWITNESSBASIC;
drop table PUNISHOBJECTBASIC;

--prompt
--prompt Creating table APPENTERPRISE
--prompt ============================
--prompt
create table JTTXQ2.APPENTERPRISE
(
  ENTERPRISEID      VARCHAR2(10) not null,
  ENTERPRISENAME    VARCHAR2(200) not null,
  ENTERPRISECODE    VARCHAR2(64),
  ENTERPRISEADDRESS VARCHAR2(200),
  UNITTYPE          VARCHAR2(10),
  CORPDOMAIN        VARCHAR2(10),
  REGTYPE           VARCHAR2(10),
  MASTERNAME        VARCHAR2(200),
  POSTCODE          VARCHAR2(6),
  PHONE             VARCHAR2(20),
  LINKER            VARCHAR2(20),
  FAX               VARCHAR2(200),
  EMAIL             VARCHAR2(200),
  ISVIP             NUMBER(1),
  LASTUSEDATE       DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JTTXQ2.APPENTERPRISE
  add constraint PK_APPENTERPRISE primary key (ENTERPRISEID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table APPINDIVIDUAL
--prompt ============================
--prompt
create table JTTXQ2.APPINDIVIDUAL
(
  INDIVIDUALID     VARCHAR2(10) not null,
  INDIVIDUALNAME   VARCHAR2(200) not null,
  INDIVIDUALCODE   VARCHAR2(64),
  SEX              CHAR(1),
  AGE              NUMBER(8),
  INDIVIDUALADRESS VARCHAR2(200),
  WORKUNIT         VARCHAR2(100),
  POSTCODE         VARCHAR2(6),
  PHONE            VARCHAR2(32),
  EMAIL            VARCHAR2(200),
  LASTUSEDATE      DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JTTXQ2.APPINDIVIDUAL
  add constraint PK_APPINDIVIDUAL primary key (INDIVIDUALID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PCDEF
--prompt ====================
--prompt
create table JTTXQ2.PCDEF
(
  PUNISHCLASSID      VARCHAR2(8) not null,
  PUNISHCLASSNAME    VARCHAR2(200) not null,
  DEPID              NUMBER(8) not null,
  PUNISHCLASSCODE    VARCHAR2(18),
  PUNISHOBJECT       NUMBER(1),
  ISINUSE            NUMBER(1) default 1 not null,
  PUNISHBASISCONTENT CLOB,
  PUNISHBASIS        VARCHAR2(1000),
  REMARK             CLOB
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PCDEF
  is 'Punish Class Defination
保存行政处罚项目的相关信息，即法律、法规库。
';
comment on column JTTXQ2.PCDEF.PUNISHCLASSID
  is '8位,前面补零';
comment on column JTTXQ2.PCDEF.DEPID
  is '外键，引用部门表';
comment on column JTTXQ2.PCDEF.PUNISHCLASSCODE
  is '处罚权力编码';
comment on column JTTXQ2.PCDEF.PUNISHOBJECT
  is '0：个人；
1：机构';
comment on column JTTXQ2.PCDEF.ISINUSE
  is '1:使用中
0:弃用';
alter table JTTXQ2.PCDEF
  add constraint PK_PCDEF primary key (PUNISHCLASSID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PCFREEUMPIREDEGREE
--prompt =================================
--prompt
create table JTTXQ2.PCFREEUMPIREDEGREE
(
  PUNISHCLASSID   VARCHAR2(8) not null,
  DEGREENO        NUMBER(8) not null,
  ISINUSE         NUMBER(1) not null,
  PUNISHFACTGRADE VARCHAR2(100),
  PUNISHBASIS     CLOB,
  STANDARD_NO     VARCHAR2(50)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PCFREEUMPIREDEGREE
  is 'Punish Class Free Umpire Degree
保存各行政处罚项目的自由裁量标准分为多少违法事实程度。
';
comment on column JTTXQ2.PCFREEUMPIREDEGREE.PUNISHCLASSID
  is '引用PCDef表';
comment on column JTTXQ2.PCFREEUMPIREDEGREE.ISINUSE
  is '1:使用中
0:弃用
';
alter table JTTXQ2.PCFREEUMPIREDEGREE
  add constraint PK_PCFREEUMPIREDEGREE primary key (PUNISHCLASSID, DEGREENO)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PCTYPE
--prompt =====================
--prompt
create table JTTXQ2.PCTYPE
(
  PUNISHCLASSID VARCHAR2(8) not null,
  PUNISHTYPEID  VARCHAR2(10) not null,
  ISINUSE       NUMBER(5) not null,
  PUNISHMAX     VARCHAR2(200),
  PUNISHMIN     VARCHAR2(200),
  ISRATE        NUMBER(1),
  CHARGEMAX     VARCHAR2(20),
  RADIXNAME     VARCHAR2(20),
  RADIXUNIT     VARCHAR2(20),
  PUNISHCONTENT CLOB
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PCTYPE
  is 'Punish Class Type
保存各行政处罚项目可用的处罚方式。
';
comment on column JTTXQ2.PCTYPE.PUNISHCLASSID
  is '外键，引用PCDef表';
comment on column JTTXQ2.PCTYPE.PUNISHTYPEID
  is '引用公共代码表';
comment on column JTTXQ2.PCTYPE.ISINUSE
  is '1:使用中
0:弃用';
comment on column JTTXQ2.PCTYPE.ISRATE
  is '0:没有比例
1:有比例';
alter table JTTXQ2.PCTYPE
  add constraint PK_PCTYPE primary key (PUNISHCLASSID, PUNISHTYPEID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PCFREEUMPIRETYPE
--prompt ===============================
--prompt
create table JTTXQ2.PCFREEUMPIRETYPE
(
  PUNISHCLASSID VARCHAR2(8) not null,
  DEGREENO      NUMBER(8) not null,
  PUNISHTYPEID  VARCHAR2(10) not null,
  ISINUSE       NUMBER(1) not null,
  PUNISHMAX     VARCHAR2(200),
  PUNISHMIN     VARCHAR2(200),
  ISRATE        NUMBER(1),
  RADIXNAME     VARCHAR2(20),
  RADIXUNIT     VARCHAR2(20),
  PUNISHCONTENT CLOB,
  STANDARD_NO   VARCHAR2(50)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PCFREEUMPIRETYPE
  is 'Punish Class Free Umpire Type
保存各项目自由裁量标准库中，各种违法事实程度下可用的处罚形式。
';
comment on column JTTXQ2.PCFREEUMPIRETYPE.PUNISHCLASSID
  is '引用PCFreeUmpireDegree表';
comment on column JTTXQ2.PCFREEUMPIRETYPE.DEGREENO
  is '引用PCFreeUmpireDegree表';
comment on column JTTXQ2.PCFREEUMPIRETYPE.PUNISHTYPEID
  is '引用公共代码表';
comment on column JTTXQ2.PCFREEUMPIRETYPE.ISINUSE
  is '1:使用中
0:弃用
';
alter table JTTXQ2.PCFREEUMPIRETYPE
  add constraint PK_PCFREEUMPIRETYPE primary key (PUNISHCLASSID, DEGREENO, PUNISHTYPEID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JTTXQ2.PCFREEUMPIRETYPE
  add constraint FK_PCTYPE foreign key (PUNISHCLASSID, PUNISHTYPEID)
  references JTTXQ2.PCTYPE (PUNISHCLASSID, PUNISHTYPEID);


--prompt
--prompt Creating table POAPPROVEBASIC
--prompt =============================
--prompt
create table JTTXQ2.POAPPROVEBASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  POAPPROVESTEP  NUMBER(1) not null,
  ISPASS         NUMBER(1) not null
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POAPPROVEBASIC
  is '保存行政处罚审批的信息';
comment on column JTTXQ2.POAPPROVEBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table JTTXQ2.POAPPROVEBASIC
  add constraint PK_POAPPROVEBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PODETAINWPBASICINFO
--prompt ==================================
--prompt
create table JTTXQ2.PODETAINWPBASICINFO
(
  PUNISHOBJECTID    VARCHAR2(16),
  WPID              VARCHAR2(32) not null,
  WPTYPE            CHAR(1),
  WPNAME            VARCHAR2(128),
  WPSTATE           CHAR(1),
  RECEIVEDATE       DATE,
  RECEIVELOCATION   VARCHAR2(32),
  RECEIVEPERSON     VARCHAR2(32),
  CONFIRMPERSON     VARCHAR2(32),
  WPCURRENTLOCATION VARCHAR2(128),
  REMARK            VARCHAR2(512)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.PODETAINWPBASICINFO.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程

业务流水号';
comment on column JTTXQ2.PODETAINWPBASICINFO.WPTYPE
  is '证据、材料、暂扣品
';
comment on column JTTXQ2.PODETAINWPBASICINFO.WPSTATE
  is '正常、已归还、遗失、销毁(报废)
';
alter table JTTXQ2.PODETAINWPBASICINFO
  add constraint PK_PODETAINWPBASICINFO primary key (WPID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PODETAINWPTRANSINFO
--prompt ==================================
--prompt
create table JTTXQ2.PODETAINWPTRANSINFO
(
  WPID          VARCHAR2(32) not null,
  TRANSPERSON   VARCHAR2(32),
  RECEIVEPERSON VARCHAR2(32),
  RECEIVEDATE   DATE,
  TRANSLOCATION VARCHAR2(256),
  REMARK        VARCHAR2(512),
  OPTTYPE       NUMBER(1),
  OPTPERSON     VARCHAR2(32),
  OPTDATE       DATE not null
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.PODETAINWPTRANSINFO.OPTTYPE
  is '操作类型:0 新增1 转移 2 归还 3登记遗失  4 销毁';
alter table JTTXQ2.PODETAINWPTRANSINFO
  add constraint PK_PODETAINTRANS primary key (WPID, OPTDATE)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PODISCUSSBASIC
--prompt =============================
--prompt
create table JTTXQ2.PODISCUSSBASIC
(
  PUNISHOBJECTID        VARCHAR2(16) not null,
  PODISCUSSTYPE         NUMBER(1) not null,
  PODISCUSSBEGINTIME    DATE,
  PODISCUSSENDTIME      DATE,
  PODISCUSSEMCEE        VARCHAR2(10),
  PODISCUSSNOTER        VARCHAR2(10),
  PODISCUSSATTENDNAME   VARCHAR2(200),
  PODISCUSSATTENDEENAME VARCHAR2(200),
  PODISCUSSAFFIXNAME    VARCHAR2(100),
  PODISCUSSRECORED      BLOB,
  DISOBEYITEM           CLOB,
  CONFIRMTRUTH          CLOB,
  PODISCUSSADRESS       VARCHAR2(100),
  PODISCUSSRESULT       VARCHAR2(100),
  ENREGISTERDATE        DATE,
  PODISCUSSSTEP         NUMBER(1),
  ENREGISTERID          NUMBER(8),
  PUNISH_HEAVY          NUMBER(1)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PODISCUSSBASIC
  is '保存案件讨论的信息';
comment on column JTTXQ2.PODISCUSSBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.PODISCUSSBASIC.PODISCUSSTYPE
  is '1:是第一次讨论；
2:是第二次讨论；';
alter table JTTXQ2.PODISCUSSBASIC
  add constraint PK_PODISCUSSBASIC primary key (PUNISHOBJECTID, PODISCUSSTYPE)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POENTERPRISE
--prompt ===========================
--prompt
create table JTTXQ2.POENTERPRISE
(
  PUNISHOBJECTID    VARCHAR2(16) not null,
  ENTERPRISEID      VARCHAR2(10) not null,
  ENTERPRISENAME    VARCHAR2(200) not null,
  ENTERPRISECODE    VARCHAR2(64),
  ENTERPRISEADDRESS VARCHAR2(200),
  UNITTYPE          VARCHAR2(10),
  CORPDOMAIN        VARCHAR2(10),
  REGTYPE           VARCHAR2(10),
  MASTERNAME        VARCHAR2(200),
  POSTCODE          VARCHAR2(6),
  PHONE             VARCHAR2(20),
  LINKER            VARCHAR2(20),
  FAX               VARCHAR2(200),
  EMAIL             VARCHAR2(200),
  ISVIP             NUMBER(1)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.POENTERPRISE.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table JTTXQ2.POENTERPRISE
  add constraint PK_POENTERPRISE primary key (PUNISHOBJECTID, ENTERPRISEID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POEXCUCEBASIC
--prompt ============================
--prompt
create table JTTXQ2.POEXCUCEBASIC
(
  PUNISHOBJECTID  VARCHAR2(16) not null,
  POEXCUCEDATE    DATE not null,
  POEXCUCEADRESS  VARCHAR2(100),
  UNDERTAKERNAME  VARCHAR2(10),
  UNDERTAKECERTNO VARCHAR2(10),
  REGISTERCERTNO  VARCHAR2(10),
  REGISTERID      VARCHAR2(10),
  DEPUTYNAME      VARCHAR2(10),
  EXCUCEDATE      DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POEXCUCEBASIC
  is '保存陈述申辩的基本信息
';
comment on column JTTXQ2.POEXCUCEBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table JTTXQ2.POEXCUCEBASIC
  add constraint PK_POEXCUCEBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POFINISHBASIC
--prompt ============================
--prompt
create table JTTXQ2.POFINISHBASIC
(
  PUNISHOBJECTID        VARCHAR2(16) not null,
  DISOBEYITEM           CLOB,
  CONFIRMTRUTH          CLOB,
  PODISCUSSRESULT       CLOB,
  PUNISHAMOUT           NUMBER(10,2),
  OTHERPUNISH           VARCHAR2(100),
  PUNISHAMOUTPEOPLE     NUMBER(8),
  PUNISHSEIZURE         NUMBER(8),
  PUNISHSEIZUREVALUE    NUMBER(10,2),
  PUNISHSHOUTONT        NUMBER(8),
  PUNISHDETENTIONPEOPLE NUMBER(8),
  PUNISHDETENTION       NUMBER(8),
  ISFINISH              NUMBER(1),
  PUNISHAFFIXNAME       VARCHAR2(50),
  PUNISHAFFIXDOC        BLOB,
  PUNISHAFFIXCODE       VARCHAR2(20),
  JBROPTION_JA          VARCHAR2(200),
  KSOPTION_JA           VARCHAR2(200),
  FZROPTION_JA          VARCHAR2(200),
  JBROPTION_JATIME      DATE,
  KSOPTION_JATIME       DATE,
  FZROPTION_JATIME      DATE,
  JBR_JA                VARCHAR2(20),
  KS_JA                 VARCHAR2(20),
  FZR_JA                VARCHAR2(20)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POFINISHBASIC
  is '保存案件结案的信息';
comment on column JTTXQ2.POFINISHBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POFINISHBASIC.ISFINISH
  is '0:否
1:是';
alter table JTTXQ2.POFINISHBASIC
  add constraint PK_POFINISHBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POINDAGATEREPBASIC
--prompt =================================
--prompt
create table JTTXQ2.POINDAGATEREPBASIC
(
  PUNISHOBJECTID             VARCHAR2(16) not null,
  CONFIRMTRUTH               CLOB,
  UNCONFIRMTRUTH             CLOB,
  POINDAGATEREPPASSAGE       CLOB,
  DISOBEYITEM                CLOB,
  POINDAGATEREPRESULT        VARCHAR2(100),
  ISDISCUSS                  NUMBER(1),
  POINDAGATEREPREPORTDOC     BLOB,
  POINDAGATEREPREPORTDOCNAME VARCHAR2(255),
  POINDAGATEREPSTATE         VARCHAR2(10),
  POINDAGATEREPSTEP          NUMBER(1),
  JBROPTION_DCZJ             VARCHAR2(200),
  KSOPTION_DCZJ              VARCHAR2(200),
  FZROPTION_DCZJ             VARCHAR2(200),
  JBROPTIONTIME_DCZJ         DATE,
  KSOPTIONTIME_DCZJ          DATE,
  FZROPTIONTIME_DCZJ         DATE,
  JBR_DCZJ                   VARCHAR2(20),
  KS_DCZJ                    VARCHAR2(20),
  FZR_DCZJ                   VARCHAR2(20),
  POINDAGATEREPCONTENT       CLOB
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POINDAGATEREPBASIC
  is '保存调查终结报告的基本信息';
comment on column JTTXQ2.POINDAGATEREPBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POINDAGATEREPBASIC.POINDAGATEREPSTATE
  is 'null:进行行政处罚
1:行政处理（整改）
2:移送处理
3:撤销立案
4:劳动仲裁';
comment on column JTTXQ2.POINDAGATEREPBASIC.POINDAGATEREPCONTENT
  is '案件结果处罚内容 对应state  1 ,2,3,4撤案原因,整改内容,备注,仲裁结果';
alter table JTTXQ2.POINDAGATEREPBASIC
  add constraint PK_POINDAGATEREPBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POINDIVIDUAL
--prompt ===========================
--prompt
create table JTTXQ2.POINDIVIDUAL
(
  PUNISHOBJECTID   VARCHAR2(16) not null,
  INDIVIDUALID     VARCHAR2(10),
  INDIVIDUALNAME   VARCHAR2(200) not null,
  INDIVIDUALCODE   VARCHAR2(64),
  SEX              CHAR(1),
  AGE              NUMBER(8),
  INDIVIDUALADRESS VARCHAR2(200),
  WORKUNIT         VARCHAR2(100),
  POSTCODE         CHAR(6),
  PHONE            VARCHAR2(32),
  EMAIL            VARCHAR2(200)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.POINDIVIDUAL.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
create unique index JTTXQ2.PK_POINDIVIDUAL on JTTXQ2.POINDIVIDUAL (PUNISHOBJECTID, INDIVIDUALID)
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POPUNISHBASIC
--prompt ============================
--prompt
create table JTTXQ2.POPUNISHBASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  PUNISHCLASSID  VARCHAR2(8) not null,
  PUNISHTYPEID   VARCHAR2(10) not null,
  PUNISHVALUE    VARCHAR2(10)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POPUNISHBASIC
  is '保存案件所采取处罚种类及处罚程度信息';
comment on column JTTXQ2.POPUNISHBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POPUNISHBASIC.PUNISHCLASSID
  is '当为0000000时候；为案件的最终决定处罚数量';
alter table JTTXQ2.POPUNISHBASIC
  add constraint PK_POPUNISHBASIC_ primary key (PUNISHOBJECTID, PUNISHTYPEID, PUNISHCLASSID);
create unique index JTTXQ2.PK_POPUNISHBASIC on JTTXQ2.POPUNISHBASIC (PUNISHOBJECTID, PUNISHTYPEID, PUNISHCLASSID)
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PORADIXBASIC
--prompt ===========================
--prompt
create table JTTXQ2.PORADIXBASIC
(
  RADIXID        VARCHAR2(10) not null,
  PUNISHOBJECTID VARCHAR2(16) not null,
  PUNISHTYPEID   VARCHAR2(10) not null,
  PUNISHCLASSID  VARCHAR2(8) not null,
  RADIX          NUMBER(8),
  MULTIPLE       NUMBER(8,2),
  DEGREENO       NUMBER(10) default 0 not null
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JTTXQ2.PORADIXBASIC
  add constraint PK_PORADIXBASIC primary key (RADIXID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PORECEIPTINFO
--prompt ============================
--prompt
create table JTTXQ2.PORECEIPTINFO
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  PORECEIPTSTATE NUMBER(1) not null,
  OPERATORNAME   VARCHAR2(200),
  SIGNINEDNAME   VARCHAR2(20),
  SIGNINEDDATE   DATE,
  PORECEIPTNAME  VARCHAR2(50),
  PORECEIPTDOC   BLOB,
  RECEIPTMODEL   VARCHAR2(10),
  ENREGISTERID   NUMBER(8),
  ENREGISTERDATE DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PORECEIPTINFO
  is '保存行政处罚预先告知书回执和行政处罚告知书回执信息';
comment on column JTTXQ2.PORECEIPTINFO.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.PORECEIPTINFO.PORECEIPTSTATE
  is '1:行政处罚预先告知书回执
2:行政处罚告知书回执';
comment on column JTTXQ2.PORECEIPTINFO.PORECEIPTDOC
  is '（这个字段转移到附件材料中）';
alter table JTTXQ2.PORECEIPTINFO
  add constraint PK_PORECEIPTINFO primary key (PORECEIPTSTATE, PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POREGISTERBASIC
--prompt ==============================
--prompt
create table JTTXQ2.POREGISTERBASIC
(
  PUNISHOBJECTID     VARCHAR2(16) not null,
  POREGISTERINDAGATE CLOB,
  POREGISTERBASIS    CLOB,
  ISPASS             CHAR(1),
  IFREGISTER         NUMBER(1),
  POREGISTERSTEP     NUMBER(1),
  JBROPTION_LA       VARCHAR2(200),
  KSOPTION_LA        VARCHAR2(200),
  FZROPTION_LA       VARCHAR2(200),
  JBROPTION_LATIME   DATE,
  KSOPTION_LATIME    DATE,
  FZROPTION_LATIME   DATE,
  JBR_LA             VARCHAR2(20),
  KS_LA              VARCHAR2(20),
  FZR_LA             VARCHAR2(20)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POREGISTERBASIC
  is '保存案件立案的基本信息';
comment on column JTTXQ2.POREGISTERBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POREGISTERBASIC.ISPASS
  is 'F:否
T:是';
alter table JTTXQ2.POREGISTERBASIC
  add constraint PK_POREGISTERBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PORESULTBASIC
--prompt ============================
--prompt
create table JTTXQ2.PORESULTBASIC
(
  PUNISHOBJECTID       VARCHAR2(16) not null,
  RESULTTYPE           CHAR(1),
  PONEATENCONTENT      CLOB,
  POARBITRATIONCONTENT CLOB,
  POQUASHREASON        CLOB,
  PODEPORTATIONDEPNAME VARCHAR2(20),
  REMARK               CLOB
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.PORESULTBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程

业务流水号';
alter table JTTXQ2.PORESULTBASIC
  add constraint PK_PORESULTBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POTRANSLAWBASIC
--prompt ==============================
--prompt
create table JTTXQ2.POTRANSLAWBASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  PUNISHCLASSID  VARCHAR2(20) not null,
  DEGREENO       NUMBER(8),
  ISSURPASS      NUMBER(1),
  TRANSLAWDATE   DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column JTTXQ2.POTRANSLAWBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POTRANSLAWBASIC.PUNISHCLASSID
  is '8位,前面补零';
alter table JTTXQ2.POTRANSLAWBASIC
  add constraint PK_POTRANSLAWBASIC primary key (PUNISHCLASSID, PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POUNDERTAKEBASIC
--prompt ===============================
--prompt
create table JTTXQ2.POUNDERTAKEBASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  USERCODE       VARCHAR2(8) not null,
  DEPID          NUMBER(5),
  SECTIONID      NUMBER(5)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POUNDERTAKEBASIC
  is '这个 可以用办件角色 来代替， 可以建一个这个名字的视图。';
comment on column JTTXQ2.POUNDERTAKEBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table JTTXQ2.POUNDERTAKEBASIC
  add constraint PK_POUNDERTAKEBASIC primary key (PUNISHOBJECTID, USERCODE)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JTTXQ2.POUNDERTAKEBASIC
  add constraint FK_POUNDERT_REFERENCE_F_USERIN foreign key (USERCODE)
  references JTTXQ2.F_USERINFO (USERCODE);

--prompt
--prompt Creating table POUNWITNESSBASIC
--prompt ===============================
--prompt
create table JTTXQ2.POUNWITNESSBASIC
(
  PUNISHOBJECTID    VARCHAR2(16) not null,
  POUNWITNESSREASON CLOB,
  UNWITNESSDATE     DATE,
  ENREGISTERID      VARCHAR2(20) not null
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POUNWITNESSBASIC
  is '保存不予以听证（申辩）的理由';
comment on column JTTXQ2.POUNWITNESSBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table JTTXQ2.POUNWITNESSBASIC
  add constraint PK_POUNWITNESSBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table POWITNESSBASIC
--prompt =============================
--prompt
create table JTTXQ2.POWITNESSBASIC
(
  PUNISHOBJECTID     VARCHAR2(16) not null,
  POWITNESSDATE      DATE not null,
  POWITNESSTYPE      NUMBER(1) not null,
  POWITNESSADRESS    VARCHAR2(100),
  POWITNESSEMCEENAME VARCHAR2(10),
  POWITNESSNOTERNAME VARCHAR2(10),
  INVESTIGATENAME    VARCHAR2(10),
  INVESTIGATEDEPNAME VARCHAR2(100),
  DEPUTYNAME         VARCHAR2(10),
  DEPUTYBUSINESS     VARCHAR2(20),
  DEPUTYDEPNAME      VARCHAR2(100),
  DELEGATENAME       VARCHAR2(200),
  POWITNESSMIND      CLOB,
  POWITNESSREASON    CLOB,
  WITNESSDATE        DATE
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.POWITNESSBASIC
  is '保存听证的基本信息 ';
comment on column JTTXQ2.POWITNESSBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column JTTXQ2.POWITNESSBASIC.POWITNESSTYPE
  is '0:公开
1:不公开';
alter table JTTXQ2.POWITNESSBASIC
  add constraint PK_POWITNESSBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating table PUNISHOBJECTBASIC
--prompt ================================
--prompt
create table JTTXQ2.PUNISHOBJECTBASIC
(
  PUNISHOBJECTID        VARCHAR2(16) not null,
  PUNISHOBJECTNO        VARCHAR2(15),
  PUNISHOBJECTTYPE      CHAR(1),
  MANAGEDEPID           NUMBER(8),
  POORIGINDATE          DATE,
  POREGISTERDATE        DATE,
  POINDAGATEREPDATE     DATE,
  POFINISHDATE          DATE,
  PUNISHOBJECTBRIEF     CLOB,
  POOCCURSTATE          NUMBER(1),
  POIMPEACHSTATE        NUMBER(1),
  POUNDERTAKER          VARCHAR2(100),
  PUNISHCLASSNUM        NUMBER(10),
  POCONTROVERTYPE       NUMBER(1),
  PODISCUSSNUM          NUMBER(1),
  ISSURPASS             NUMBER(1),
  PUNISHOBJECTSTATE     VARCHAR2(2),
  REMARK                CLOB,
  ISPASS                NUMBER(1),
  POOCCURADRESS         VARCHAR2(100),
  POOCCURDATE           DATE,
  POREGISTEROPINION     CLOB,
  OPERATORID            NUMBER(8),
  POORIGINCONTEXT       CLOB,
  POREGISTEDATE         DATE,
  POORIGINSTATE         VARCHAR2(10),
  POCASEIMPEACHPHONE    VARCHAR2(20),
  POCASEIMPEACHUNIT     VARCHAR2(100),
  POCASEIMPEACHID       VARCHAR2(20),
  POCASEIMPEACHNAME     VARCHAR2(100),
  POCASEIMPEACHSEX      CHAR(1),
  POCASEIMPEACHAGE      NUMBER(5),
  POCASEIMPEACHADRESS   VARCHAR2(100),
  POCASEIMPEACHPOSTCODE VARCHAR2(6),
  RISKDESC              VARCHAR2(200),
  RISKTYPE              VARCHAR2(50),
  RISKRESULT            VARCHAR2(200),
  POWERID               VARCHAR2(100),
  POWERNAME             VARCHAR2(200),
  FLOWINSTID            VARCHAR2(12),
  BIZSTATE              VARCHAR2(2),
  BIZTYPE               VARCHAR2(8),
  SOLVESTATUS           VARCHAR2(2),
  SOLVETIME             DATE,
  SOLVENOTE             VARCHAR2(2000),
  OPTID                 VARCHAR2(20),
  JBROPTION_CFJD        VARCHAR2(200),
  KSOPTION_CFJD         VARCHAR2(200),
  FZROPTION_CFJD        VARCHAR2(200),
  JBROPTION_CFJDTIME    DATE,
  KSOPTION_CFJDTIME     DATE,
  FZROPTION_CFJDTIME    DATE,
  JBROPTION_SL          VARCHAR2(200),
  KSOPTION_SL           VARCHAR2(200),
  FZROPTION_SL          VARCHAR2(200),
  JBROPTION_SLTIME      DATE,
  KSOPTION_SLTIME       DATE,
  FZROPTION_SLTIME      DATE,
  JBR_SL                VARCHAR2(20),
  KS_SL                 VARCHAR2(20),
  FZR_SL                VARCHAR2(20),
  JBR_CFJD              VARCHAR2(20),
  KS_CFJD               VARCHAR2(20),
  FZR_CFJD              VARCHAR2(20),
  CASENO                VARCHAR2(200)
)
tablespace JTTXQ
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table JTTXQ2.PUNISHOBJECTBASIC
  is '此表是用于存储案件的主要信息的表，

这个表 合并了以前表 举报人 和案件来源 表';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程

业务流水号';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PUNISHOBJECTNO
  is '案件外部编号的编码规则（以白下为例子）：NJ03（白下）WH（文化局代码）2007（年份）00001（流水号）；只有在案件确定立案的时候，才有整个外部编号';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PUNISHOBJECTTYPE
  is '默认为0：一般流程
1=简易流程';
comment on column JTTXQ2.PUNISHOBJECTBASIC.POOCCURSTATE
  is '0:个人
1:组织机构';
comment on column JTTXQ2.PUNISHOBJECTBASIC.POIMPEACHSTATE
  is '0:个人
1:组织机构
2:没有举报人，默认值是2';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PUNISHCLASSNUM
  is '0:不是并列处罚案件
1:是并列处罚案件';
comment on column JTTXQ2.PUNISHOBJECTBASIC.POCONTROVERTYPE
  is '0:陈述、申辩
1:听证
2:不进行陈述、申辩和听证';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PODISCUSSNUM
  is '默认值为2，在不进行二次讨论的同时，要将值置1';
comment on column JTTXQ2.PUNISHOBJECTBASIC.ISSURPASS
  is '0:没有超越；
1:超越';
comment on column JTTXQ2.PUNISHOBJECTBASIC.PUNISHOBJECTSTATE
  is '默认为1，各种状态分别表示为：0：删除；
1：案件来源登记；2：案件立案；
3：案件调查；4:：案件一次讨论；
5：陈述、申辩和听证；6：案件二次讨论；
7：行政处罚审批处罚决定；8：执行情况审批；
9：完成办理结案  a 撤销
';
comment on column JTTXQ2.PUNISHOBJECTBASIC.ISPASS
  is '0:否
1:是';
alter table JTTXQ2.PUNISHOBJECTBASIC
  add constraint PK_PUNISHOBJECTBASIC primary key (PUNISHOBJECTID)
  using index 
  tablespace JTTXQ
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--prompt
--prompt Creating sequence S_ENTERPRISEID
--prompt ================================
--prompt
create sequence JTTXQ2.S_ENTERPRISEID
minvalue 1
maxvalue 999999999999999999999
start with 81
increment by 1
cache 20
order;

--prompt
--prompt Creating sequence S_INDIVIDUALID
--prompt ================================
--prompt
create sequence JTTXQ2.S_INDIVIDUALID
minvalue 1
maxvalue 999999999999999999999
start with 481
increment by 1
cache 20
order;

--prompt
--prompt Creating sequence S_MANAGERACTIONNO
--prompt ===================================
--prompt
create sequence JTTXQ2.S_MANAGERACTIONNO
minvalue 1000
maxvalue 999999999999
start with 1361
increment by 1
cache 20;

--prompt
--prompt Creating sequence S_PCDEF
--prompt =========================
--prompt
create sequence JTTXQ2.S_PCDEF
minvalue 1
maxvalue 99999999
start with 22
increment by 1
cache 20;

--prompt
--prompt Creating sequence S_PCFREEUMPIREDEGREE
--prompt ======================================
--prompt
create sequence JTTXQ2.S_PCFREEUMPIREDEGREE
minvalue 1
maxvalue 9999999
start with 121
increment by 1
cache 20;

--prompt
--prompt Creating sequence S_PUNISHOBJECTBASIC
--prompt =====================================
--prompt
create sequence JTTXQ2.S_PUNISHOBJECTBASIC
minvalue 1
maxvalue 9999999999
start with 4702
increment by 1
cache 20;

--prompt
--prompt Creating sequence S_PUNISH_OBJECTID
--prompt ===================================
--prompt
create sequence JTTXQ2.S_PUNISH_OBJECTID
minvalue 1
maxvalue 999999999999999999999
start with 561
increment by 1
cache 20;

--prompt
--prompt Creating sequence S_RADIXID
--prompt ===========================
--prompt
create sequence JTTXQ2.S_RADIXID
minvalue 1
maxvalue 9999999999
start with 121
increment by 1
cache 20;

--prompt
--prompt Creating view VPODISCUSS
--prompt ========================
--prompt
CREATE OR REPLACE VIEW JTTXQ2.VPODISCUSS AS
SELECT PODiscussBasic.PODiscussType, PODiscussBasic.PODiscussAdress,
      PODiscussBasic.PODiscussBeginTime,
      PODiscussBasic.PODiscussEndTime, PODiscussBasic.PODiscussNoter,
      PODiscussBasic.PODiscussEmcee, PODiscussBasic.DisobeyItem,
      PODiscussBasic.PODiscussAttendeeName,
      PODiscussBasic.PODiscussAttendName, PODiscussBasic.confirmTruth,
      PODiscussBasic.PODiscussAffixName, PODiscussBasic.PODiscussRecored,
      PODiscussBasic.PODiscussResult, PODiscussBasic.PODiscussStep,
      PunishObjectBasic.PunishObjectID, PunishObjectBasic.isSurpass,PODiscussBasic.Punish_Heavy
FROM PODiscussBasic INNER JOIN
      PunishObjectBasic ON
      PODiscussBasic.PunishObjectID = PunishObjectBasic.PunishObjectID;

--prompt
--prompt Creating view VPOTRANSLAWBASIC
--prompt ==============================
--prompt
create or replace view jttxq2.vpotranslawbasic as
Select POTransLawBasic.degreeNo,
       POTransLawBasic.isSurpass,
       POTransLawBasic.TransLawDate,
       POTransLawBasic.PunishObjectID,
       PCDef.PunishClassID,
       PCDef.PunishClassCode,
       PCDef.DepID,
       PCDef.PunishBasis
  FROM POTransLawBasic
 INNER JOIN PCDef ON POTransLawBasic.PunishClassID = PCDef.PunishClassID
 where 1 = 1
   --and POTransLawBasic.punishObjectID = '0000000411'
 ORDER BY POTransLawBasic.PunishObjectID, POTransLawBasic.TransLawDate;

--prompt
--prompt Creating view V_PCFREEUMPIRETYPEDEGREE
--prompt ======================================
--prompt
create or replace view jttxq2.v_pcfreeumpiretypedegree as
select t1.*,t2.punishfactgrade from pcfreeumpiretype t1 left join pcfreeumpiredegree t2 on t1.punishclassid=t2.punishclassid and t1.degreeno=t2.degreeno;

--prompt
--prompt Creating view V_POREGISTERBASIC
--prompt ===============================
--prompt
create or replace view jttxq2.v_poregisterbasic as
select b.punishobjectid,b.punishobjectbrief,b.pooccurstate,b.poorigindate,b.caseno,b.pooccuradress,b.pooccurdate,
       pore.jbroption_la,pore.jbroption_latime,pore.fzroption_la,pore.fzroption_latime,pore.jbr_la,pore.fzr_la,
       pore.ksoption_la,pore.ksoption_latime,pore.ks_la,
       pore.poregisterbasis,pore.poregisterindagate,
       poin.individualname,(case when poin.sex='1' then '男' else '女' end) as sex,poin.age,
       poin.individualadress,poin.individualcode,poin.phone as inphone,
       poen.enterprisename,poen.enterpriseaddress,poen.mastername,poen.phone as enphone,da.datavalue as pooriginstate,
       b.poundertaker,poid.confirmtruth as POInconfirmtruth,poid.unconfirmtruth,poid.poindagatereppassage,poid.disobeyitem,poid.poindagaterepresult,
       poid.jbroption_dczj,poid.jbroptiontime_dczj,poid.jbr_dczj,poid.ksoption_dczj,poid.ksoptiontime_dczj,poid.ks_dczj,
       poid.fzroption_dczj,poid.fzroptiontime_dczj,poid.fzr_dczj,
       pof.confirmtruth as pofconfirmtruth,pof.podiscussresult,pof.otherpunish,pof.jbroption_ja,pof.jbroption_jatime,pof.jbr_ja,
       pof.ksoption_ja,pof.ksoption_jatime,pof.ks_ja,pof.fzroption_ja,pof.fzroption_jatime,pof.fzr_ja
  from punishobjectbasic b
  left join poregisterbasic pore on pore.punishobjectid = b.punishobjectid
  left join poindividual poin on poin.punishobjectid=b.punishobjectid
  left join poenterprise poen on poen.punishobjectid=b.punishobjectid
  left join POIndagateRepBasic poid on poid.punishobjectid=b.punishobjectid
  left join pofinishbasic pof on pof.punishobjectid=b.punishobjectid
  left join f_datadictionary da on da.datacode=b.pooriginstate and da.catalogcode='CASEORIGN';

--prompt
--prompt Creating view V_POWER_OPT_INFO
--prompt ==============================
--prompt
create or replace view jttxq2.v_power_opt_info as
select t.item_id, su.item_name
    from power_opt_info t
    left join suppower su on t.item_id = su.item_id
   where 1=1
  -- su.isinuse = '1'
     and su.ql_state= 'A';

--prompt
--prompt Creating view V_USER_TASK_LIST_CF
--prompt =================================
--prompt
create or replace view jttxq2.v_user_task_list_cf as
select rownum as taskid,t.WFOPTNAME,t.WFOPTTAG,t.NODEINSTID,t.UNITCODE,t.USERCODE,
       t.ROLETYPE,t.ROLECODE,t.AUTHDESC,t.NODENAME,t.NODETYPE,t.NODEOPTTYPE,t.OPTNAME,
       t.METHODNAME,t.OPTURL,t.OPTMETHOD,t.OPTPARAM,t.OPTDESC,t.CREATETIME,t.PROMISETIME,
       t.TIMELIMIT,t.EXPIREOPTSIGN,t.OPTCODE,t.EXPIREOPT,t.FLOWPHASE,t.GRANTOR,t.LASTUPDATEUSER,t.LASTUPDATETIME,t.inststate,e.*
       from v_user_task_list t left join PUNISHOBJECTBASIC e on t.WFINSTID=e.flowinstid where t.OPTID=e.optid;

-----add bu hx 2013-04-18 通用配置脚本
---添加环节名称字段
alter table add nodename varchar(100); 

--spool off
