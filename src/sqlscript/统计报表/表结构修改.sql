/* OWNERCODE字段长度增加至64 */
alter table Q_QUERYMODEL modify OWNERCODE varchar2(64);

/* 添加 DEFAULTVALUE 字段*/
alter table Q_QUERYCOLUMN add DEFAULTVALUE varchar2(32) default null;