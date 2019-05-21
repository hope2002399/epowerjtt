/**复议结果字典项**/
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('reconsiderResult', '复议结果', 'U', 'L', '复议结果', '复议结果', '0', '');


/**复议结果字典项详细**/
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '8', '8', '', 'T', '和解协议(后终止)', 'S', '和解协议(后终止)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '9', '9', '', 'T', '自愿撤回申请(后终止)', 'S', '自愿撤回申请(后终止)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '10', '10', '', 'T', '被申请人改变后撤回申请(后终止)', 'S', '被申请人改变后撤回申请(后终止)');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '5', '5', '', 'T', '变更', 'S', '变更');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '6', '6', '', 'T', '责令履行', 'S', '责令履行');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '7', '7', '', 'T', '调解', 'S', '调解');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '3', '3', '', 'T', '确认违法', 'S', '确认违法');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '4', '4', '', 'T', '撤销', 'S', '撤销');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '12', '12', '', 'T', '其他', 'S', '其他');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '11', '11', '', 'T', '其他情况终止', 'S', '其他情况终止');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '1', '1', '', 'T', '驳回', 'S', '驳回');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('reconsiderResult', '2', '2', '', 'T', '维持', 'S', '维持');

/** 复议通用配置 **/

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_slsc', '复议受理审查', 'XZFY_SLSC', '复议受理审查', 'F', '', '', 'F', '', 'F', '', '', '', 'F', 'F', 'F', null, 'T', '', '经办人', 'D(all)', '', '', 'T', '', '', '复议受理审查', 'T');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_jd', '复议决定', 'reconsiderResult', '办理说明', 'F', '', '', 'F', '', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '复议决定', 'T');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_sl', '审理', '', '审理说明', 'F', '', '', 'T', '134', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '复议审理', 'F');

insert into general_module_param (MODULECODE, IDEALABEL, IDEACATALOG, IDEACONTENT, HASATTENTION, ATTENTIONLABEL, ATTENTIONFILTER, HASSTUFF, STUFF_GROUP_ID, HASDOCUMENT, DOCUMENTLABEL, DOCUMENTTYPE, DOCUMENTTEMPLATENAMES, CANDEFER, CANROLLBACK, CANCLOSE, RISKID, ASSIGNTEAMROLE, TEAMROLECODE, TEAMROLENAME, TEAMROLEFILTER, MUSTCREATEDOC, DOCUMENTTEMPLATEIDS, ISINUSE, SUBMITOPTURI, SAVEOPTURI, NODENAME, HASIDEA)
values ('fy_bccl', '', '', '备注说明', 'F', '', '', 'T', '133', 'F', '', '', '', 'F', 'F', 'F', null, 'F', '', '', '', '', '', 'T', '', '', '退回补充材料', 'F');

