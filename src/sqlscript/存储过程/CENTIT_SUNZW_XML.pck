create or replace package CENTIT_SUNZW_XML is

  -- Author  : CODEFAN
  -- Created : 2011-11-11 10:10:47
  -- Purpose : ��XML�ͼ�¼����֮�����ת��

  -- Public type declarations
  --����һ����������
  TYPE ANNEX_TYPE IS RECORD (
      docId varchar2(100),
      docName varchar2(200),
      pathName varchar2(200),
      fileContent blob);
  --����һ��������������
  TYPE ANNEX_TAB IS TABLE OF ANNEX_TYPE  index by binary_integer;
  --����һ���α��������ͣ��������Ӧ�ÿ��Զ���Ϊ˽�еģ�����Ϊ�������ǹ�ר�е�ѧϰ
  TYPE ANNEX_SOR IS REF CURSOR;

  --����������ת��ΪXML�ļ�����ת��Ϊclob
  function AnnexTabToXml(annexList in ANNEX_TAB) return clob;
  --��clob��ʽ��XMLת��Ϊ�������� ��Oracle��XMLParser���ͣ��Խڵ�Ҫ���ܴ���64K
  --���򽫱�Ora-31167����
  function AnnexXmlToTab64k(annexXml clob) return ANNEX_TAB;
  --��clob��ʽ��XMLת��Ϊ��������
  function AnnexXmlToTab(annexXml clob) return ANNEX_TAB;
  function AnnexXmlToTab2(annexXml clob) return ANNEX_TAB;

  /*
  ��һ���򿪵ĸ������α�ת��Ϊxml��ʽ��clob
  ����������������Ҫ��������α� cur CENTIT_SUNZW_XML.ANNEX_SOR;
  Ȼ�������α꣬���α�ķ����ж���
  1�� ��һ����̬�α� open cur for select * from tab;
  2�� ��һ����̬�α� open cur for 'select * from tab';
  3,  ��һ���������Ķ�̬�α� open cur for 'select * from tab where rown<:1' using 5;
  �����������������
  ���ر��α� close cur;
  */
  function AnnexCurSorToXml(cur in ANNEX_SOR) return clob;
  /*
  �� ��ȡ������sql��� ת��Ϊxml��ʽ��clob��
  sql�����ֶ�˳�����Ϊ document_id document_name,file_name,file_content
  */
  function AnnexSqlToXml(sqlSen in varchar2) return clob;
  /*
  �� һ������������ȡ������sql��� ת��Ϊxml��ʽ��clob��
  sql�����ֶ�˳�����Ϊ document_id document_name,file_name,file_content
  */
  function AnnexSqlToXml(sqlSen in varchar2,keyWord in varchar2,keyWord2 in varchar2) return clob;
end CENTIT_SUNZW_XML;
/
create or replace package body CENTIT_SUNZW_XML is

  -- Private type declarations
function AnnexTabToXml(annexList in ANNEX_TAB) return clob
is
  docRec ANNEX_TYPE;
  fileClob clob;
  tempClob clob;
  resClob clob;
begin
  dbms_lob.createtemporary(tempClob, FALSE, dbms_lob.call);
  dbms_lob.append(tempClob, '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA>');--

  if annexList.count=0 then
    return null;
  end if;

  FOR i IN annexList.First..annexList.LAST LOOP
    docRec := annexList(i);
    dbms_lob.append(tempClob, '<DOCUMENT><DOCUMENT_ID>'||replace( replace( docRec.docId,'<',chr(38)||'lt;'),'>',chr(38)||'gt')
                   ||'</DOCUMENT_ID><DOCUMENT_NAME>'
                   ||replace( replace( docRec.docName,'<',chr(38)||'lt;'),'>',chr(38)||'gt')
                   ||'</DOCUMENT_NAME><FILE_NAME>'
                   ||replace( replace( docRec.pathName,'<',chr(38)||'lt;'),'>',chr(38)||'gt')
                   ||'</FILE_NAME><FILE_CONTENT>CDATA[');-- );-- CDATA �Ӽ�һ��Ҫ����д
    if docRec.fileContent is not null then
      fileClob := Centit_LOB.BlobToBase64(docRec.fileContent);
      if (fileClob is not null) then
         --dbms_lob.append(tempClob, '<![CDATA[');
         dbms_lob.append(tempClob, fileClob);
         --dbms_lob.append(tempClob, ']]>');
      end if;
    end if;
    dbms_lob.append(tempClob, ']</FILE_CONTENT></DOCUMENT>'); --

  END LOOP;
  dbms_lob.append(tempClob, '</DOCUMENTDATA>');
  --dbms_output.put_line('ִ�����');
  resClob := tempClob;
  dbms_lob.freetemporary(tempClob);
  return resClob;
