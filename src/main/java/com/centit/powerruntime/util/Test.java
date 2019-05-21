package com.centit.powerruntime.util;

public class Test {
    public static void main(String[] args) {
        String emscontent = "<?xml version='1.0' encoding='UTF-8'?><RequestMessage><PostInfo><EMS_ORD_NO>GEMEW0100</EMS_ORD_NO><GOV_TB_NAME>����ʡ��ͨ�������</GOV_TB_NAME><POST_TYPE>1</POST_TYPE><NET_TYPE>2</NET_TYPE><BUSS_TYPE>1</BUSS_TYPE><SEND_NAME>����</SEND_NAME><SEND_PROV>����ʡ</SEND_PROV><SEND_CITY>�Ͼ���</SEND_CITY><SEND_COUNTRY>�ػ���</SEND_COUNTRY><SEND_STRECT>����·109��302��</SEND_STRECT><SEND_PHONE>12312312312</SEND_PHONE><SEND_CALL></SEND_CALL><RCV_NAME>����</RCV_NAME><RCV_PROV>����ʡ</RCV_PROV><RCV_CITY>�Ͼ���</RCV_CITY><RCV_COUNTRY>������</RCV_COUNTRY><RCV_STRECT>�����³�102��12��2019��</RCV_STRECT><RCV_PHONE>13851987996</RCV_PHONE><RCV_CALL></RCV_CALL><RCV_POSTCODE>210000</RCV_POSTCODE><ITEM>�ʵ���ʽ�ʹ������ط�</ITEM><CHK_CODE>3B02A1</CHK_CODE><ISSEND>2</ISSEND><ORGNAME>����ʡ��ͨ������</ORGNAME><SENDTIME>2017-07-22 00:00:00</SENDTIME></PostInfo><ApplyInfos><ApplyInfo><INTERNAL_NO>XK00000000012011</INTERNAL_NO><ZWFWZX_CODE>3200JT</ZWFWZX_CODE></ApplyInfo></ApplyInfos></RequestMessage>";
        System.out.println("测试EMS发送接口; 返回值"
                + EmsWebserviceUtil.cityToGovMail(emscontent));
        String instr2 = "<?xml version='1.0' encoding='UTF-8'?><RequestMessage><LogisInfo><EMS_ORD_NO>SWT000001</EMS_ORD_NO><ZWFWZX_CODE>3200JT</ZWFWZX_CODE></LogisInfo>"
                + "</RequestMessage>";
        System.out.println("测试EMS纪委收接口; 返回值"
                + EmsWebserviceUtil.cityGetGovLogis(instr2));
    }
}
