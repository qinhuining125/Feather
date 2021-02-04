package com.feather.community.domain;

import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_党组织 ZHSQ_DZZ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqDzz extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 党组织id */
    private String dzzid;

    /** 名称 */
    private String mc;

    private String x;

    private String y;

    private String z;

    /** 位置 */
    private String wz;

    /** 小区id */
    private String xqid;

    /** 社区id */
    private String sqid;
}