end;

function AnnexXmlToTab64k(annexXml clob) return ANNEX_TAB
is
  theXmlDoc   xmldom.DOMDocument;
  theDocElt   xmldom.DOMElement;
  docNodeList xmldom.DOMNodeList;
  docItem     xmldom.DOMNode;
  --tempElt     xmldom.DOMElement;
  tempNodeList xmldom.DOMNodeList;
  tempNode    xmldom.DOMNode;
  i           number;
  len         number;
  j           number;
  clen        number;
  fileNode    xmldom.DOMNode;
  fileCon     clob;
  fileClob    clob;
  parser      xmlparser.Parser;

  docRec      ANNEX_TYPE;
  nodeName    varchar2(256);
  annexList   ANNEX_TAB;
  --XMLParseError EXCEPTION;
  --PRAGMA EXCEPTION_INIT( XMLParseError, -20100 );
begin
  parser := xmlparser.newParser;
  --dbms_output.put_line('��ʼ���ɹ�');
  xmlparser.parseClob(parser,annexXml);
  --dbms_output.put_line('����XML�ɹ�');
  theXmlDoc := xmlparser.getDocument(parser);
  xmlparser.freeParser(parser);
  if xmldom.IsNull(theXmlDoc) then
    return annexList;
  end if;
  theDocElt := xmldom.getDocumentElement(theXmlDoc);
  docNodeList := xmldom.GETELEMENTSBYTAGNAME(theDocElt,'DOCUMENT');-- '*' ��ʾ����Ԫ�أ�������Ԫ��
  len := xmldom.getLength(docNodeList);

   -- ��������Ԫ��
  for i in 0..len-1 loop
    docItem := xmldom.item(docNodeList, i);
    --tempElt := xmldom.makeElement(docItem);
    tempNodeList := xmldom.getChildNodes(docItem);
    clen := xmldom.getLength(tempNodeList);
    for j in 0..clen-1 loop
      tempNode :=  xmldom.item(tempNodeList, j);
      nodeName := xmldom.getNodeName(tempNode);
      --����ṹ�е�����
      docRec.fileContent := null;
      --dbms_output.put_line(nodeName);
      --���¼���ֶζ�Ӧ��ϵ
       CASE nodeName
       WHEN 'DOCUMENT_ID' THEN
         -- ����Ҫ��һ��xmldom.getFirstChild��Oracle�е�DOM��Value��ΪNode��һ����Node
         docRec.docId := xmldom.getNodeValue(xmldom.getFirstChild(tempNode));
       WHEN 'DOCUMENT_NAME' THEN
         docRec.docName := xmldom.getNodeValue(xmldom.getFirstChild(tempNode));
       WHEN 'FILE_NAME' THEN
         docRec.pathName := xmldom.getNodeValue(xmldom.getFirstChild(tempNode));
         --dbms_output.put_line(docRec.Doc_Name);
       WHEN 'FILE_CONTENT' THEN
         begin
           fileNode := xmldom.getFirstChild(tempNode);
           if not xmldom.IsNull(fileNode) then
             dbms_lob.createtemporary(fileCon, FALSE, dbms_lob.call);
             xmldom.writeToClob(xmldom.getFirstChild(tempNode),fileCon);
             fileClob := fileCon;--xmldom.getNodeValue(xmldom.getFirstChild(tempNode)) ;-- fileCon;
             dbms_lob.freetemporary(fileCon);
             docRec.fileContent := Centit_LOB.Base64ToBlob(fileClob);
             --dbms_output.put_line('Clob len: '||to_char(dbms_lob.getlength(fileClob))||' Blob len: '||to_char(dbms_lob.getlength(docRec.Doc_File )));
           end if;
         end;
      END CASE;
     end loop;
     annexList(i) := docRec;
  end loop;
  null;
  xmlparser.freeParser(parser);
