package com.feather.community.domain;

import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_摄像头 ZHSQ_SXT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSxt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 摄像头id */
    private String sxtid;

    /** 设备类型 */
    private String sblx;

    /** 设备名称 */
    private String sbmc;

    /** 品牌名称 */
    private String ppmc;

    /** 设备型号 */
    private String sbxh;

    /** 设备状态 */
    private String sbzt;

    private String x;

    private String y;

    private String z;

    /** 位置 */
    private String wz;

    /** 小区id */
    private String xqid;

    /** 社区id */
    private String sqid;

    /** 位置类型 */
    private String wzlx;
}
