create or replace view f_v_useroptmoudlelist as
select  distinct a.UserCode,d.OptID, d.OptName , d.PreOptID  ,
            d.FormCode  , d.opturl, d.MsgNo , d.MsgPrm, d.IsInToolBar ,
            d.ImgIndex,d.TopOptID ,d.OrderInd,d.PageType,d.opttype
from F_V_USERROLES a  join F_ROLEPOWER b on (a.RoleCode=b.RoleCode)
         join F_OPTDEF  c on(b.OPTCODE=c.OPTCODE)
        join F_OptInfo d on(c.OPTID=d.OptID)
where d.opturl<>'...'


create or replace view v_hi_optinfo as
select connect_by_root  t.optid  as topoptid, level as hi_level , t.optid , t.optname
from f_optinfo t
connect by prior t.optid = t.preoptid