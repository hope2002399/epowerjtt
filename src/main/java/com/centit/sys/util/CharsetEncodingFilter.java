package com.centit.sys.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * TODO 解决中文乱码问题
 * 
 * @author zdy
 * @create 2014年3月5日
 * @version
 */
public class CharsetEncodingFilter extends OncePerRequestFilter {
    private String encoding;

    private boolean forceEncoding = false;

    /**
     * Set the encoding to use for requests. This encoding will be passed into a
     * {@link javax.servlet.http.HttpServletRequest#setCharacterEncoding} call.
     * <p>
     * Whether this encoding will override existing request encodings (and
     * whether it will be applied as default response encoding as well) depends
     * on the {@link #setForceEncoding "forceEncoding"} flag.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing request and response encodings.
     * <p>
     * Default is "false", i.e. do not modify the encoding if
     * {@link javax.servlet.http.HttpServletRequest#getCharacterEncoding()}
     * returns a non-null value. Switch this to "true" to enforce the specified
     * encoding in any case, applying it as default response encoding as well.
     * <p>
     * Note that the response encoding will only be set on Servlet 2.4+
     * containers, since Servlet 2.3 did not provide a facility for setting a
     * default response encoding.
     */
    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        request.setCharacterEncoding(encoding);
        if (forceEncoding) {
            response.setCharacterEncoding(encoding);
        }

        ArrayList<String> queryValues = new ArrayList<String>();
        Map<String, String[]> map = request.getParameterMap();
        String query = request.getQueryString();
        if (query != null) {
            String[] expressions = query.split("&");
            for (String expression : expressions) {
                String[] parts = expression.split("=");
                if (parts.length == 2) {
                    String str = URLDecoder.decode(parts[1], encoding);
                    // System.out.println(str);
                    queryValues.add(new String(str.getBytes(encoding),
                            "ISO-8859-1"));
                }
            }
        }

        for (String[] strs : map.values()) {
            for (int i = 0; i < strs.length; i++) {
                for (String qStr : queryValues) {
                    if (qStr.equals(strs[i])) {
                        strs[i] = new String(qStr.getBytes("ISO-8859-1"),
                                encoding);
                        break;
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }

}
