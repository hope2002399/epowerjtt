package com.centit.sys.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;

import org.apache.commons.lang.ClassUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.sys.po.AddressBook;
import com.centit.sys.service.AddressBookManager;

public class AddressBookAction extends BaseEntityExtremeAction<AddressBook> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private AddressBookManager addressBookMag;

    public void setAddressBookManager(AddressBookManager basemgr) {
        addressBookMag = basemgr;
        this.setBaseEntityManager(addressBookMag);
    }

    public String editindialog() {

        try {
            AddressBook dbObject = addressBookMag.getObjectById(object
                    .getAddrbookid());
            if (dbObject != null) {
                dbObject.copyNotNullProperty(object);
                object = dbObject;
            }
            return "editindialog";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String saveindialog() {
        try {
            AddressBook dbObject = addressBookMag.getObjectById(object
                    .getAddrbookid());
            if (dbObject != null) {
                dbObject.copyNotNullProperty(object);
                object = dbObject;
            }
            addressBookMag.saveObject(object);

            return "returnuser";
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    protected InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String load() throws IOException, ClassNotFoundException {
        super.view();

        inputStream = new ByteArrayInputStream("".toString().getBytes("utf-8"));
        StringWriter sw = new StringWriter();

        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(gen, object);
        inputStream = new ByteArrayInputStream(sw.toString().getBytes("utf-8"));

        return "load";
    }

    public String loadLabelFields() throws ClassNotFoundException, IOException {
        Field[] fds = object.getClass().getDeclaredFields();
        int i;
        int size = fds.length;
        StringBuffer stringBuffer = new StringBuffer("define( { "
                + "\n addressBookFields : {");
        for (i = 0; size > i; i++) {
            String field = fds[i].getName();
            String labelKey = camelCase(ClassUtils.getShortClassName(object
                    .getClass())) + "." + field;
            String textValue = getText(labelKey);
            // System.out.println(labelKey + "--->" + textValue);
            stringBuffer.append("\"" + field + "\":\"" + textValue + "\"");
            if (i != size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("}\n});");
        log.debug("stringBuffer.toString() = " + stringBuffer.toString());
        // StringWriter sw = new StringWriter();

        // JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.writeValue(gen, object);
        inputStream = new ByteArrayInputStream(stringBuffer.toString()
                .getBytes("utf-8"));
        return "loadLabelFields";
    }

    public static String camelCase(String arg) {
        StringBuilder buf = new StringBuilder();
        if (arg != null && arg.length() > 0) {
            buf.append(Character.toLowerCase(arg.charAt(0)));
            buf.append(arg.substring(1));
        }
        return buf.toString();
    }

    public String saveAddressBook() {
        try {

            addressBookMag.saveObject(object);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        return SUCCESS;
    }

}
