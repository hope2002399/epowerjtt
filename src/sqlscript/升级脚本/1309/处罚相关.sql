---------------------------------------------
-- Export file for user EPOWER             --
-- Created by hx on 2013-9-13, 下午 12:28:21 --
---------------------------------------------

--spool 处罚相关.log

--prompt
--prompt Creating table P_ACCEPTINFO
--prompt ===========================
--prompt
create table EPOWER.P_ACCEPTINFO
(
  PUNISHOBJECTID   VARCHAR2(16) not null,
  JBR_SL           VARCHAR2(20),
  KSR_SL           VARCHAR2(20),
  FZR_SL           VARCHAR2(20),
  JBROPTION_SL     VARCHAR2(200),
  KSOPTION_SL      VARCHAR2(200),
  FZROPTION_SL     VARCHAR2(200),
  JBROPTION_SLTIME DATE,
  KSOPTION_SLTIME  DATE,
  FZROPTION_SLTIME DATE
)
tablespace EPOWER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
alter table EPOWER.P_ACCEPTINFO
  add constraint PK_POACCEPTINFO primary key (PUNISHOBJECTID)
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

--prompt
--prompt Creating table P_APPROVE_BASIC
--prompt ==============================
--prompt
create table EPOWER.P_APPROVE_BASIC
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
comment on table EPOWER.P_APPROVE_BASIC
  is '保存行政处罚审批的信息';
comment on column EPOWER.P_APPROVE_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table EPOWER.P_APPROVE_BASIC
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
--prompt Creating table P_DECISIONINFO
--prompt =============================
--prompt
create table EPOWER.P_DECISIONINFO
(
  PUNISHOBJECTID     VARCHAR2(16) not null,
  JBR_CFJD           VARCHAR2(20),
  KSR_CFJD           VARCHAR2(20),
  FZR_CFJD           VARCHAR2(20),
  JBROPTION_CFJD     VARCHAR2(200),
  KSOPTION_CFJD      VARCHAR2(200),
  FZROPTION_CFJD     VARCHAR2(200),
  JBROPTION_CFJDTIME DATE,
  KSOPTION_CFJDTIME  DATE,
  FZROPTION_CFJDTIME DATE
)
tablespace EPOWER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
alter table EPOWER.P_DECISIONINFO
  add constraint PK_PODECISIONINFO primary key (PUNISHOBJECTID)
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

--prompt
--prompt Creating table P_DETAIN_GOODS_BASICINFO
--prompt =======================================
--prompt
create table EPOWER.P_DETAIN_GOODS_BASICINFO
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
comment on column EPOWER.P_DETAIN_GOODS_BASICINFO.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程

业务流水号';
comment on column EPOWER.P_DETAIN_GOODS_BASICINFO.WPTYPE
  is '证据、材料、暂扣品
';
comment on column EPOWER.P_DETAIN_GOODS_BASICINFO.WPSTATE
  is '正常、已归还、遗失、销毁(报废)
';
alter table EPOWER.P_DETAIN_GOODS_BASICINFO
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
--prompt Creating table P_DETAIN_GOODS_TRANSINFO
--prompt =======================================
--prompt
create table EPOWER.P_DETAIN_GOODS_TRANSINFO
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
comment on column EPOWER.P_DETAIN_GOODS_TRANSINFO.OPTTYPE
  is '操作类型:0 新增1 转移 2 归还 3登记遗失  4 销毁';
alter table EPOWER.P_DETAIN_GOODS_TRANSINFO
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
--prompt Creating table P_DISCUSS_BASIC
--prompt ==============================
--prompt
create table EPOWER.P_DISCUSS_BASIC
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
comment on table EPOWER.P_DISCUSS_BASIC
  is '保存案件讨论的信息';
comment on column EPOWER.P_DISCUSS_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_DISCUSS_BASIC.PODISCUSSTYPE
  is '1:是第一次讨论；2:是第二次讨论；';
