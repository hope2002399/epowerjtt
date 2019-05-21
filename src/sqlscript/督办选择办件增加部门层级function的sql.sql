create or replace function f_getbumencjforcx(orgid in varchar2)

    return  varchar2
    is
  bmcj varchar2(4000);
   begin
    for r in (select level,t.* from f_unitinfo t connect by  unitcode= prior parentunit start with depno = orgid order by level desc ) loop

        bmcj:=bmcj||'*'||r.unitcode||',';
      end loop;



     return bmcj;
   end f_getbumencjforcx;