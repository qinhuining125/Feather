package com.feather.common.core.page;

import com.feather.common.constant.FeatherConstants;
import com.feather.common.utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @author feather
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(FeatherConstants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(FeatherConstants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(FeatherConstants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(FeatherConstants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }
}
