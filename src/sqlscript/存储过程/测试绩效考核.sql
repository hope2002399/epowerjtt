drop  table M_TempCheckupDetail;

create global temporary table M_TempCheckupDetail  (
   PIECE_NO             number(12)                      not null,
   ORG_ID               VARCHAR2(10),
   ITEM_CODE            VARCHAR2(32)                    not null,
   ITEM_NAME            VARCHAR2(100),
   ITEM_VALUE           NUMBER(12,4),
   ITEM_UNIT            VARCHAR2(10),
   ITEM_RULE_DESC       VARCHAR2(500),
   ITEM_RULE            VARCHAR2(200)
) on commit preserve rows;



