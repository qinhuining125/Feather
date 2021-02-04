package com.feather.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 20:14
 * @description 搜索实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchEntity {
    private int type;
    private String name;


    /**
     * type=3 即为居民的参数
     */
    private String sfdj;
    private String sfkc;
    private String sfxmsf;
    private String sftyjr;
    private String sfdb;
    private String sfcj;
    private String sfcz;

    /**
     * type=2 即为房屋的参数
     */
    private String ldid;
    private String mph;
    private String fwrzqk;

    /**
     * type=4 即为车辆的参数
     */
    private String cx;

}
