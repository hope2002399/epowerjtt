create table APPLYUSER
(
  USERID           NUMBER(8) not null,
  USERNAME         VARCHAR2(100),
  USERPASSWORD     VARCHAR2(50),
  DEPNAME          VARCHAR2(100),
  DEPAADDRESS      VARCHAR2(200),
  POST             CHAR(10),
  ARTIFICIALPERSON VARCHAR2(100),
  TELEPHONE        VARCHAR2(50),
  EXISTDATE        DATE,
  ISCANCEL         NUMBER(1),
  ENTERPRISEID     NUMBER(18),
  ISINUSE          NUMBER(1),
  CHECKOPERATORID  varchar2(20),
  CHECKDATE        DATE,
  REMARK           VARCHAR2(2000),
  LINKMAN          VARCHAR2(50),
  is_sync		   varchar2(1),
  sync_date	       date,
  sync_desc		   varchar2(1000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table APPLYUSER
  add constraint P_APPLYUSER primary key (USERID);

--更改CHECKOPERATORID字段类型为varchar2

  alter table APPLYUSER
  modify column CHECKOPERATORID varchar2(20)  ;
--审核用户的路径  /sys/applyUser!list.do
  
  
  
  --20150515
  --APPLYUSER增加字段papercode、email_person
  alter table APPLYUSER add (papercode varchar2(1000),email_person varchar2(1000));
  --APPENTERPRISE增加字段filename、filecontent
  alter table APPENTERPRISE add (filename varchar2(1000),filecontent blob);
 
  