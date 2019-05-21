create or replace view v_sub_department as
select
/* ============================================================
 * Created: [2013-12-18 14:36:23] by zhangkai
 * ============================================================
 *
 * ProjectName
 *          V_SUB_DEPARTMENT
 * Description
 *          部门-子部门组成的笛卡尔积视图，可以用于统计父级
 *          部门需要子部门求和的操作
* ==========================================================*/

       a.depno,                         /*部门编码*/
       b.depno as subdepno,             /*子部门编码*/
       a.unitcode,                      /*单位编码*/
       b.unitcode as subunit,           /*子单位编码*/
       a.parentunit,                    /*父单位编码*/
       a.unitname,                      /*部门名称*/
       a.unitshortname,                 /*部门简称*/
       b.hi_level                       /*层级*/
  from f_unitinfo a,
       (select level as hi_level,
               depno,
               unitcode,
               trim(SYS_CONNECT_BY_PATH(case level
                                          when 1 then
                                           unitcode
                                        end,
                                        ' ')) as topdepid
          from f_unitinfo t
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.topdepid;
 
 
create or replace view v_sub_department_top as
select
/* ============================================================
 * Created: [2013-12-24 14:36:23] by zhangkai
 * ============================================================
 *
 * ProjectName
 *          V_SUB_DEPARTMENT_TOP
 * Description
 *          部门-子部门组成的笛卡尔积视图，可以用于统计父级
 *          部门需要子部门求和的操作
 *          所展示的顶级部门在数据字典中 SYSPARAM - TOPDEPT定义部门编码DEPNO
* ==========================================================*/

       a.depno,                         /*部门编码*/
       b.depno as subdepno,             /*子部门编码*/
       a.unitcode,                      /*单位编码*/
       b.unitcode as subunit,           /*子单位编码*/
       a.parentunit,                    /*父单位编码*/
       a.unitname,                      /*部门名称*/
       a.unitshortname,                 /*部门简称*/
       b.hi_level                       /*层级*/
  from f_unitinfo a,
       (select level as hi_level,
               depno,
               unitcode,
               trim(SYS_CONNECT_BY_PATH(case level
                                          when 1 then
                                           unitcode
                                        end,
                                        ' ')) as topdepid
          from f_unitinfo t
          start with (parentunit = (select t.datavalue from f_datadictionary t where t.catalogcode = 'SYSPARAM' and t.datacode='TOPDEPT'))
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.topdepid;



