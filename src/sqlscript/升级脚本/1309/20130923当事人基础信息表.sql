/*==============================================================*/
/* Table: B_DataEnterprise                                    */
/*==============================================================*/
create table B_DataEnterprise  (
   EnterpriseID       NUMBER                          not null,
   APPLICANT            VARCHAR2(100)                   not null,
   APPLICANT_PAPER_TYPE VARCHAR2(2)                    default '8' not null,
   APPLICANT_PAPER_NUMBER VARCHAR2(50)                    not null,
   APPLICANT_PHONE      VARCHAR2(40),
   APPLICANT_MOBILE     VARCHAR2(20),
   APPLICANT_ADDRESS    VARCHAR2(200),
   APPLICANT_ZIPCODE    VARCHAR2(6),
   APPLICANT_EMAIL      VARCHAR2(100),
   Unit_Type          VARCHAR2(32),
   Corp_Domain        VARCHAR2(32),
   Reg_Type           VARCHAR2(32),
   Fax                VARCHAR2(20),
   LINKMAN              VARCHAR2(50),
   LINKMAN_NAME         VARCHAR2(100)                   not null,
   LINKMAN_PAPER_TYPE   VARCHAR2(2)                     not null,
   LINKMAN_PAPER_CODE   VARCHAR2(50)                    not null,
   LINKMAN_PHONE        VARCHAR2(40)                    not null,
   LINKMAN_MOBILE       VARCHAR2(20),
   LINKMAN_ADDRESS      VARCHAR2(200),
   LINKMAN_ZIPCODE      VARCHAR2(6),
   LINKMAN_EMAIL        VARCHAR2(100),
   Is_InUse           VARCHAR2(1)                       not null,
   Last_ModDate       DATE                            not null,
   constraint PK_B_DATAENTERPRISE primary key (EnterpriseID)
);

comment on column B_DataEnterprise.APPLICANT_PAPER_TYPE is
'营业执照';

comment on column B_DataEnterprise.Unit_Type is
'字典项';

comment on column B_DataEnterprise.Corp_Domain is
'字典项';

comment on column B_DataEnterprise.Reg_Type is
'字典项';

/*==============================================================*/
/* Table: B_DataIndividual                                    */
/*==============================================================*/
create table B_DataIndividual  (
   IndividualID       NUMBER                          not null,
   APPLICANT            VARCHAR2(100)                   not null,
   APPLICANT_PAPER_TYPE VARCHAR2(2)                    default '8' not null,
   APPLICANT_PAPER_NUMBER VARCHAR2(50)                    not null,
   APPLICANT_PHONE      VARCHAR2(40),
   APPLICANT_MOBILE     VARCHAR2(20),
   APPLICANT_ADDRESS    VARCHAR2(200),
   APPLICANT_ZIPCODE    VARCHAR2(6),
   APPLICANT_EMAIL      VARCHAR2(100),
   Sex                VARCHAR2(1),
   Work_Unit          VARCHAR2(100),
   Is_InUse           VARCHAR2(1)                       not null,
   Last_ModDate       DATE                            not null,
   constraint PK_B_DATAINDIVIDUAL primary key (IndividualID)
);

comment on column B_DataIndividual.APPLICANT_PAPER_TYPE is
'营业执照';

create sequence S_Individual_ID
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1
cache 20;

create sequence S_Enterprise_ID
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1
cache 20;

--组织机构性质
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('unitType', '组织机构性质', 'S', 'L', '', '', '0', '');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '01', '', '', 'T', '企业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '02', '', '', 'T', '事业单位', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '03', '', '', 'T', '机关', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '04', '', '', 'T', '社会团体', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '05', '', '', 'T', '民办非企业单位', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('unitType', '09', '', '', 'T', '其他组织机构', '', '');

--所在行业
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('corpDomain', '所在行业', 'S', 'L', '', '', '0', '');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '01', '', '', 'T', '餐饮业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '02', '', '', 'T', '服务业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '03', '', '', 'T', '网吧', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '04', '', '', 'T', '建筑业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '05', '', '', 'T', '教育业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '06', '', '', 'T', '出版业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '07', '', '', 'T', '制造业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '08', '', '', 'T', '零售业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '09', '', '', 'T', '医院', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('corpDomain', '10', '', '', 'T', '其他', '', '');

--所有制形式
insert into f_datacatalog (CATALOGCODE, CATALOGNAME, CATALOGSTYLE, CATALOGTYPE, CATALOGDESC, FIELDDESC, ISUPLOAD, DICTIONARYTYPE)
values ('regType', '所有制形式', 'S', 'L', '', '', '0', '');

insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '01', '', '', 'T', '国有', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '02', '', '', 'T', '集体', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '03', '', '', 'T', '股份合作', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '04', '', '', 'T', '国有联营', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '05', '', '', 'T', '集体联营', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '06', '', '', 'T', '国有与集体联营', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '07', '', '', 'T', '其他联营', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '08', '', '', 'T', '国有独资公司', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '09', '', '', 'T', '其他有限责任公司', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '10', '', '', 'T', '股份有限公司', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '11', '', '', 'T', '私营独资', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '12', '', '', 'T', '私营合伙', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '13', '', '', 'T', '私营有限责任公司', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '14', '', '', 'T', '私营股份有限公司', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '15', '', '', 'T', '其他', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '16', '', '', 'T', '与港澳台商合资经营', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '17', '', '', 'T', '外资企业', '', '');
insert into f_datadictionary (CATALOGCODE, DATACODE, EXTRACODE, EXTRACODE2, DATATAG, DATAVALUE, DATASTYLE, DATADESC)
values ('regType', '18', '', '', 'T', '中外合资经营', '', '');

--新增菜单
insert into f_optinfo (OPTID, PREOPTID, OPTNAME, FORMCODE, OPTURL, MSGNO, MSGPRM, ISINTOOLBAR, IMGINDEX, TOPOPTID, OPTTYPE, ORDERIND, WFCODE, PAGETYPE)
values ('DATAENTERPRISE', 'XZQLK', '组织结构管理', '', '/powerbase/dataenterprise!list.do', null, '', 'Y', null, '', 'N', 20, '', 'F');

insert into f_optinfo (OPTID, PREOPTID, OPTNAME, FORMCODE, OPTURL, MSGNO, MSGPRM, ISINTOOLBAR, IMGINDEX, TOPOPTID, OPTTYPE, ORDERIND, WFCODE, PAGETYPE)
values ('DATAINDIVIDUAL', 'XZQLK', '人员管理', '', '/powerbase/dataindividual!list.do', null, '', 'Y', null, '', 'N', 21, '', 'F');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001538', '查询', 'DATAENTERPRISE', 'list', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001539', '修改/添加', 'DATAENTERPRISE', 'edit', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001540', '删除', 'DATAENTERPRISE', 'delete', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001541', '查看明细', 'DATAENTERPRISE', 'view', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001542', '查询', 'DATAINDIVIDUAL', 'list', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001543', '修改/添加', 'DATAINDIVIDUAL', 'edit', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001544', '删除', 'DATAINDIVIDUAL', 'delete', '系统自动添加', '');

insert into f_optdef (OPTCODE, OPTNAME, OPTID, OPTMETHOD, OPTDESC, ISINWORKFLOW)
values ('10001545', '查看明细', 'DATAINDIVIDUAL', 'view', '系统自动添加', '');

