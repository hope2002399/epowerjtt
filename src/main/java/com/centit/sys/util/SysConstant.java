package com.centit.sys.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class SysConstant {
    public static <T> Object getValueFromMap(
            final HashMap<String, String> columnsvalueMap, Class<T> cls)
            throws IOException, IllegalArgumentException,
            InvocationTargetException {
        Map<String, Method> methodMap = new HashMap<String, Method>();
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            String name = m.getName().toUpperCase();
            if (name.startsWith("SET")) {
                methodMap.put(name.substring(3), m);
            }
        }
        try {
            Object o = cls.newInstance();
            for (Map.Entry<String, String> entry : columnsvalueMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (methodMap.containsKey(key)) {
                    Method _m = methodMap.get(key);
                    Class<?> c = _m.getParameterTypes()[0];
                    if (value.endsWith(".0") || value.endsWith(".00")) {
                        value = value.substring(0, value.indexOf("."));
                    }
                    if (c == Long.class) {
                        try {
                            _m.invoke(o, Long.parseLong(value));
                        } catch (Exception e) {
                        }
                    } else if (c == Double.class) {
                        try {
                            _m.invoke(o, Double.parseDouble(value));
                        } catch (Exception e) {
                        }
                    } else if (c == Float.class) {
                        try {
                            _m.invoke(o, Float.parseFloat(value));
                        } catch (Exception e) {
                        }
                    } else if (c == Integer.class) {
                        try {
                            _m.invoke(o, Integer.parseInt(value));
                        } catch (Exception e) {
                        }
                    } else if (c == Date.class) {
                        try {
                            _m.invoke(o, new SimpleDateFormat("yyyy-MM-dd")
                                    .parse(value));
                        } catch (Exception e) {
                        }
                    } else {
                        _m.invoke(o, value);
                    }
                }
            }
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getValueByKey(String content, String key, String ragix) {
        String value = "";
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(content)) {
            for (int i = 0; i < content.split(ragix).length; i++) {
                String tmp = content.split(ragix)[i];
                String tmpKey = tmp.substring(0, tmp.indexOf(":"));
                if (key.equals(tmpKey)) {
                    if (tmpKey.length() + 1 < tmp.length()) {
                        value = tmp.substring(tmp.indexOf(":") + 1);
                    }
                }
            }
        }
        return value.trim();
    }
}
