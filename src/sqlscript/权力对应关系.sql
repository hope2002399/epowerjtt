-- Create table
create table POWER_QLDY
(
  b_power_item_id VARCHAR2(100) not null,
  other_item_id   VARCHAR2(100) not null,
  other_nb_id     VARCHAR2(100)
)
tablespace EPOWERJTT2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column POWER_QLDY.b_power_item_id
  is 'b_power表的item_id';
comment on column POWER_QLDY.other_item_id
  is '别的库的item_id';
comment on column POWER_QLDY.other_nb_id
  is '别的库的nb_id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table POWER_QLDY
  add constraint POWER_QLDY_PK primary key (B_POWER_ITEM_ID)
  using index 
  tablespace EPOWERJTT2
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

create or replace view v_power_qldy as
select t.item_id,t.item_name,t.item_type,t.org_id,a.other_item_id,a.other_nb_id
  from b_power t left join power_qldy a on t.item_id=a.b_power_item_id
 where t.ql_state = 'A'
   and t.end_time is null
   and t.version = (select max(s.version)
                      from b_power s
                     where s.item_id = t.item_id
                       ) order by t.item_id;
 