alter table EPOWER.P_DISCUSS_BASIC
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
--prompt Creating table P_ENTERPRISE
--prompt ===========================
--prompt
create table EPOWER.P_ENTERPRISE
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
comment on column EPOWER.P_ENTERPRISE.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table EPOWER.P_ENTERPRISE
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
--prompt Creating table P_EXCUCE_BASIC
--prompt =============================
--prompt
create table EPOWER.P_EXCUCE_BASIC
(
  PUNISHOBJECTID   VARCHAR2(16) not null,
  POEXCUCEDATE     DATE not null,
  POEXCUCEADRESS   VARCHAR2(100),
  UNDERTAKERNAME   VARCHAR2(10),
  UNDERTAKECERTNO  VARCHAR2(10),
  REGISTERCERTNO   VARCHAR2(10),
  REGISTERID       VARCHAR2(10),
  DEPUTYNAME       VARCHAR2(10),
  EXCUCEDATE       DATE,
  UNDERTAKERNAME2  VARCHAR2(10),
  UNDERTAKECERTNO2 VARCHAR2(10)
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
comment on table EPOWER.P_EXCUCE_BASIC
  is '保存陈述申辩的基本信息
';
comment on column EPOWER.P_EXCUCE_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table EPOWER.P_EXCUCE_BASIC
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
--prompt Creating table P_FILEINFO
--prompt =========================
--prompt
create table EPOWER.P_FILEINFO
(
  FILECODE    VARCHAR2(16) not null,
  FILENAME    VARCHAR2(100),
  FILEEXTNAME VARCHAR2(8) not null,
  FILEDESC    VARCHAR2(250),
  FILETYPE    CHAR(1),
  OPTCODE     VARCHAR2(50),
  FILECONTENT BLOB,
  RECORDER    VARCHAR2(8),
  RECORDDATE  DATE,
  INDB        CHAR(1) default '0',
  INSTID      NUMBER(12),
  PATH        VARCHAR2(100)
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
comment on column EPOWER.P_FILEINFO.FILENAME
  is '用于下载时保存的默认文件名';
comment on column EPOWER.P_FILEINFO.FILEEXTNAME
  is 'EXt Name ';
comment on column EPOWER.P_FILEINFO.FILETYPE
  is '业务类别 供反向链接';
comment on column EPOWER.P_FILEINFO.OPTCODE
  is '供反向链接';
comment on column EPOWER.P_FILEINFO.FILECONTENT
  is '用数据库存储时使用 BASE64 编码';
comment on column EPOWER.P_FILEINFO.PATH
  is '当存在文件系统中，保存文件的路径';
alter table EPOWER.P_FILEINFO
  add constraint PK_P_FILEINFO primary key (FILECODE)
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
--prompt Creating table P_FINISH_BASIC
--prompt =============================
--prompt
create table EPOWER.P_FINISH_BASIC
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
  PUNISHAFFIXNAME       VARCHAR2(150),
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
  FZR_JA                VARCHAR2(20),
  FINISHTYPE            VARCHAR2(20)
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
comment on table EPOWER.P_FINISH_BASIC
  is '保存案件结案的信息';
comment on column EPOWER.P_FINISH_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_FINISH_BASIC.ISFINISH
  is '0:否1:是';
alter table EPOWER.P_FINISH_BASIC
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
--prompt Creating table P_INDAGATE_REP_BASIC
--prompt ===================================
--prompt
create table EPOWER.P_INDAGATE_REP_BASIC
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
comment on table EPOWER.P_INDAGATE_REP_BASIC
  is '保存调查终结报告的基本信息';
comment on column EPOWER.P_INDAGATE_REP_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_INDAGATE_REP_BASIC.POINDAGATEREPSTATE
  is 'null:进行行政处罚1:行政处理（整改）2:移送处理3:撤销立案4:劳动仲裁';
comment on column EPOWER.P_INDAGATE_REP_BASIC.POINDAGATEREPCONTENT
  is '案件结果处罚内容 对应state  1 ,2,3,4撤案原因,整改内容,备注,仲裁结果';
alter table EPOWER.P_INDAGATE_REP_BASIC
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
--prompt Creating table P_INDIVIDUAL
--prompt ===========================
--prompt
create table EPOWER.P_INDIVIDUAL
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
comment on column EPOWER.P_INDIVIDUAL.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
create unique index EPOWER.PK_POINDIVIDUAL on EPOWER.P_INDIVIDUAL (PUNISHOBJECTID, INDIVIDUALID)
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
--prompt Creating table P_PCDEF
--prompt ======================
--prompt
create table EPOWER.P_PCDEF
(
  PUNISHCLASSID      VARCHAR2(8) not null,
  PUNISHCLASSNAME    VARCHAR2(200) not null,
  DEPID              NUMBER(8) not null,
  PUNISHCLASSCODE    VARCHAR2(18),
  PUNISHOBJECT       NUMBER(1),
  ISINUSE            NUMBER(1) default 1 not null,
  PUNISHBASISCONTENT CLOB,
  PUNISHBASIS        VARCHAR2(1000),
  REMARK             CLOB,
  ITEM_ID            VARCHAR2(8),
  VERSION            NUMBER(6),
  ISLAWSUIT          CHAR(1),
  ISRECONSIDER       CHAR(1)
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
comment on table EPOWER.P_PCDEF
  is 'Punish Class Defination保存行政处罚项目的相关信息，即法律、法规库。';
comment on column EPOWER.P_PCDEF.PUNISHCLASSID
  is '8位,前面补零';
comment on column EPOWER.P_PCDEF.DEPID
  is '外键，引用部门表';
comment on column EPOWER.P_PCDEF.PUNISHCLASSCODE
  is '处罚权力编码';
comment on column EPOWER.P_PCDEF.PUNISHOBJECT
  is '0：个人；1：机构';
comment on column EPOWER.P_PCDEF.ISINUSE
  is '1:使用中0:弃用';
alter table EPOWER.P_PCDEF
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
--prompt Creating table P_PCTYPE
--prompt =======================
--prompt
create table EPOWER.P_PCTYPE
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
comment on table EPOWER.P_PCTYPE
  is 'Punish Class Type保存各行政处罚项目可用的处罚方式。';
comment on column EPOWER.P_PCTYPE.PUNISHCLASSID
  is '外键，引用PCDef表';
comment on column EPOWER.P_PCTYPE.PUNISHTYPEID
  is '引用公共代码表';
comment on column EPOWER.P_PCTYPE.ISINUSE
  is '1:使用中0:弃用';
comment on column EPOWER.P_PCTYPE.ISRATE
  is '0:没有比例1:有比例';
alter table EPOWER.P_PCTYPE
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
--prompt Creating table P_PUBLICINFO
--prompt ===========================
--prompt
create table EPOWER.P_PUBLICINFO
(
  INFOCODE       VARCHAR2(8) not null,
  PARENTINFOCODE VARCHAR2(8),
  FILECODE       VARCHAR2(16),
  INFONAME       VARCHAR2(64),
  OWNERTYPE      CHAR(1),
  OWNERCODE      VARCHAR2(8),
  READTIMES      NUMBER(8) default 0 not null
)
tablespace FGWSUNZW_DFT_TBS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column EPOWER.P_PUBLICINFO.OWNERTYPE
  is '机构或者个人';
alter table EPOWER.P_PUBLICINFO
  add constraint PK_P_PUBLICINFO primary key (INFOCODE)
  using index 
  tablespace FGWSUNZW_DFT_TBS
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
--prompt Creating table P_PUNISH_BASIC
--prompt =============================
--prompt
create table EPOWER.P_PUNISH_BASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  ITEM_ID        VARCHAR2(30) not null,
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
comment on table EPOWER.P_PUNISH_BASIC
  is '保存案件所采取处罚种类及处罚程度信息';
comment on column EPOWER.P_PUNISH_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_PUNISH_BASIC.ITEM_ID
  is '当为0000000时候；为案件的最终决定处罚数量';
alter table EPOWER.P_PUNISH_BASIC
  add constraint PK_POPUNISHBASIC_ primary key (PUNISHOBJECTID, PUNISHTYPEID, ITEM_ID);
create unique index EPOWER.PK_POPUNISHBASIC on EPOWER.P_PUNISH_BASIC (PUNISHOBJECTID, PUNISHTYPEID, ITEM_ID)
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
--prompt Creating table P_PUNISH_OBJECT_BASIC
--prompt ====================================
--prompt
create table EPOWER.P_PUNISH_OBJECT_BASIC
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
comment on table EPOWER.P_PUNISH_OBJECT_BASIC
  is '此表是用于存储案件的主要信息的表，这个表 合并了以前表 举报人 和案件来源 表';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程业务流水号';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PUNISHOBJECTNO
  is '案件外部编号的编码规则（以白下为例子）：NJ03（白下）WH（文化局代码）2007（年份）00001（流水号）；只有在案件确定立案的时候，才有整个外部编号';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PUNISHOBJECTTYPE
  is '默认为0：一般流程1=简易流程';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.POOCCURSTATE
  is '0:个人1:组织机构';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.POIMPEACHSTATE
  is '0:个人1:组织机构2:没有举报人，默认值是2';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PUNISHCLASSNUM
  is '0:不是并列处罚案件1:是并列处罚案件';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.POCONTROVERTYPE
  is '0:陈述、申辩1:听证2:不进行陈述、申辩和听证';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PODISCUSSNUM
  is '默认值为2，在不进行二次讨论的同时，要将值置1';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.ISSURPASS
  is '0:没有超越；1:超越';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.PUNISHOBJECTSTATE
  is '默认为1，各种状态分别表示为：0：删除；1：案件来源登记；2：案件立案；3：案件调查；4:：案件一次讨论；5：陈述、申辩和听证；6：案件二次讨论；7：行政处罚审批处罚决定；8：执行情况审批；9：完成办理结案  a 撤销';
comment on column EPOWER.P_PUNISH_OBJECT_BASIC.ISPASS
  is '0:否1:是';
alter table EPOWER.P_PUNISH_OBJECT_BASIC
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
--prompt Creating table P_RADIX_BASIC
--prompt ============================
--prompt
create table EPOWER.P_RADIX_BASIC
(
  RADIXID        VARCHAR2(10) not null,
  PUNISHOBJECTID VARCHAR2(16) not null,
  PUNISHTYPEID   VARCHAR2(10) not null,
  ITEM_ID        VARCHAR2(30) not null,
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
alter table EPOWER.P_RADIX_BASIC
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
--prompt Creating table P_RECEIPT_INFO
--prompt =============================
--prompt
create table EPOWER.P_RECEIPT_INFO
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  PORECEIPTSTATE NUMBER(1) not null,
  OPERATORNAME   VARCHAR2(200),
  SIGNINEDNAME   VARCHAR2(20),
  SIGNINEDDATE   DATE,
  PORECEIPTNAME  VARCHAR2(150),
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
comment on table EPOWER.P_RECEIPT_INFO
  is '保存行政处罚预先告知书回执和行政处罚告知书回执信息';
comment on column EPOWER.P_RECEIPT_INFO.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_RECEIPT_INFO.PORECEIPTSTATE
  is '1:行政处罚预先告知书回执2:行政处罚告知书回执';
comment on column EPOWER.P_RECEIPT_INFO.PORECEIPTDOC
  is '（这个字段转移到附件材料中）';
alter table EPOWER.P_RECEIPT_INFO
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
--prompt Creating table P_REGISTER_BASIC
--prompt ===============================
--prompt
create table EPOWER.P_REGISTER_BASIC
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
comment on table EPOWER.P_REGISTER_BASIC
  is '保存案件立案的基本信息';
comment on column EPOWER.P_REGISTER_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_REGISTER_BASIC.ISPASS
  is 'F:否T:是';
alter table EPOWER.P_REGISTER_BASIC
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
--prompt Creating table P_RESULT_BASIC
--prompt =============================
--prompt
create table EPOWER.P_RESULT_BASIC
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
comment on column EPOWER.P_RESULT_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程业务流水号';
alter table EPOWER.P_RESULT_BASIC
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
--prompt Creating table P_TRANS_LAW_BASIC
--prompt ================================
--prompt
create table EPOWER.P_TRANS_LAW_BASIC
(
  PUNISHOBJECTID VARCHAR2(16) not null,
  ITEM_ID        VARCHAR2(30) not null,
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
comment on column EPOWER.P_TRANS_LAW_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_TRANS_LAW_BASIC.ITEM_ID
  is '8位,前面补零';
alter table EPOWER.P_TRANS_LAW_BASIC
  add constraint PK_POTRANSLAWBASIC primary key (ITEM_ID, PUNISHOBJECTID)
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
--prompt Creating table P_UNDERTAKE_BASIC
--prompt ================================
--prompt
create table EPOWER.P_UNDERTAKE_BASIC
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
comment on table EPOWER.P_UNDERTAKE_BASIC
  is '这个 可以用办件角色 来代替， 可以建一个这个名字的视图。';
comment on column EPOWER.P_UNDERTAKE_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table EPOWER.P_UNDERTAKE_BASIC
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
alter table EPOWER.P_UNDERTAKE_BASIC
  add constraint FK_POUNDERT_REFERENCE_F_USERIN foreign key (USERCODE)
  references EPOWER.F_USERINFO (USERCODE);

--prompt
--prompt Creating table P_UNWITNESS_BASIC
--prompt ================================
--prompt
create table EPOWER.P_UNWITNESS_BASIC
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
comment on table EPOWER.P_UNWITNESS_BASIC
  is '保存不予以听证（申辩）的理由';
comment on column EPOWER.P_UNWITNESS_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
alter table EPOWER.P_UNWITNESS_BASIC
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
--prompt Creating table P_WITNESS_BASIC
--prompt ==============================
--prompt
create table EPOWER.P_WITNESS_BASIC
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
comment on table EPOWER.P_WITNESS_BASIC
  is '保存听证的基本信息 ';
comment on column EPOWER.P_WITNESS_BASIC.PUNISHOBJECTID
  is '案件作为一个案件的标志，始终贯穿整个案件的流程';
comment on column EPOWER.P_WITNESS_BASIC.POWITNESSTYPE
  is '0:公开1:不公开';
alter table EPOWER.P_WITNESS_BASIC
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
--prompt Creating view B_V_POWERCHANGE
--prompt =============================
--prompt
create or replace view epower.b_v_powerchange as
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
left join B_power s on s.item_id=B_PowerChgLog.item_id and s.version=B_PowerChgLog.version
where 1=1  and B_PowerChgLog.reply_people is  null --and s.version='0';

--prompt
--prompt Creating view B_V_POWERINUSING
--prompt ==============================
--prompt
create or replace view epower.b_v_powerinusing as
select
a.ITEM_ID ,a.version , a.begin_time , a.end_time   , a.ORG_ID  ,
a.ITEM_NAME   ,a.ITEM_STA_NAME  ,a.ITEM_TYPE , a.TIME_LIMIT  ,a.IS_NETWORK,
a.IS_FORMULA , a.PHONE, ADDRESS , a.LASTMODIFYTIME ,a.audit_Sign ,
a.MONITOR_PHONE ,a.ACCEPT_LINK , a.LEGAL_TIME_LIMIT  , a.CHARGE  , a.FORM_NAME  ,
a.file_name ,a.In_Flow_img_Name  , a.ISCHARGE  ,a.PUNISH_CLASS  , a.Transact_DEPNAME ,
a.Promise_Type , a.Anticipate_Type ,  a.QL_DepID  ,a. QL_DepState , a.ENTRUST_Name ,
a.QL_State,a.PunishBasis,a.punishobject
from b_Power a
--where QL_State = 'A' and version > 0 and begin_time <= sysdate and (end_time is null or end_time > sysdate);
where a.version = (select max(b.version) as version
                      from b_power b
                     where b.item_id = a.item_id) and a.ql_state='A';

--prompt
--prompt Creating view B_V_POWERWITHOUTLOB
--prompt =================================
--prompt
create or replace view epower.b_v_powerwithoutlob as
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
   B_Power;

--prompt
--prompt Creating view F_V_LASTVERTIONFLOW
--prompt =================================
--prompt
CREATE OR REPLACE VIEW EPOWER.F_V_LASTVERTIONFLOW AS
SELECT "WFCODE","VERSION","WFNAME","WFCLASS","WFSTATE","WFDESC","WFXMLDESC","WFPUBLISHDATE",
         "OPTID","TIMELIMIT","EXPIREOPT","ATPUBLISHDATE"
FROM WF_FLOW_DEFINE
WHERE (WFCODE,VERSION) IN (SELECT WF.WFCODE,MAX(WF.VERSION) AS VERSION FROM  WF_FLOW_DEFINE WF GROUP BY WF.WFCODE);

--prompt
--prompt Creating view F_V_USERROLES
--prompt ===========================
--prompt
create or replace view epower.f_v_userroles as
select distinct b.ROLECODE,b.ROLENAME,b.ISVALID,b.ROLEDESC,a.usercode
    from F_USERROLE a join F_ROLEINFO b on (a.ROLECODE=b.ROLECODE)
    where a.OBTAINDATE <= sysdate and (a.SECEDEDATE is null or a.SECEDEDATE > sysdate) and b.ISVALID='T'
union all
  select d.ROLECODE,d.ROLENAME,d.ISVALID,d.ROLEDESC,c.usercode
   from f_userinfo c , F_ROLEINFO d
   where d.rolecode = 'G-public';

--prompt
--prompt Creating view F_V_USEROPTLIST
--prompt =============================
--prompt
create or replace view epower.f_v_useroptlist as
select  distinct a.UserCode,  c.OPTCODE,  c.OPTNAME  ,  c. OPTID ,  c.OPTMETHOD
from F_V_USERROLES a  join F_ROLEPOWER   b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE);

--prompt
--prompt Creating view F_V_USEROPTMOUDLELIST
--prompt ===================================
--prompt
create or replace view epower.f_v_useroptmoudlelist as
select  distinct a.UserCode,d.OptID, d.OptName , d.PreOptID  ,
            d.FormCode  , d.opturl, d.MsgNo , d.MsgPrm, d.IsInToolBar ,
            d.ImgIndex,d.TopOptID ,d.OrderInd,d.PageType,d.opttype
from F_V_USERROLES a  join F_ROLEPOWER b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
        join F_OptInfo d on(c.OPTID=d.OptID)
where d.opturl<>'...';

--prompt
--prompt Creating view V_HI_UNITINFO
--prompt ===========================
--prompt
create or replace view epower.v_hi_unitinfo as
select b.topunitcode as topunitcode, a.unitcode,a.unittype, a.parentunit, a.isvalid,
       a.unitname,a.unitdesc,a.unitshortname,a.addrbookid,a.depno,a.unitorder,
       a.unitword,a.unitgrade,a.unitdazt,a.prefix, b.hi_level
  from f_unitinfo a,
       (select level as hi_level,
               unitcode,
               CONNECT_BY_ROOT unitcode as topunitcode
          from f_unitinfo t
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.unitcode;

--prompt
--prompt Creating view M_V_TRACKLOG
--prompt ==========================
--prompt
create or replace view epower.m_v_tracklog as
select
a.internal_no as internalNo_bj,a.isrisk as isRisk_bj,a.item_id as itemId_bj,a.org_id as orgId_bj,
p.org_id as orgId_aj,p.isrisk as isRisk_aj,p.punish_target,p.internal_no as internalNo_aj,p.item_id as itemId_aj,
t.tracktime,t.untrackoperator,t.untracktime,t.untrackreason,t.no,t.trackno,t.powertype,t.tracktype,t.trackreason,t.trackoperator
, V_HI_UNITINFO.topunitcode,TRANSACT_AFFAIR_NAME
from M_trackLog t
left join M_apply a on a.no=t.no
left join M_punish p on p.no=t.no
left join V_HI_UNITINFO on  a.org_id = V_HI_UNITINFO.depno or p.org_id = V_HI_UNITINFO.depno
where t.trackoperator is not null;

--prompt
--prompt Creating view VPODISCUSS
--prompt ========================
--prompt
CREATE OR REPLACE VIEW EPOWER.VPODISCUSS AS
SELECT PODiscussBasic.PODiscussType, PODiscussBasic.PODiscussAdress,
      PODiscussBasic.PODiscussBeginTime,
      PODiscussBasic.PODiscussEndTime, PODiscussBasic.PODiscussNoter,
      PODiscussBasic.PODiscussEmcee, PODiscussBasic.DisobeyItem,
      PODiscussBasic.PODiscussAttendeeName,
      PODiscussBasic.PODiscussAttendName, PODiscussBasic.confirmTruth,
      PODiscussBasic.PODiscussAffixName, PODiscussBasic.PODiscussRecored,
      PODiscussBasic.PODiscussResult, PODiscussBasic.PODiscussStep,
      PunishObjectBasic.PunishObjectID, PunishObjectBasic.isSurpass,PODiscussBasic.Punish_Heavy
FROM P_Discuss_Basic PODiscussBasic INNER JOIN
      P_Punish_Object_Basic PunishObjectBasic ON
      PODiscussBasic.PunishObjectID = PunishObjectBasic.PunishObjectID;

--prompt
--prompt Creating view VPOTRANSLAWBASIC
--prompt ==============================
--prompt
create or replace view epower.vpotranslawbasic as
Select POTransLawBasic.degreeNo,
       POTransLawBasic.isSurpass,
       POTransLawBasic.TransLawDate,
       POTransLawBasic.PunishObjectID,
       PCDef.item_id PUNISHCLASSCODE,
       PCDef.org_id DEPID,
       PCDef.PunishBasis
  FROM P_Trans_Law_Basic POTransLawBasic
 INNER JOIN b_v_Powerinusing PCDef ON POTransLawBasic.item_id = PCDef.item_id
 where 1 = 1
   --and POTransLawBasic.punishObjectID = '0000000411'
 ORDER BY POTransLawBasic.PunishObjectID, POTransLawBasic.TransLawDate;

--prompt
--prompt Creating view V_APPLY
--prompt =====================
--prompt
create or replace view epower.v_apply as
select distinct Apply.No,Apply.Transact_Affair_Name,Apply.Chang_No,Apply.Org_Id,Apply.Internal_No,Apply.Item_Id,Apply.Department,Apply.Applicant_Name,
apply.istrack,Apply.Applicant_Type, Apply.Apply_Date,
 case when Apply.Isrisk = 1 then 1 when Apply.Isrisk != 1 and m_applyprocess.isrisk = 1 then 2 else 0 end Isrisk,
substr(Apply.item_id,-7,2) item_type, V_HI_UNITINFO.topunitcode,ApplyResult.Finish_Time,b_power.version,income_doc.accept_no,income_doc.income_doc_no,dispatch_doc.dispatch_doc_no
, outway.monitor_style, maxprocess.status maxstatus, ApplyResult.status
 From M_Apply Apply
left join m_applyprocess on Apply.internal_No = m_applyprocess.internal_No and Apply.item_Id = m_applyprocess.item_Id
left join (select  t.internal_no, t.item_id,t.no_ord,max(t.status) status from m_applyprocess t where ( t.internal_no, t.item_id,t.no_ord) in (select p.internal_no, p.item_id, max(p.no_ord) no_ord from m_applyprocess p group by p.internal_no, p.item_id) group by t.internal_no, t.item_id,t.no_ord) maxprocess on
Apply.internal_No = maxprocess.internal_No and Apply.item_Id = maxprocess.item_Id
left join M_ApplyResult ApplyResult on Apply.internal_No = ApplyResult.internal_No and Apply.item_Id = ApplyResult.item_Id
             left join b_power on Apply.item_id = b_power.item_id
             left join V_HI_UNITINFO on  Apply.org_id = V_HI_UNITINFO.depno
             left join m_income_doc income_doc on income_doc.internal_no = Apply.internal_no and income_doc.item_id = Apply.item_id
             left join m_dispatch_doc dispatch_doc on dispatch_doc.internal_no = Apply.internal_no and dispatch_doc.item_id = Apply.item_id
             left join (select t.bj_type,t.bj_no,t.internal_no,t.item_id,max(case when t.monitor_style = '3' then '0' else t.monitor_style end ) monitor_style from m_outway t where t.outtime is null group by t.bj_type,t.bj_no,t.internal_no,t.item_id)  outway on outway.bj_no = apply.no  and outway.bj_type='1'
  where (b_power.version <> 0 and b_power.begin_time <= sysdate and (b_power.end_time is null or b_power.end_time >sysdate)) or b_power.item_id is null;

--prompt
--prompt Creating view V_COMPLAINT
--prompt =========================
--prompt
create or replace view epower.v_complaint as
select a.*,
       case
         when a.promise_Date < sysdate and t.RESULT_DATE is null then 'no_receipt_overtime'
         when t.RESULT_DATE is null then 'no_receipt'
         when a.promise_Date >= t.RESULT_DATE  then  'receipt_intime'
         when a.promise_Date < t.RESULT_DATE  then 'overtime_receipt'
       end state, t.type
  From m_complaint a

  left join m_complaintsresult t
    on a.complaintid = t.complaintid;

--prompt
--prompt Creating view V_HI_OPTINFO
--prompt ==========================
--prompt
create or replace view epower.v_hi_optinfo as
select connect_by_root  t.optid  as topoptid, level as hi_level , t.optid , t.optname
from f_optinfo t
connect by prior t.optid = t.preoptid;

--prompt
--prompt Creating view V_OPTDEF
--prompt ======================
--prompt
create or replace view epower.v_optdef as
select a.OPTCODE, a.OPTNAME as MethodName , a.OPTID, a.OPTMETHOD, a.OPTDESC,
       b.OptName, b.opturl, b.FormCode, b.OptType, b.MsgNo, b.MsgPrm,
       b.IsInToolBar, b.ImgIndex, b.PreOptID, b.TopOptID, b. OrderInd ,b.wfcode
from  F_OPTDEF a join  F_OptInfo b on ( a.optid=b.optid)
where b.OptType = 'W';

--prompt
--prompt Creating view V_INNER_USER_TASK_LIST
--prompt ====================================
--prompt
create or replace view epower.v_inner_user_task_list as
select a.WFINSTID,w.WfOptName,w.wfOptTag,a.nodeinstid, nvl(a.UnitCode,nvl(w.UnitCode,'0000000')) as UnitCode, b.usercode,b.ROLETYPE,b.ROLECODE,b.AUTHDESC,
          c.NodeName,c.NodeType,c.OptType as NODEOPTTYPE,d.optid,d.OptName,d.MethodName,
          d.OptUrl,d.optMethod,c.OptParam ,d.OptDesc,a.CREATETIME,a.PromiseTime,a.TIMELIMIT,a.ExpireOptSign,
          c.OPTCODE,c.ExpireOpt,c.flowphase,a.lastupdateuser,a.lastupdatetime,w.inststate
from WF_NODE_INSTANCE a join WF_FLOW_INSTANCE w on (a.WFINSTID=w.WFINSTID)
           join WF_ACTION_TASK b on (a.NODEINSTID=b.NODEINSTID)
           join WF_NODE c on (a.NODEID=c.NODEID)
           join V_OPTDEF d on (c.OPTCODE=d.OPTCODE)
where (a.NODESTATE='N'  or a.NODESTATE='R') and w.INSTSTATE='N' and b.ISVALID='T'
           and  b.TASKSTATE='A' and (b.EXPIRETIME is null or b.EXPIRETIME>sysdate)
union all
select  a.WFINSTID,w.WfOptName,w.wfOptTag,a.nodeinstid, b.UnitCode , b.usercode,c.ROLETYPE,c.ROLECODE, '系统指定' as AUTHDESC,
          c.NodeName,c.NodeType,c.OptType as NODEOPTTYPE,d.optid,d.OptName,d.MethodName,
          d.OptUrl,d.optMethod,c.OptParam,d.OptDesc,a.CREATETIME,a.PromiseTime,a.timelimit,a.ExpireOptSign,
           c.OPTCODE,c.ExpireOpt,c.flowphase,a.lastupdateuser,a.lastupdatetime,w.inststate
from WF_NODE_INSTANCE a join WF_FLOW_INSTANCE w on (a.WFINSTID=w.WFINSTID)
       join WF_NODE c on (a.NODEID=c.NODEID)
       join V_OPTDEF d on (c.OPTCODE=d.OPTCODE) , F_USERUNIT b
where (a.NODESTATE='N'  or a.NODESTATE='R')  and w.INSTSTATE='N'  and a.TASKASSIGNED='F' and
        (a.UNITCODE is null or a.UNITCODE=b.UNITCODE) and
       (   (c.ROLETYPE='gw' and c.ROLECODE=b.UserStation) or
           (c.ROLETYPE='xz' and c.ROLECODE=b.UserRank) )
union all
select a.WFINSTID,w.WfOptName,w.wfOptTag,a.nodeinstid, nvl( a.UnitCode,nvl(w.UnitCode,'0000000')) as UnitCode, b.usercode,c.ROLETYPE,b.ROLECODE,b.AUTHDESC,
          c.NodeName,c.NodeType,c.OptType as NODEOPTTYPE,d.optid,d.OptName,d.MethodName,
          d.OptUrl,d.optMethod,c.OptParam,d.OptDesc,a.CREATETIME,a.PromiseTime,a.timelimit,a.ExpireOptSign,
           c.OPTCODE,c.ExpireOpt,c.flowphase,a.lastupdateuser,a.lastupdatetime,w.inststate
from WF_NODE_INSTANCE a join WF_FLOW_INSTANCE w on (a.WFINSTID=w.WFINSTID)
       join WF_NODE c on (a.NODEID=c.NODEID)
       join WF_TEAM b on (a.WFINSTID=b.WFINSTID)
       join V_OPTDEF d on (c.OPTCODE=d.OPTCODE)
where (a.NODESTATE='N'  or a.NODESTATE='R' ) and w.INSTSTATE='N'  and  a.TASKASSIGNED='F' and
          c.ROLETYPE='bj' and c.ROLECODE=b.ROLECODE;

--prompt
--prompt Creating view V_JCRYPERSONNEL
--prompt =============================
--prompt
create or replace view epower.v_jcrypersonnel as
select  no,Q.USER_ID,Q.USER_NAME,Q.DEPTCODE,Q.BIRTH,Q.SEX,Q.POLITICAL_LANDSCAPE,Q.EDUCATION,Q.TEL,Q.POSITION,Q.ORGANIZATION,Q.CHANGE_DATE,Q.UPDATE_TYPE,Q.UPDATE_DATE,Q.SYNC_DATE,Q.SYNC_SIGN,Q.SYNC_ERROR_DESC from QL_JCRY_SUPERVISORYPERSONNEL Q
UNION
select  no,S.USER_ID,S.USER_NAME,S.DEPTCODE,S.BIRTH,S.SEX,S.POLITICAL_LANDSCAPE,S.EDUCATION,S.TEL,S.POSITION,S.ORGANIZATION,S.CHANGE_DATE,S.UPDATE_TYPE,S.UPDATE_DATE,S.SYNC_DATE,S.SYNC_SIGN,S.SYNC_ERROR_DESC from SUP_JCRY_SUPERVISORYPERSONNEL S;

--prompt
--prompt Creating view V_M_SUPERVISEBASIC_M_COMPLAINT
--prompt ============================================
--prompt
create or replace view epower.v_m_supervisebasic_m_complaint as
select t.internal_no,
               t.BJ_Type as BJ_Type1,
               e.supervise_no,
               e.flowInstId,
               e.BJ_Type,
               e.BJ_NO,
               e.ComplaintID,
               e.OutWayID,
               e.ORG_ID,
               e.OPERATOR_NAME,
               e.operator_ID,
               e.supervise_date,
               e.MONITOR_ORG_ID,
               e.MONITOR_ORG_NAME,
               e.MONITOR_OPERATOR_ID,
               e.MONITOR_OPERATOR_NAME,
               e.supervise_Option,
               e.ATTACHMENTName,
               e.promise_Date,
               e.UPDATE_DATE,
               e.OPTID,
               e.biztype
          from M_SuperviseBasic e
          left join m_complaint t on e.complaintid = t.complaintid
         where e.bj_type = '3'
           and t.internal_no is not null;

--prompt
--prompt Creating view V_NODE_INSTDETAIL
--prompt ===============================
--prompt
create or replace view epower.v_node_instdetail as
select f.wfoptname,f.wfopttag,n.nodename,n.roletype,n.rolecode,
d.OptName,d.MethodName,d.OptUrl,d.optMethod,n.optparam,
 t.NODEINSTID, t.WFINSTID, t.NODEID, t.CREATETIME, t.PREVNODEINSTID, t.FINISHTIME, t.NODESTATE,
 t.SUBWFINSTID, t.UNITCODE, t.TRANSID, t.TASKASSIGNED, t.EXPIREOPTSIGN, t.EXPIRETIME,
 t.RUNTOKEN, t.TIMELIMIT, t.LASTUPDATEUSER, t.LASTUPDATETIME, t.ISTIMER, t.PROMISETIME
  from wf_node_instance t
join wf_node n on t.nodeid =  n.nodeid
join V_OPTDEF d on (n.OPTCODE=d.OPTCODE)
join wf_flow_instance f on t.wfinstid = f.wfinstid;

--prompt
--prompt Creating view V_ORGSUPPOWER
--prompt ===========================
--prompt
create or replace view epower.v_orgsuppower as
select  rownum as id, s.ITEM_ID,s.version,p.unitcode as ORG_ID,s.ITEM_NAME  ,s.ITEM_STA_NAME,s.ITEM_TYPE,s.TIME_LIMIT,s.IS_NETWORK,
   s.IS_FORMULA,s.PHONE,s.ADDRESS, s.LASTMODIFYTIME  ,
   s.file_name      ,
   s.audit_Sign,   s.MONITOR_PHONE    ,   s.ACCEPT_LINK    , s.LEGAL_TIME_LIMIT  ,s.CHARGE, FORM_NAME ,
   s.In_Flow_img_Name,
  -- s.ISCHARGE,
    s.PUNISH_CLASS  ,s.Transact_DEPNAME  , s.Promise_Type  ,  s.Anticipate_Type    ,
   s.QL_DepID  , s.QL_DepState ,s.ENTRUST_Name    ,s.QL_State,s.PunishBasis,s.punishobject,
   o.APPLY_ITEM_TYPE,o.GROUP_ID,o.wfcode as optFlowCode,p.wfcode as orgFlowCode,o.riskid,r.risktype,r.riskdes as RISKDESC,r.riskdeal as riskResult
from  b_v_powerinusing s
      left join C_POWER_OPT_INFO o on s.item_id = o.item_id
      left join opt_risk_info r on r.riskid=o.riskid
      left join c_power_org_info p on p.item_id=s.item_id;

--prompt
--prompt Creating view V_PCFREEUMPIRETYPEDEGREE
--prompt ======================================
--prompt
create or replace view epower.v_pcfreeumpiretypedegree as
select t1.*,t2.punishfactgrade from b_freeumpiretype t1 left join b_freeumpiredegree t2 on t1.degreeno=t2.degreeno;

--prompt
--prompt Creating view V_POREGISTERBASIC
--prompt ===============================
--prompt
create or replace view epower.v_poregisterbasic as
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
  from p_punish_object_basic b
  left join p_register_basic pore on pore.punishobjectid = b.punishobjectid
  left join p_individual poin on poin.punishobjectid=b.punishobjectid
  left join p_enterprise poen on poen.punishobjectid=b.punishobjectid
  left join P_Indagate_Rep_Basic poid on poid.punishobjectid=b.punishobjectid
  left join p_finish_basic pof on pof.punishobjectid=b.punishobjectid
  left join f_datadictionary da on da.datacode=b.pooriginstate and da.catalogcode='CASEORIGN';

--prompt
--prompt Creating view V_POWER_OPT_INFO
--prompt ==============================
--prompt
create or replace view epower.v_power_opt_info as
select t.item_id, su.item_name
    from c_power_opt_info t
    left join b_power su on t.item_id = su.item_id
   where
  -- su.isinuse = '1'
    -- and
     su.ql_state= 'A';

--prompt
--prompt Creating view V_PROC_ATTENTION
--prompt ==============================
--prompt
create or replace view epower.v_proc_attention as
select a.dj_id, a.usercode,a.attsettime,a.attsetuser,a.atttype,b.flowinstid,b.transaffairname,a.isatt from opt_proc_attention a join opt_base_info b on a.dj_id = b.dj_id;

--prompt
--prompt Creating view V_PUNISH
--prompt ======================
--prompt
create or replace view epower.v_punish as
select distinct M_Punish.No,M_Punish.Content,M_Punish.Chang_No,M_Punish.Org_Id,M_Punish.Internal_No,M_Punish.Item_Id,M_Punish.Department,
M_Punish.Punish_Target,M_Punish.Istrack,M_Punish.Target_Type,M_Punish.Fact,M_Punish.Source, M_Punish.Create_Date, case when M_Punish.Isrisk = 1 then 1 when M_Punish.Isrisk != 1 and M_PunishProcess.isrisk = 1 then 2 else 0 end Isrisk,
b_power.item_type, V_HI_UNITINFO.topunitcode,M_PunishResult.Finish_Date ,b_power.version
,case when outway.monitor_style = '0' then '3' else outway.monitor_style end monitor_style  From M_Punish
left join m_punishprocess on M_Punish.internal_No = m_punishprocess.internal_No and M_Punish.Org_Id = m_punishprocess.org_id
left join M_PunishResult  on M_Punish.internal_No = M_PunishResult.internal_No and M_Punish.Org_Id = M_PunishResult.Org_Id
             left join b_power on M_Punish.item_id = b_power.item_id
             left join V_HI_UNITINFO on  M_Punish.org_id = V_HI_UNITINFO.depno
              left join (select t.bj_type,t.bj_no,t.internal_no,t.org_id,t.item_id,max(case when t.monitor_style = '3' then '0' else t.monitor_style end ) monitor_style from m_outway t where t.outtime is null group by t.bj_type,t.bj_no,t.internal_no,t.org_id,t.item_id)  outway on outway.bj_no = M_Punish.no and outway.bj_type='2'
             where (b_power.version <> 0 and b_power.begin_time <= sysdate and (b_power.end_time is null or b_power.end_time >sysdate)) or b_power.item_id is null;

--prompt
--prompt Creating view V_P_TRANSLAWBASIC
--prompt ===============================
--prompt
create or replace view epower.v_p_translawbasic as
Select POTransLawBasic.degreeNo,
       POTransLawBasic.isSurpass,
       POTransLawBasic.TransLawDate,
       POTransLawBasic.PunishObjectID,
       b.item_id PunishClassCode,
       b.ORG_ID DepID,
       b.PunishBasis
  FROM P_Trans_Law_Basic POTransLawBasic
 INNER JOIN B_V_POWERINUSING b ON POTransLawBasic.item_id = b.item_id
 where 1 = 1
 ORDER BY POTransLawBasic.PunishObjectID, POTransLawBasic.TransLawDate;

--prompt
--prompt Creating view V_SR_APPLY_USER
--prompt =============================
--prompt
create or replace view epower.v_sr_apply_user as
select dj_id,
channel_name,
       channel_level,
       Elevation_system,
       APPLY_DATE,
       PROPOSER_NAME,
       APPLY_ITEM_type,
       APPLY_REASON,
       APPLY_WAY,
       PROPOSER_TYPE,
       PROPOSER_PAPER_TYPE,
       PROPOSER_PAPER_CODE,
       PROPOSER_PHONE,
       PROPOSER_MOBILE,
       PROPOSER_ADDR,
       PROPOSER_ZIPCODE,
       PROPOSER_EMAIL,
       PROPOSER_UNITCODE,
       AGENT_NAME,
       AGENT_PAPER_TYPE,
       AGENT_PAPER_CODE,
       AGENT_PHONE,
       AGENT_MOBILE,
       AGENT_ADDR,
       AGENT_ZIPCODE,
       AGENT_EMAIL,
       AGENT_UNITCODE,
       APPLY_MEMO
  from X_PERMIT_APPLY
 where dj_id in (select max(DJ_ID) as dj_id
                   from X_PERMIT_APPLY
                  group by PROPOSER_UNITCODE, PROPOSER_PAPER_CODE);


--spool off