--dbms_output.put_line('����XML���');
--EXCEPTION
  --WHEN XMLParseError THEN
    -- xmlparser.freeParser(parser);
     --dbms_output.put_line('����XML����');
  --��¼XML��������
  return annexList;
end;


function AnnexXmlToTab(annexXml clob) return ANNEX_TAB
is
  annNo          binary_integer := 0;
  nDocBPos       integer;
  nDocEPos       integer;
  nTempPos       integer;
  --souLen        integer;
  nPos           integer:=1;
  docRec         ANNEX_TYPE;
  annexList      ANNEX_TAB;
  annexLob       Clob;
  procedure initDoc
    is
    begin
      docRec.docId := null;
      docRec.docName := null;
      docRec.pathName := null;
      docRec.fileContent := null;
    end;

  function getText(curPos integer) return varchar2
    is
      ep integer;
      sv varchar(200);
    begin
      ep := dbms_lob.instr(annexXml,'<',curPos);
      if ep>0 then
         sv := dbms_lob.substr(annexXml,case when ep-curPos<200 then ep-curPos else 200 end ,curPos);
         return replace( replace( sv,chr(38)||'lt;','<'),chr(38)||'gt','>');
      else
         return null;
      end if;
    end;

  function getFileContent(curPos integer,docEnd integer) return Clob
    is
      fileClob clob;
      tempClob clob;
      tempV varchar2(8400);
      bp integer;
      ep integer;
      sizeB integer:=8000;
    begin
      fileClob := null;
      bp := dbms_lob.instr(annexXml,'CDATA[',curPos);
      ep := dbms_lob.instr(annexXml,']',curPos);
      if bp>0 and ep>0 and ep>bp and ep<docEnd then
        bp:=bp+6;
        dbms_lob.createtemporary(tempClob, FALSE, dbms_lob.call);
        loop
          if sizeB > ep-bp then
            sizeB:=ep-bp;
          end if;
          dbms_lob.read(annexXML,sizeB,bp,tempV);
          dbms_lob.append(tempClob,tempV);
          bp:= bp+sizeB;
          exit when bp>=ep;
        end loop;
        fileClob := tempClob;
        dbms_lob.freetemporary(tempClob);
      end if;
      return fileClob;
    end;
begin
  --souLen := dbms_lob.getlength(annexXml);
  if annexXml is null then
    return annexList;
  end if;

  loop
    nDocBPos := dbms_lob.instr(annexXml, '<DOCUMENT>',nPos);
    EXIT WHEN nDocBPos <= 0 ;
    nDocEPos := dbms_lob.instr(annexXml, '</DOCUMENT>',nDocBPos);
    EXIT WHEN nDocEPos <= 0 ;
    initDoc;
    nTempPos := dbms_lob.instr(annexXml, '<DOCUMENT_ID>',nDocBPos);
    if nTempPos>0 and nTempPos<nDocEPos then
      docRec.docId := getText(nTempPos+13);
    end if;
    nTempPos := dbms_lob.instr(annexXml, '<DOCUMENT_NAME>',nDocBPos);
    if nTempPos>0 and nTempPos<nDocEPos then
      docRec.docName := getText(nTempPos+15);
    end if;
    nTempPos := dbms_lob.instr(annexXml, '<FILE_NAME>',nDocBPos);
    if nTempPos>0 and nTempPos<nDocEPos then
      docRec.pathName := getText(nTempPos+11);
    end if;

    nTempPos := dbms_lob.instr(annexXml, '<FILE_CONTENT>',nDocBPos);
    if nTempPos>0 and nTempPos<nDocEPos then
      annexLob := getFileContent(nTempPos+14,nDocEPos);
      docRec.fileContent :=  Centit_LOB.Base64ToBlob(annexLob);
    end if;
    nPos := nDocEPos+10;
    if docRec.docId is not null and docRec.docName is not null then
      annexList(annNo) := docRec;
      annNo :=annNo + 1;
    end if;
  end loop;
  return annexList;
end;


