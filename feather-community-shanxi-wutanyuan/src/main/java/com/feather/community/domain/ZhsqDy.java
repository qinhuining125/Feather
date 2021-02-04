package com.feather.community.domain;

import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_党员 ZHSQ_DY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqDy extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 党组织id */
    private String dyid;

    /** 姓名 */
    private String xm;

    /** 性别 */
    private String xb;

    /** 年龄 */
    private String nl;

    /** 党员类型 */
    private String dylx;

    /** 民族 */
    private String mz;

    /** 学历 */
    private String xl;

    /** 党龄 */
    private String dl;

    /** 所属党组织 */
    private String ssdzz;

    /** 党组织id */
    private String dzzid;

    /** 住址 */
    private String zz;

    /** 联系电话 */
    private String lxdh;

    /** 姓名 */
    private String jmid;

    /** 是否志愿者 */
    private String sfzyz;

    /** 小区id */
    private String xqid;

    /** 社区id */
    private String sqid;
}
