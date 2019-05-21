---督查督办信息表
create table M_SuperviseBasic  (
   supervise_no       VARCHAR2(50)                    not null,
   flowInstId         NUMBER(12),
   BJ_Type            CHAR(1),
   BJ_NO                VARCHAR2(50),
   ComplaintID        VARCHAR2(50),
   OutWayID           NUMBER(10),
   ORG_ID               VARCHAR2(10),
   OPERATOR_NAME        VARCHAR2(30),
   operator_ID        VARCHAR2(10),
   supervise_date     DATE,
   MONITOR_ORG_ID       VARCHAR2(10),
   MONITOR_ORG_NAME     VARCHAR2(100),
   MONITOR_OPERATOR_ID  VARCHAR2(30),
   MONITOR_OPERATOR_NAME VARCHAR2(30),
   supervise_Option   VARCHAR2(200),
   ATTACHMENT           bLOB,
   ATTACHMENTName     VARCHAR2(200),
   promise_Date       date,
   UPDATE_DATE          DATE,
   SYNC_DATE            DATE,
   SYNC_SIGN            VARCHAR2(1),
   SYNC_ERROR_DESC      VARCHAR2(1000),
   OPTID                VARCHAR2(20),
   constraint PK_M_SUPERVISEBASIC primary key (supervise_no)
);


---督察督办待办视图v_user_task_list_Supervise
