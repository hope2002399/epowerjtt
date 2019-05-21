--材料类型
insert into F_Datacatalog(catalogcode,catalogname,catalogstyle,catalogtype) values('stuffType','材料类型','U','L');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('stuffType','01','','备案报告');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('stuffType','02','','规范性文件正式文本');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('stuffType','03','','制定说明');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('stuffType','04','','制定依据');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('stuffType','05','','其他');


--材料类别
insert into F_Datacatalog(catalogcode,catalogname,catalogstyle,catalogtype) values('FILETYPE','材料类别','U','L');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','1','T','收文');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','2','T','发文');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','3','T','申请附件');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','4','T','办理附件');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','5','T','格式文书');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','6','T','证据');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('FILETYPE','7','T','暂扣');


--模板类型 
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('TEMPLATE_TYPE','cf_dccf','T','行政（现场）处罚决定书');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('TEMPLATE_TYPE','cf_xcbl','T','现场笔录');
insert into f_datadictionary(catalogcode,datacode,datatag,datavalue) values('TEMPLATE_TYPE','cf_xwbl','T','询问笔录');