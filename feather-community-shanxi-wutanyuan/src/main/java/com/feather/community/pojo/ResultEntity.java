package com.feather.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-11 16:13
 * @description 结果返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity implements Serializable {
    private Long total;
    private Map<String, List<DataEntity>> map;
    private List<DataEntity> datas;
    private List<String> keys;
    private List<Long> values;
}
