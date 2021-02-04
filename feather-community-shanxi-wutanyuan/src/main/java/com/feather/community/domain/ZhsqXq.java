package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小区对象 ZHSQ_XQ
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqXq extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小区id */
    private String xqid;
    /** 小区名称 */
    @Excel(name = "小区名称")
    private String xqmc;
    /** 简介 */
    @Excel(name = "简介")
    private String jj;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 社区id */
    @Excel(name = "社区id")
    private String sqid;
    /** 所属街道 */
    @Excel(name = "所属街道")
    private String ssjd;
}
