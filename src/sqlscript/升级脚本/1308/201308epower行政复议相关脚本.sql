/**�������ֵ���**/
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('reconsiderResult', '������', 'U', 'L', '������', '������', '0', '');


/**�������ֵ�����ϸ**/
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '8', '8', '', 'T', '�ͽ�Э��(����ֹ)', 'S', '�ͽ�Э��(����ֹ)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '9', '9', '', 'T', '��Ը��������(����ֹ)', 'S', '��Ը��������(����ֹ)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '10', '10', '', 'T', '�������˸ı�󳷻�����(����ֹ)', 'S', '�������˸ı�󳷻�����(����ֹ)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '5', '5', '', 'T', '���', 'S', '���');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '6', '6', '', 'T', '��������', 'S', '��������');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '7', '7', '', 'T', '����', 'S', '����');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '3', '3', '', 'T', 'ȷ��Υ��', 'S', 'ȷ��Υ��');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '4', '4', '', 'T', '����', 'S', '����');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '12', '12', '', 'T', '����', 'S', '����');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '11', '11', '', 'T', '���������ֹ', 'S', '���������ֹ');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '1', '1', '', 'T', '����', 'S', '����');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '2', '2', '', 'T', 'ά��', 'S', 'ά��');

/** ����ͨ������ **/

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_slsc', '�����������', 'XZFY_SLSC', '�����������', 'F', '', '', 'F', '', 'F', '', '', '', 'F', 'F', 'F', null, 'T', '', '������', 'D(all)', '', '', 'T', '', '', '�����������', 'T');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_jd', '�������', 'reconsiderResult', '����˵��', 'F', '', '', 'F', '', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '�������', 'T');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_sl', '����', '', '����˵��', 'F', '', '', 'T', '134', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '��������', 'F');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_bccl', '', '', '��ע˵��', 'F', '', '', 'T', '133', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '�˻ز������', 'F');

