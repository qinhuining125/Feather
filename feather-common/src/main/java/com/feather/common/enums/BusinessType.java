package com.feather.common.enums;

/**
 * 业务操作类型
 *
 * @author feather
 */
public enum BusinessType {

    OTHER("其它"),

    INSERT("新增"),

    UPDATE("修改"),

    DELETE("删除"),

    GRANT("授权"),

    EXPORT("导出"),

    IMPORT("导入"),

    FORCE("强退"),

    GENCODE("生成代码"),

    CLEAN("清空"),

    API("接口"),

    UPLOAD("上传"),

    DOWNLOAD("下载");

    private String label;

    private BusinessType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
