alter table F_UNITINFO modify unittype VARCHAR2(20);

update F_UNITINFO t set t.unittype = trim(t.unittype);