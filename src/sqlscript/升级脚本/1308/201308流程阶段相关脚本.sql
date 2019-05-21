
create table WF_FLOW_STAGE  (
   STAGEID              number(16)                       not null,
   VERSION              NUMBER(4),
   WFCODE               VARCHAR2(8),
   STAGECODE            varchar2(32)                     not null,
   STAGENAME            varchar2(60),
   isAccountTime        CHAR,
   LimitType            CHAR,
   TimeLimit            VARCHAR2(20),
   ExpireOpt            CHAR,
   constraint PK_WF_FLOW_STAGE primary key (STAGEID)
)
/

comment on column WF_FLOW_STAGE.VERSION is
'版本号为 0 的为草稿， 有效版本号从 1 开始'
/

comment on column WF_FLOW_STAGE.WFCODE is
'同一个代码的流程应该只有一个有效的版本'
/

comment on column WF_FLOW_STAGE.isAccountTime is
'改是否记入（流程）时间 T/F'
/

comment on column WF_FLOW_STAGE.LimitType is
'期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
'
/

comment on column WF_FLOW_STAGE.TimeLimit is
'5D4H 这样的表达式'
/

comment on column WF_FLOW_STAGE.ExpireOpt is
'N：通知， O:不处理 ， S：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）'
/


create table WF_STAGE_INSTANCE  (
   WFINSTID             NUMBER(12)                       not null,
   STAGEID              number(16)                       not null,
   STAGECODE            varchar2(32)                     not null,
   promiseTime          NUMBER(10),
   timeLimit            NUMBER(10),
   ExpireOptSign        number(2)                      default 0,
   constraint PK_WF_STAGE_INSTANCE primary key (WFINSTID, STAGEID)
)
/

comment on table WF_STAGE_INSTANCE is
'在流程创建时同时创建这个流程所有的阶段'
/

comment on column WF_STAGE_INSTANCE.promiseTime is
'承诺时间 1天8小时，1小时60 分钟 这儿按照分钟计算'
/


create table WF_ORGANIZE  (
   WFINSTID             NUMBER(12)                       not null,
   UNITCODE             VARCHAR2(8)                      not null,
   ROLECODE             VARCHAR2(32)                     not null,
   AUTHDESC             VARCHAR2(255),
   AUTHTIME             Date                           default sysdate  not null,
   constraint PK_WF_ORGANIZE primary key (WFINSTID, UNITCODE, ROLECODE)
)
/

