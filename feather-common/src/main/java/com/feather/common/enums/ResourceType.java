package com.feather.common.enums;

/**
 * 资源类型
 * 
 * @author feather
 */
public enum ResourceType {

    API("接口"),

    FILE("文件"),

    PROXY("代理");

    private String label;

    private ResourceType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
