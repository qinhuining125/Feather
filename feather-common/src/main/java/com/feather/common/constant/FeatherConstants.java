package com.feather.common.constant;

/**
 * 通用常量信息
 *
 * @author feather
 */
public class FeatherConstants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /** 状态：真、成功、正常、启用、允许、主要的、默认的 */
    public static final Byte TRUE_SUCCESS_ENABLED_PRIMARY = 1;
    /** 状态：假、失败、停用、封禁、次要的 */
    public static final Byte FALSE_FAIL_DISABLED_SUBORDINATE = 0;
    /** 状态：被删除 */
    // public static final String DELETED = "2";

    /** 登录成功 */
    public static final String LOGIN_SUCCESS = "Success";
    /** 登录失败 */
    public static final String LOGIN_FAIL = "Error";
    /** 注销 */
    public static final String LOGOUT = "Logout";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 日期格式
     */
    public static String[] DateTime_Patterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM" };

    public static boolean isTrue(byte b) {
        return b == TRUE_SUCCESS_ENABLED_PRIMARY;
    }

    public static boolean isTrue(Byte b) {
        return b != null && b.byteValue() == TRUE_SUCCESS_ENABLED_PRIMARY;
    }
}
