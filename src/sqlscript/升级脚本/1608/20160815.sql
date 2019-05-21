-- Add/modify columns 
alter table B_POWER_ITEM add item_qldy_powerid varchar2(50);
-- Add comments to the columns 
comment on column B_POWER_ITEM.item_qldy_powerid
  is '对应b_power中的item_id；一旦关联，主项不可拆分子项，子项不可拆分业务';