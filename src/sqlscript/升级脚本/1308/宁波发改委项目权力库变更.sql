alter table b_power add (item_Class varchar2(2), apply_Material clob, risk clob);
alter table b_power add (out_item_id varchar2(20));

/**权力归类字典项**/
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('itemClass', '权力归类', 'U', 'L', '权力归类', '权力归类', '0', '');



insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '1', '1', '', 'T', '项目投资', 'S', '项目投资');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '2', '2', '', 'T', '招投标', 'S', '招投标');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '3', '3', '', 'T', '企业债券', 'S', '企业债券');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '4', '4', '', 'T', '进出口配额', 'S', '进出口配额');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '5', '5', '', 'T', '政府投资', 'S', '政府投资');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '6', '6', '', 'T', '其他投资', 'S', '其他投资');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '7', '7', '', 'T', '外资相关', 'S', '外资相关');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '8', '8', '', 'T', '价格管理', 'S', '价格管理');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '9', '9', '', 'T', '收费管理', 'S', '收费管理');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('itemClass', '10', '10', '', 'T', '其他', 'S', '其他');

insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('seq_id', '风险等级', 'U', 'L', '风险等级', '风险等级', '0', '');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('seq_id', '1', '1', '', 'T', '一级', 'S', '一级');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('seq_id', '2', '2', '', 'T', '二级', 'S', '二级');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('seq_id', '3', '3', '', 'T', '三级', 'S', '三级');

