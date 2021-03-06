package com.centit.workflow.sample.optmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.support.utils.HtmlFormUtils;
import com.centit.support.utils.ReflectionOpt;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.service.SysVariableTranslate;

public class BaseVariable<T extends Object> implements SysVariableTranslate {
    protected T object;
    protected static final Log log = LogFactory.getLog(BaseVariable.class);
    private Map<String, String> requestParams;

    public BaseVariable() {
        object = null;
        requestParams = null;
    }

    public void setModuleObject(T obj) {
        this.object = obj;
    }

    @SuppressWarnings("unchecked")
    public void setServletRequest(HttpServletRequest request) {
        Map<Object, Object> paramMap = request.getParameterMap();

        requestParams = new HashMap<String, String>();

        for (Map.Entry<Object, Object> ent : paramMap.entrySet()) {
            // if (!
            // ent.getKey().toString().startsWith(BaseAction.SEARCH_STRING_PREFIX)){
            String sKey = ent.getKey().toString();
            String sValue = HtmlFormUtils.getParameterString(ent.getValue());
            requestParams.put(sKey, sValue);
            // }
        }
    }

    /**
     * 默认返回业务模型对象的属性值 , request 队形的参数
     */
    @Override
    public String getVarValue(String lableName) {
        String s = "";
        if (object != null) {
            try {
                Object obj = ReflectionOpt.forceGetProperty(object, lableName);
                if (obj != null) {
                    s = obj.toString();
                    if (!StringRegularOpt.isNumber(s))
                        s = '\'' + s + '\'';
                    return s;
                }
            } catch (NoSuchFieldException e) {
                log.debug("property not found. " + e.getMessage());
            }
        }
        if (requestParams != null) {
            s = requestParams.get(lableName);
            if (s != null) {
                if (!StringRegularOpt.isNumber(s))
                    s = '\'' + s + '\'';
                return s;
            }
        }
        return null;
    }

    /**
     * 返回用户表达式中的自定义变量对应的用户组
     */
    @Override
    public Set<String> getUsersVariable(String varName) {
        return null;
    }

    /**
     * 返回机构表达式中的自定义变量对应的用户组
     */
    @Override
    public Set<String> getUnitsVariable(String varName) {
        return null;
    }

    @Override
    public String getLabelValue(String arg0) {
        return getVarValue(arg0);
    }

}