function AnnexXmlToTab2(annexXml clob) return ANNEX_TAB
is
  --souLen         integer;
  annNo          binary_integer := 0;
  sizeB          binary_integer := 4096;
  nLobPos        integer default 1;
  nSLobPos       integer;
  sLastBuf       varchar2(8192);
  nPos           integer;
  sSearchPiece   varchar2(16500);

  docRec      ANNEX_TYPE;
  annexList   ANNEX_TAB;
  docPos      integer;
  docIDPos    integer;
  docNamePos  integer;
  fileNamePos integer;
  fileContPos integer;
  annexLob clob;
  procedure initPos
    is
    begin
      docRec.docId := null;
      docRec.docName := null;
      docRec.pathName := null;
      docRec.fileContent := null;
      docIDPos    :=-1;
      docNamePos  :=-1;
      fileNamePos :=-1;
      fileContPos :=-1;
    end;

  function findTag( sTagName varchar2) return number
    is
       tp integer;
    begin
       --soul := length(sSearchPiece);
       tp := instr(sSearchPiece,sTagName,nPos);
       return tp;
    end;

  function readNextBuf  return boolean
    is
    begin
      if nSLobPos < nLobPos then
        return true;
      elsif  sizeB < 4096 then
        return false;
      else
        dbms_lob.read(annexXml, sizeB, nLobPos, sLastBuf);
        nLobPos := nLobPos + sizeB;
        return true;
      end if;
    end;

  function findAnywayTag( sTagName varchar2) return number
    is
       tp integer;
       soul integer;
    begin
       tp := instr(sSearchPiece,sTagName,nPos);
       while tp <= 0 loop
         Exit when not readNextBuf;
         nSLobPos := nLobPos;
         nPos := 0;
         sSearchPiece := substr(sSearchPiece,-50) + sLastBuf;
         tp := instr(sSearchPiece,sTagName,nPos);
         soul := length(sSearchPiece);
         if tp>0 and tp>soul-50 then
           tp :=0;
         end if;
       end loop;
       return tp;
    end;


  function getText(curPos integer) return varchar2
    is
      ep integer;
      sv varchar(200);
    begin
      ep := instr(sSearchPiece,'<',curPos);
      if ep>0 then
         sv := substr(sSearchPiece,curPos,ep-curPos);
      else
         sv :=  substr(sSearchPiece,curPos);
         if readNextBuf then
           ep := instr(sLastBuf,'<',1);
           if ep>1 then
             sv := sv || substr(sLastBuf,1,ep-1);
           end if;
         end if;
      end if;
      return replace( replace( sv,chr(38)||'lt;','<'),chr(38)||'gt','>');
    end;

  function getFileContent(curPos integer) return Clob
    is
      fileClob clob;
      tempClob clob;
      tempV varchar(8400);
      bp integer;
      ep2 integer;
      nLobBPos integer;
      ep integer;
    begin
      --dbms_lob.append(tempClob, '<?xml version="1.0" encoding="GBK"?><DOCUMENTDATA>');--
      tempV := sSearchPiece;
      nLobBPos := nSLobPos;
      bp := instr(tempV,'CDATA[',curPos);
      if bp<=0 then
        bp := instr(tempV,'<',curPos);
        if bp>0 then
          return null;
        elsif not readNextBuf then
           return null;
        end if;
        nLobBPos := nLobPos;
        tempV := substr(tempV,-8) + sLastBuf;
        bp := instr(tempV,'CDATA[',1);
        ep2 := instr(tempV,'<',1);
        if ep2>0 and ep2<bp then
          return null;
        end if;
      end if;
      if bp<=0 then
        return null;
      end if;
      bp := bp+6;--CDATA[
      nLobPos := nLobBPos;
      dbms_lob.createtemporary(tempClob, FALSE, dbms_lob.call);

      ep := instr(tempV,']',curPos);
      loop
        if ep>0 then
          dbms_lob.append(tempClob,substr(tempV,bp,ep-bp));
          exit ;
        else
          dbms_lob.append(tempClob,substr(tempV,bp));
        end if;
        exit when sizeB < 4096;--�Ѿ��������һҳ
        dbms_lob.read(annexXml, sizeB, nLobPos, sLastBuf);
        tempV := sLastBuf;
        bp :=1;
        nLobPos := nLobPos + sizeB;
        ep := instr(tempV,']',1);
      end loop;
      --dbms_lob.append(tempClob,substr(sSearchPiece,
      fileClob := tempClob;
      dbms_lob.freetemporary(tempClob);
      return fileClob;
    end;
begin
  --DOCUMENT DOCUMENT_ID DOCUMENT_NAME FILE_NAME FILE_CONTENT
  --dbms_output.put_line(getText('hello'));
  --souLen := dbms_lob.getlength(annexXml);
  dbms_lob.read(annexXml, sizeB, nLobPos, sSearchPiece);
  nLobPos := nLobPos + sizeB;
  nSLobPos := nLobPos;
  nPos := 1;
  initPos;
  loop
    docPos := findAnywayTag('<DOCUMENT>');
    EXIT WHEN docPos <= 0 ;
    nPos := docPos + 10;--length('<DOCUMENT>');
    loop
      if docIDPos<=0 then
        docIDPos    := findTag('<DOCUMENT_ID>');
        if docIDPos>0 then
          docRec.docId := getText(docIDPos+13);
        end if;
      end if;
      if docNamePos<=0 then
        docNamePos    := findTag('<DOCUMENT_NAME>');
        if docNamePos>0 then
          docRec.docName := getText(docNamePos+15);
        end if;
      end if;
      if fileNamePos<=0 then
        fileNamePos    := findTag('<FILE_NAME>');
        if fileNamePos>0 then
          docRec.pathName :=  getText(fileNamePos+11);
        end if;
      end if;
      if fileContPos<=0 then
        fileContPos    := findTag('<FILE_CONTENT>');
        if fileContPos>0 then
          annexLob := getFileContent(fileContPos+14);
          docRec.fileContent :=  Centit_LOB.Base64ToBlob(annexLob);
        end if;
      end if;

      docPos :=  findTag('</DOCUMENT>');
      if docPos<=0 then
        if nSLobPos < nLobPos then
          sSearchPiece := sLastBuf;
          nSLobPos := nLobPos;
          if readNextBuf then
             sSearchPiece := sSearchPiece  ||sLastBuf;
          end if;
        else
          Exit when not readNextBuf;
          sSearchPiece := substr(sSearchPiece,-50) || sLastBuf;
       end if;
       nSLobPos := nLobPos;
       nPos := 1;
       docPos :=  findTag('</DOCUMENT>');
      end if;

      EXIT WHEN docPos>0;
      --dbms_lob.read(annexXml, sizeB, nLobPos, sSouPiece);
      exit when not readNextBuf;

      nSLobPos := nLobPos;
      nPos := 1;
      sSearchPiece := substr(sSearchPiece,-50) || sLastBuf;

    end loop;

    if docIDPos>0 and docNamePos>0 then
      annexList(annNo) := docRec;
      annNo :=annNo + 1;
      initPos;
    end if;

    if nSLobPos < nLobPos then
      nPos := 1;
      nSLobPos := nLobPos;
      sSearchPiece := sLastBuf;
    elsif docPos > 0 then
      nPos := docPos + 8;
    else
      exit when not readNextBuf;
      nSLobPos := nLobPos;
      nPos := 1;
    end if;
  end loop;
  return annexList;
end;


function AnnexCursorToXml(cur in ANNEX_SOR) return clob
is
  annexList ANNEX_TAB;
  docRec ANNEX_TYPE;
  i integer default 0;
begin
  --open cur;
  loop
     fetch cur into docRec.docId,docRec.docName,docRec.pathName,docRec.fileContent;
     exit when cur%notfound;
     --dbms_output.put_line( docRec.fileName);
     annexList(i) := docRec;
     i := i+1;
  end loop;
  return AnnexTabToXml(annexList);
end;

function AnnexSqlToXml(sqlSen in varchar2) return clob
is
  cur ANNEX_SOR;
  resLob  clob;
begin
  open cur for sqlSen;
  resLob := AnnexCursorToXml( cur );
  if cur%isopen then
    close cur;
  end if;
  return resLob;
end;

function AnnexSqlToXml(sqlSen in varchar2,keyWord in varchar2,keyWord2 in varchar2) return clob
is
  cur ANNEX_SOR;
  resLob  clob;
begin
  open cur for sqlSen using keyWord,keyWord2;
  resLob := AnnexCursorToXml( cur );
  if cur%isopen then
    close cur;
  end if;
  return resLob;
end;

begin
  -- Initialization
  null;
end CENTIT_SUNZW_XML;
/
