alter table M_outway  add outwayno_temp varchar(50);

ALTER TABLE M_outway DROP CONSTRAINT PK_M_OUTWAY;
alter table M_outway  modify outwayno null; 

update  M_outway  set outwayno_temp = to_char(outwayno),outwayno=null;
commit;
alter table  M_outway  modify outwayno varchar(50);
update  M_outway  set outwayno = outwayno_temp,outwayno_temp=null;

alter table M_outway  modify outwayno not null; 
ALTER TABLE M_outway ADD (CONSTRAINT PK_M_OUTWAY PRIMARY KEY(outwayno));
commit;
alter table  M_outway  drop column outwayno_temp;

--select * from  M_outway;