package com.centit.sys.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ValidateCodeFilter
 */
public class ValidateCodeFilter implements Filter {

    /**
     * Default constructor.
     */
    public ValidateCodeFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String code = request.getParameter("captcha"); // 取得客户端提交的验证码
        HttpSession session = request.getSession();
        String sessionValue = (String) session.getAttribute("rand"); // 存放的验证码
        String pwd = request.getParameter("j_password");
        if ("000000".equals(pwd)) {
            session.setAttribute("isstartpwd", "1");

        } else {
            session.setAttribute("isstartpwd", "0");
        }
        if("1".equals(request.getParameter("isCaptcha"))){
            if (!"".equals(code) && null != code && null != sessionValue) {
                if (sessionValue.equalsIgnoreCase(code)) {
                    filterChain.doFilter(request, response);

                } else {
                    String name = request.getParameter("j_username");
                    session.setAttribute("name", name);
                    session.setAttribute("pwd", pwd);
                    response.sendRedirect(request.getContextPath()
                            + "/sys/mainFrame!captchaError.do");
                }
            } else {
                String name = request.getParameter("j_username");
                session.setAttribute("name", name);
                session.setAttribute("pwd", pwd);
                response.sendRedirect(request.getContextPath()
                        + "/sys/mainFrame!captchaError.do");
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        
    }

}
