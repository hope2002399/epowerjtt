create or replace view F_V_USERROLES  as
  select distinct b.ROLECODE,b.ROLENAME,b.ISVALID,b.ROLEDESC,a.usercode
    from F_USERROLE a join F_ROLEINFO b on (a.ROLECODE=b.ROLECODE)
    where a.OBTAINDATE <= sysdate and (a.SECEDEDATE is null or a.SECEDEDATE > sysdate) and b.ISVALID='T'
union all
  select d.ROLECODE,d.ROLENAME,d.ISVALID,d.ROLEDESC,c.usercode
   from f_userinfo c , F_ROLEINFO d
   where d.rolecode = 'G-public'
/

create or replace view f_v_useroptlist as
select  distinct a.UserCode,  c.OPTCODE,  c.OPTNAME  ,  c. OPTID ,  c.OPTMETHOD
from F_V_USERROLES a  join F_ROLEPOWER   b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
/
         
create or replace view f_v_useroptmoudlelist as
select  distinct a.UserCode,d.OptID, d.OptName , d.PreOptID  ,
            d.FormCode  , d.opturl, d.MsgNo , d.MsgPrm, d.IsInToolBar ,
            d.ImgIndex,d.TopOptID ,d.OrderInd,d.PageType,d.opttype
from F_V_USERROLES a  join F_ROLEPOWER b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
        join F_OptInfo d on(c.OPTID=d.OptID)
where  d.opturl<> '...'
/