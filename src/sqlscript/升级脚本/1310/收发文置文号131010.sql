-- Create table
create table OPT_ZWH
(
  NODEID    VARCHAR2(20) not null,
  DJ_ID     VARCHAR2(32),
  FWH       VARCHAR2(100),
  IDEA      VARCHAR2(20),
  OPTCODE   VARCHAR2(16),
  NODEDEFID VARCHAR2(16),
  WJLX      VARCHAR2(5),
  LSH       VARCHAR2(20),
  LSHYEAR   VARCHAR2(10),
  RISKTYPE  VARCHAR2(200),
  RISKDES   VARCHAR2(2000),
  RISKDEAL  VARCHAR2(2000),
  WBQFDATE  DATE
)
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPT_ZWH
  add constraint PK_QLYX_ZWH primary key (NODEID)
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