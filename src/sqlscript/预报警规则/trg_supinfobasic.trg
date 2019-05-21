create or replace trigger trg_supinfobasic -- ��ҵ���ż��Ԥ������ʱ,�Զ�ժ��
  after insert on supinfobasic
  referencing new as new_value
  for each row
declare
  v_internal_no varchar2(100);
begin
  if :new_value.supervisetype = '1' then
    select supapply.internal_no
      into v_internal_no
      from supapply
     where supapply.no = :new_value.no;

    update supapplyoutway
       set outtime   = sysdate,
           outperson = :new_value.operatorid,
           outreason = '���𶽰��Զ�ժ��'
     where internal_no = v_internal_no;

  elsif :new_value.supervisetype = '2' then
    select suppunish.internal_no
      into v_internal_no
      from suppunish
     where suppunish.no = :new_value.no;

    update suppunishoutway
       set outtime   = sysdate,
           outperson = :new_value.operatorid,
           outreason = '���𶽰��Զ�ժ��'
     where internal_no = v_internal_no;
  end if;
end;
/
