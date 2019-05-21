alter table P_PUNISH_OBJECT_BASIC  add OPERATORID_temp varchar(8);
-- Add/modify columns 
update  P_PUNISH_OBJECT_BASIC  set OPERATORID_temp=to_char(OPERATORID),OPERATORID=null;
commit;
alter table  P_PUNISH_OBJECT_BASIC  modify OPERATORID varchar(8);
update  P_PUNISH_OBJECT_BASIC  set OPERATORID=OPERATORID_temp,OPERATORID_temp=null;
commit;
alter table  P_PUNISH_OBJECT_BASIC  drop column OPERATORID_temp;
select * from  P_PUNISH_OBJECT_BASIC;
