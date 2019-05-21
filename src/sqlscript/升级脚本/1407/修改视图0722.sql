--更改内容：在这个视图中添加了字段
create or replace view v_hi_unitinfo as
select b.topunitcode , b.topunitno , b.topunitname, b.topunitshortname,
       a.unitcode,a.unittype, a.parentunit, a.isvalid,
       a.unitname,a.unitdesc,a.unitshortname,a.addrbookid,a.depno,a.unitorder,
       a.unitword,a.unitgrade,a.unitdazt,a.prefix, b.hi_level
  from f_unitinfo a,
       (select level as hi_level,
               unitcode,
               CONNECT_BY_ROOT unitcode as topunitcode,
               CONNECT_BY_ROOT depno as topunitno,
               CONNECT_BY_ROOT unitname as topunitname,
               CONNECT_BY_ROOT unitshortname as topunitshortname
          from f_unitinfo t
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.unitcode;
 
 
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
               CONNECT_BY_ROOT unitcode  as topdepid
          from f_unitinfo t
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.topdepid;