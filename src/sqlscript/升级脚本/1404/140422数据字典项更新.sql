insert into F_Datacatalog(catalogcode,catalogname,catalogstyle,catalogtype) values('CHG_RESULT','变更结果','U','L');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('CHG_RESULT','0','T','不同意');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('CHG_RESULT','1','T','同意');

insert into F_Datacatalog(catalogcode,catalogname,catalogstyle,catalogtype,Catalogdesc) values('APPLYSTATUS','许可岗位状态','U','L','取值为以下数字：1：正在处理；2：暂停；3：补正；4：退回；5：通过；6：中止；7：受理');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','1','','正在处理');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','2','','暂停');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','3','','补正');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','4','','退回');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','5','','通过');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','6','','中止');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('APPLYSTATUS','7','','受理');

insert into F_Datacatalog(catalogcode,catalogname,catalogstyle,catalogtype) values('STATUS','状态','S','L');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('STATUS','1','','不予受理');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('STATUS','2','','许可');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('STATUS','3','','不予许可');

