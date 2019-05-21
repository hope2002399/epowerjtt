create or replace view v_hi_unitinfo as
select b.topunitcode as topunitcode, a.unitcode,a.unittype, a.parentunit, a.isvalid, 
       a.unitname,a.unitdesc,a.unitshortname,a.addrbookid,a.depno,a.unitorder,
       a.unitword,a.unitgrade,a.unitdazt,a.prefix, b.hi_level
  from f_unitinfo a,
       (select level as hi_level,
               unitcode,
               CONNECT_BY_ROOT unitcode as topunitcode
          from f_unitinfo t
        connect by prior unitcode = parentunit) b
 where a.unitcode = b.unitcode;

