package com.centit.poweritem.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.centit.core.utils.PageDesc;

/**
 * 分页标签
 * 
 * @author jijinhui
 * 
 */
public class PageTag extends SimpleTagSupport {
    private PageDesc page;
    private String action;
    private String onclickmethod;

    public String getOnclickmethod() {
        return onclickmethod;
    }

    public void setOnclickmethod(String onclickmethod) {
        this.onclickmethod = onclickmethod;
    }

    private long offset;
    private long size;
    private long length;
    private String pageHeader;
    private static int MAX_PAGE_INDEX = 4;

    public PageDesc getPage() {
        return page;
    }

    // url不能通过action传递，而应通过jsp中page标签传递，需要修改

    public void setPage(PageDesc page) {
        this.page = page;
        this.offset = page.getRowStart();
        this.size = page.getTotalRows();
        this.length = page.getPageSize();
        this.pageHeader = "";
    }

    /**
     * 返回分页后的总页数
     * 
     * 
     * @param size
     *            int 总记录数
     * @param length
     *            int 每页的记录数
     * @return int
     */
    public long pageCount() {
        long pagecount = 0;
        if (size % length == 0) {
            pagecount = size / length;
        } else {
            pagecount = size / length + 1;
        }
        return pagecount;
    }

    /**
     * 返回最后一页的记录数
     * 
     * 
     * @param size
     *            int 总记录数
     * @param length
     *            int 每页的记录数
     * @return int
     */
    public long lastPageSize() {
        long lastpagesize = 0;
        if (size % length == 0) {
            lastpagesize = length;
        } else {
            lastpagesize = size % length;
        }
        return lastpagesize;
    }

    /**
     * 返回最后一页的起始记录位置
     * 
     * @param size
     *            int 总记录数
     * @param length
     *            int 每页的记录数
     * @return int
     */
    public long lastPageOffset() {
        return size - lastPageSize();
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String pageNavigation = ""; // 最终返回的分页导航条

        // 记录数超过一页,需要分页

        if (size > length) {
            String pref; // 前缀
            if (action.indexOf("?") > -1) {
                // 如果url中已经包含了其他的参数,就把offset参数接在后面
                pref = "&";
            } else {
                // 如果url中没有别的参数

                pref = "?";
            }

            // 如果导航条包含header
            if (pageHeader != null && pageHeader.length() > 0) {
                pageNavigation = pageHeader;
            }

            // 如果不是第一页,导航条将包含“<<”(第一页)和“<”(前一页)
            if (offset > 0) {
                if (onclickmethod != null && (!"".equals(onclickmethod))) {
                    pageNavigation += "<a href='#' onclick=\"" + onclickmethod
                            + "('0')\"" + ">首页</a>\n"
                            + "<a href='#' onclick=\"" + onclickmethod + "('"
                            + (offset - length) + "')\"" + ">前一页</a>\n";
                } else {
                    pageNavigation += "<a href='" + action + pref
                            + "offset=0'>首页</a>\n" + "<a href='" + action
                            + pref + "offset=" + (offset - length)
                            + "'>前一页</a>\n";
                }
            }

            // 导航条中,排头的那一页的offset值

            long startOffset;
            // 位于导航条中间的那一页的offset值(半径)
            long radius = MAX_PAGE_INDEX / 2 * length;
            // 如果当前的offset值小于半径

            if (offset < radius || this.pageCount() <= MAX_PAGE_INDEX) {
                // 那么第一页排头

                startOffset = 0;
            } else if (offset < size - radius) {
                startOffset = offset - radius;
            } else {
                startOffset = (this.pageCount() - MAX_PAGE_INDEX) * length;
            }
            for (long i = startOffset; i < size
                    && i < startOffset + MAX_PAGE_INDEX * length; i += length) {
                if (i == offset) {
                    // 当前页号,加粗显示
                    pageNavigation += "<b>" + (i / length + 1) + "</b>\n";
                } else {
                    // 其他页号,包含超链接
                    if (onclickmethod != null && (!"".equals(onclickmethod))) {
                        pageNavigation += "<a href='#' onclick=\""
                                + onclickmethod + "('" + (i) + "')\" >" + "["
                                + (i / length + 1) + "]</a>\n";
                    } else {
                        pageNavigation += "<a href='" + action + pref
                                + "offset=" + i + "'>" + "[" + (i / length + 1)
                                + "]</a>\n";
                    }
                }
            }

            // 如果不是最后一页,导航条将包含“>”(下一页)和“>>”(最后一页)
            if (offset < size - length) {
                if (onclickmethod != null && (!"".equals(onclickmethod))) {
                    pageNavigation += "<a href='#' onclick=\"" + onclickmethod
                            + "('" + (offset + length) + "')\"" + ">后一页</a>\n"
                            + "<a href='#' onclick=\"" + onclickmethod + "('"
                            + (lastPageOffset()) + "')\" >末页</a>\n";
                    ;
                } else {
                    pageNavigation += "<a href='" + action + pref + "offset="
                            + (offset + length) + "'>后一页</a>\n" + "<a href='"
                            + action + pref + "offset=" + lastPageOffset()
                            + "'>末页</a>\n";
                }
            }
            // //;
            // //;
            // return pageNavigation;
        }
        // 记录不超过一页,不需要分页

        else {
            // return "";
            pageNavigation = "";
        }
        pageNavigation = "共有" + this.size + "记录, 每页显示" + this.length + "条，共分"
                + this.pageCount() + "页 " + pageNavigation;
        out.println(pageNavigation);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
