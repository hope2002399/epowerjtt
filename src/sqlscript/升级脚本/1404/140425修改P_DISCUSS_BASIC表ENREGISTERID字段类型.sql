alter table P_DISCUSS_BASIC  add ENREGISTERID_temp varchar(8);
-- Add/modify columns 
update  P_DISCUSS_BASIC  set ENREGISTERID_temp = to_char(ENREGISTERID),ENREGISTERID=null;
commit;
alter table  P_DISCUSS_BASIC  modify ENREGISTERID varchar(8);
update  P_DISCUSS_BASIC  set ENREGISTERID = ENREGISTERID_temp,ENREGISTERID_temp=null;
commit;
alter table  P_DISCUSS_BASIC  drop column ENREGISTERID_temp;
select * from  P_DISCUSS_BASIC;