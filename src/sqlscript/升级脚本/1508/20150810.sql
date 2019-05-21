--1,数据字典增加areacode地区代码（f_datacatalog，f_datadictionary）
--
insert into F_DATACATALOG (catalogcode,catalogname,catalogstyle,catalogtype,catalogdesc,isupload)
values('areacode','辖区字典','U','L','辖区字典','0');

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS01', '01', null, 'T', '南京市', 'S', '江苏');

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS02', '02', null, 'T', '无锡市', 'S', '江苏');

insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS03', '03', null, 'T', '徐州市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS04', '04', null, 'T', '常州市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS05', '05', null, 'T', '苏州市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS06', '06', null, 'T', '南通市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS07', '07', null, 'T', '连云港市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS08', '08', null, 'T', '淮安市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS09', '09', null, 'T', '盐城市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS10', '10', null, 'T', '扬州市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS11', '11', null, 'T', '镇江市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS12', '12', null, 'T', '泰州市', 'S', '江苏');
insert into F_DATADICTIONARY (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('areacode', 'JS13', '13', null, 'T', '宿迁市', 'S', '江苏');

commit;