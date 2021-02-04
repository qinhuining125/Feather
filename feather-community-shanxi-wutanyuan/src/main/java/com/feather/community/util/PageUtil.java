package com.feather.community.util;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 17:04
 * @description 分页辅助类
 */
public class PageUtil {

    public static String getTotalPage(Long total, int pageSize) {
        Long totalPage = (total + pageSize - 1) / pageSize;
        return String.valueOf(totalPage);
    }
}
