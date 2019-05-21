create or replace procedure P_CJJC_OUTWAY AS --by pk
begin
  --����1
  for r in (select S_dbyc_outway.Nextval id, t.*
              from (SELECT sao.outwayid --Ԥ�����
							,sa.org_id,sa.internal_no
                      FROM (select *
                              from supapplyoutway
                             ) sao
                      join supapply sa
                        on sao.internal_no = sa.internal_no
                       and sao.item_id = sa.item_id
                      left join (select *
                                  from Supinfobasic
                                 where supervisetype = '1') a
                        on sa.no = a.no
                     where nvl(a.superdate, sysdate) > sao.intime + 5 --���Ԥ��5 ��֮��δ����
                    union all
                    SELECT sao.outwayid	,sa.org_id,sa.internal_no
                      FROM (select *
                              from suppunishoutway
                            ) sao
                      join suppunish sa
                        on sao.internal_no = sa.internal_no
                       and sao.org_id = sa.org_id
                      left join (select *
                                   from Supinfobasic
                                  where supervisetype = '2') a
                        on sa.no = a.no
                     where nvl(a.superdate, sysdate) > sao.intime + 5 --����Ԥ��5 ��֮��δ����
                    ) t) loop
    insert into sup_dbyc_outway
      (outwayid,
       warnpointno,
       old_outway_id,
       outwaytype,
       org_id,
			 internal_no
       /*   intime,
       outtime,
       outperson,
       outreason,
       outwayinfo,
       update_date,
       read_date*/)
    values
      (r.id, 'E001', r.outwayid, '2', r.org_id,r.internal_no); --'2' ��ʱ����
  /*  update supapplyoutway t
       set t.is_cjjc = 1
     where t.outwayid = r.outwayid;
    update suppunishoutway t
       set t.is_cjjc = 1
     where t.outwayid = r.outwayid;*/
  end loop;
  commit;

  --����2
  --alter table SUPINFOBASIC add is_cjjc number(1);comment on column SUPINFOBASIC.is_cjjc is '0:δ��� 1���Ѽ��';
  for r2 in (select s.supervisecode,sa.org_id--������
               from Supinfobasic s
							 join supapply sa on sa.no=s.no
              where 
                 nvl(s.enddate, sysdate) > s.superdate + 20) loop
    insert into sup_dbyc_outway
      (outwayid, warnpointno, old_outway_id, outwaytype, org_id)
    VALUES
      (S_dbyc_outway.Nextval, 'E002', r2.supervisecode, '2', r2.org_id);
   /* update Supinfobasic t set t.is_cjjc = 1 where t.no = r2.supervisecode;*/
  end loop;
exception
  when others then
    dbms_output.put_line('-------------------������');
    rollback;
end;

  --������
  /*  select * from sup_dbyc_outway
    delete from  sup_dbyc_outway

    
    call P_CJJC_OUTWAY();*/
/
