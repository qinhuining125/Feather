package com.feather.community.domain;

import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_楼栋 ZHSQ_LD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqLd extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 楼栋id */
    private String ldid;

    /** 楼栋名称 */
    private String ldmc;

    /** 建筑物面积 */
    private String jzwmj;

    /** 层数 */
    private String cs;

    /** 小区id */
    private String xqid;

    /** 社区id */
    private String sqid;

    /** 所属街道 */
    private String ssjd;

    private String x;

    private String y;

    private String z;

    private List<ZhsqFw> zhsqFwList;

    private Map<String, List<ZhsqFw>> zhsqFwListMap;
}
