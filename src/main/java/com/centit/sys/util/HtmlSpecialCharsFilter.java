package com.centit.sys.util;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO 过滤 html 特殊字符
 * 
 * @author zdy
 * @create 2014年3月17日
 * @version
 */
public class HtmlSpecialCharsFilter implements Filter {
    @Override
    public void destroy() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURL = req.getRequestURL().toString();
        String requestName = requestURL
                .substring(requestURL.lastIndexOf("/") + 1);

        // 统计模块要保存sql，不能过滤
        if (requestName.indexOf("queryModel") >= 0) {
            chain.doFilter(request, response);
            return;
        }

        Map<String, String[]> map = request.getParameterMap();

        for (String[] strs : map.values()) {
            for (int i = 0; i < strs.length; i++) {

                // 清除掉所有特殊字符
                // String
                // regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）\"\"《》\\\\——+|{}【】‘；：”“’。，、？]";
                String regEx = "['<>\"\\[\\]]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(strs[i]);
                strs[i] = m.replaceAll("").trim();

                // 还是替换成html编码？
                /*
                 * StringBuffer sb = new StringBuffer(); for(int j=0;
                 * j<strs[i].length(); j++) { char c = strs[i].charAt(j); switch
                 * (c) { case '<' : sb.append("&lt;"); break; case '>' :
                 * sb.append("&gt;"); break; case '&' : sb.append("&amp;");
                 * break; case '"' : sb.append("&quot;"); break; case '\'' :
                 * sb.append("&apos;"); break; default: sb.append(c); } }
                 * strs[i] = sb.toString();
                 */
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // System.out.println("HtmlSpecialCharsFilter.init()");
    }

}
