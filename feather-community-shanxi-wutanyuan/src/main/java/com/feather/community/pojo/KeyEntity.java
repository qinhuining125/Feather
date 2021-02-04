package com.feather.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-11 17:21
 * @description 统计的key
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyEntity implements Serializable {
    private String type;
    private String list;
    private String key;
    private String name;
    private String color;
    private String val1;
    private String val2;
    private String val3;
    private String remark;
}
