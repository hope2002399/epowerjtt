-- Add/modify columns 
alter table S_LAWEXECUTOR add AUDIT_IDEACODE char(1);
alter table S_LAWEXECUTOR add AUDIT_IDEACONTENT varchar2(256);
alter table S_LAWEXECUTOR add AUDIT_USERCODE varchar2(6);
alter table S_LAWEXECUTOR add AUDIT_DATE date;
-- Add comments to the columns 
comment on column S_LAWEXECUTOR.AUDIT_IDEACODE
  is '������';
comment on column S_LAWEXECUTOR.AUDIT_IDEACONTENT
  is '������˵��';
comment on column S_LAWEXECUTOR.AUDIT_USERCODE
  is '�����';
comment on column S_LAWEXECUTOR.AUDIT_DATE
  is '���ʱ��';
