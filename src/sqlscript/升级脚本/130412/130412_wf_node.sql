 alter table WF_NODE add
(
 NODECODE      VARCHAR2(20),
  RISKINFO      VARCHAR2(4)
 );
 
comment on column WF_NODE.NODECODE  is '环节代码';
comment on column WF_NODE.RISKINFO  is '风险点';