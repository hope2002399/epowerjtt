CREATE TABLE WF_NODE_TEMP AS (select distinct * from WF_NODE); 
delete from WF_NODE; 
insert into WF_NODE (select * from WF_NODE_TEMP); 
drop table WF_NODE_TEMP;