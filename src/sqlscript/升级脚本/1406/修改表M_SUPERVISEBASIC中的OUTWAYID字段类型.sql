alter table M_SUPERVISEBASIC  add OUTWAYID_temp varchar2(50);
-- Add/modify columns 
update  M_SUPERVISEBASIC  set OUTWAYID_temp=to_char(OUTWAYID),OUTWAYID=null;
commit;
alter table  M_SUPERVISEBASIC  modify OUTWAYID varchar2(50);
update  M_SUPERVISEBASIC  set OUTWAYID=OUTWAYID_temp,OUTWAYID_temp=null;
commit;
alter table  M_SUPERVISEBASIC  drop column OUTWAYID_temp;
select * from  M_SUPERVISEBASIC;