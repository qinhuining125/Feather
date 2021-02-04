package com.feather.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-11 14:39
 * @description 统计返回前台
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntity implements Serializable {

    private String name;
    private Long value;
    private String type;
    private Double percentage;
    private String color;

    public DataEntity(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    public DataEntity(String name, Long value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public DataEntity(String name, Long value, Double percentage, String color) {
        this.name = name;
        this.value = value;
        this.percentage = percentage;
        this.color = color;
    }
}
