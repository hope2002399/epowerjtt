prompt PL/SQL Developer import file
prompt Created on 2014年5月5日 by jf
set feedback off
set define off
prompt Disabling triggers for Q_QUERYCOLUMN...
alter table Q_QUERYCOLUMN disable all triggers;
prompt Disabling triggers for Q_QUERYMODEL...
alter table Q_QUERYMODEL disable all triggers;
prompt Disabling triggers for Q_QUERYCONDITION...
alter table Q_QUERYCONDITION disable all triggers;
prompt Disabling foreign key constraints for Q_QUERYCONDITION...
alter table Q_QUERYCONDITION disable constraint 一对多;
prompt Loading Q_QUERYCOLUMN...
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('xzqlhyfb', '权力类型', '0', 'T', 'O', null, 1, 'T', null, 'R', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('xzqlhyfb', '行业类型', '0', 'T', 'L', null, 2, 'T', 'INDUSTRY_TYPE2', 'C', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('xzqlhyfb', '数量', '0', 'T', 'N', null, 3, 'T', '#', 'D', 'S', '0');
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlsltj-home', '1', '0', 'T', 'S', null, 1, 'T', null, 'R', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlqstj-home', '日期', '0', 'T', 'D', null, 2, 'T', 'MM月', 'C', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlqstj-home', '办件量', '0', 'T', 'S', null, 1, 'T', null, 'R', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlsltj-home', '办件类型', '0', 'T', 'L', null, 2, 'T', 'ITEM_TYPE2', 'C', 'S', null);
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlsltj-home', '数量', '0', 'T', 'N', null, 3, 'T', '#', 'D', 'S', '0');
insert into Q_QUERYCOLUMN (MODELNAME, COLNAME, OPTTYPE, DRAWCHART, COLTYPE, COLLOGIC, COLORDER, ISSHOW, COLFORMAT, SHOWTYPE, LINKTYPE, DEFAULTVALUE)
values ('bjlqstj-home', '数量', '0', 'T', 'N', null, 3, 'T', '#', 'D', 'S', null);
commit;
prompt 9 records loaded
prompt Loading Q_QUERYMODEL...
insert into Q_QUERYMODEL (MODELNAME, MODELTYPE, OWNERTYPE, OWNERCODE, QUERYSQL, QUERYDESC, FORMNAMEFORMAT, RESULTNAME, ROWDRAWCHART, DRAWCHARTBEGINCOL, DRAWCHARTENDCOL, ADDITIONROW, ROWLOGIC, ROWLOGICVALUE, LOGICURL, COLUMNSQL, ISTREE)
values ('bjlqstj-home', '5', 'R', 'JTTXQ', 'select 1, da.d, count(1) as num' || chr(13) || '' || chr(10) || '  from (select to_char(a.create_date, ''yyyy-mm'') as d, substr(a.item_id, 12, 2) as item_type' || chr(13) || '' || chr(10) || '          from m_apply a' || chr(13) || '' || chr(10) || '        union all' || chr(13) || '' || chr(10) || '        select to_char(p.create_date, ''yyyy-mm'') as d, ''CF'' as item_type from m_punish p) da' || chr(13) || '' || chr(10) || ' group by  da.d' || chr(13) || '' || chr(10) || ' order by da.d', '办件量趋势（homPageBjlqs）', '办件量趋势', 'homPageBjlqs', 'F', 1, 1, '0', '0', 0, null, 'select to_char(add_months(sysdate, -11), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -10), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -9), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -8), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -7), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -6), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -5), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -4), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -3), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -2), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, -1), ''yyyy-mm'') from dual' || chr(13) || '' || chr(10) || 'union all' || chr(13) || '' || chr(10) || 'select to_char(add_months(sysdate, 0), ''yyyy-mm'') from dual', null);
insert into Q_QUERYMODEL (MODELNAME, MODELTYPE, OWNERTYPE, OWNERCODE, QUERYSQL, QUERYDESC, FORMNAMEFORMAT, RESULTNAME, ROWDRAWCHART, DRAWCHARTBEGINCOL, DRAWCHARTENDCOL, ADDITIONROW, ROWLOGIC, ROWLOGICVALUE, LOGICURL, COLUMNSQL, ISTREE)
values ('bjlsltj-home', '5', 'R', 'JTTXQ', 'select 1, da.item_type, count(1) as num' || chr(13) || '' || chr(10) || '  from (select substr(a.item_id, 12, 2) as item_type' || chr(13) || '' || chr(10) || '          from m_apply a' || chr(13) || '' || chr(10) || '        union all' || chr(13) || '' || chr(10) || '        select ''CF'' as item_type from m_punish p) da' || chr(13) || '' || chr(10) || ' group by da.item_type', '办件量数量统计', '办件量数量统计', 'homPageBjlsl', 'F', 1, 1, '1', '0', 0, null, 'select t.datacode from f_datadictionary t where t.catalogcode = ''ITEM_TYPE2'' order by t.extracode2', null);
insert into Q_QUERYMODEL (MODELNAME, MODELTYPE, OWNERTYPE, OWNERCODE, QUERYSQL, QUERYDESC, FORMNAMEFORMAT, RESULTNAME, ROWDRAWCHART, DRAWCHARTBEGINCOL, DRAWCHARTENDCOL, ADDITIONROW, ROWLOGIC, ROWLOGICVALUE, LOGICURL, COLUMNSQL, ISTREE)
values ('xzqlhyfb', '5', 'R', 'JTTXQ', 'select t.ITEM_TYPE, nvl(substr(t.QL_DepID, 9), ''QT'') as ql, count(1) as num' || chr(13) || '' || chr(10) || '  from b_v_powerinusing t' || chr(13) || '' || chr(10) || ' group by t.ITEM_TYPE, substr(t.QL_DepID, 9)' || chr(13) || '' || chr(10) || ' order by t.item_type, substr(t.QL_DepID, 9)', '行政权力行业分布', '行政权力行业分布', 'homePageQlfb', 'F', 1, 1, '1', '0', 0, null, 'select t.datacode from f_datadictionary t where t.catalogcode = ''INDUSTRY_TYPE2'' order by t.extracode2', null);
commit;
prompt 3 records loaded
prompt Loading Q_QUERYCONDITION...
prompt Table is empty
prompt Enabling foreign key constraints for Q_QUERYCONDITION...
alter table Q_QUERYCONDITION enable constraint 一对多;
prompt Enabling triggers for Q_QUERYCOLUMN...
alter table Q_QUERYCOLUMN enable all triggers;
prompt Enabling triggers for Q_QUERYMODEL...
alter table Q_QUERYMODEL enable all triggers;
prompt Enabling triggers for Q_QUERYCONDITION...
alter table Q_QUERYCONDITION enable all triggers;
set feedback on
set define on
prompt Done.
