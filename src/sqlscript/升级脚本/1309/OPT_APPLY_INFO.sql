-- Create table
create table OPT_APPLY_INFO
(
  DJ_ID               VARCHAR2(32) not null,
  CHANNEL_NAME        VARCHAR2(256),
  CHANNEL_LEVEL       VARCHAR2(2),
  ELEVATION_SYSTEM    VARCHAR2(256),
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
-- Add comments to the table 
comment on table OPT_APPLY_INFO
  is '将这个表更改为许可业务数据表，记录业务数据， 不仅仅是申请数据，包括审核数据


5.3 实质审查意见


许可事项
受理时间
核查时间
核查地点
核查情况
核查人意见
核查人员签名
核查意见填写日期
单位负责人审核意见
单位负责人签名
审核意见填写时间
备注
';
-- Add comments to the columns 
comment on column OPT_APPLY_INFO.DJ_ID
  is '办件信息登记id';
comment on column OPT_APPLY_INFO.APPLY_ITEM_TYPE
  is '对应权力表的申请事项类别，作为业务数据分类';
comment on column OPT_APPLY_INFO.APPLY_WAY
  is '当面/电话/传真/电报/信函/电子邮件/其他';
comment on column OPT_APPLY_INFO.PROPOSER_TYPE
  is '自然人/法人/其他';
comment on column OPT_APPLY_INFO.PROPOSER_PAPER_TYPE
  is '0身份证/1护照2回乡证/3居住证/4军官证/5特区护照/6通行证/7台胞证/10 其他';
comment on column OPT_APPLY_INFO.BOOK_DATE
  is '申请登记时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_APPLY_INFO
  add constraint PK_OPT_APPLY_INFO primary key (DJ_ID)
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
