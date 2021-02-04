package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 烟感对象 ZHSQ_YG
 *
 * @author fancy
 * @date 2020-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqYg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "烟感ID")
    private String ygid;
    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;
    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;
    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String ppmc;
    /** 设备型号 */
    @Excel(name = "设备型号")
    private String sbxh;
    /** 设备状态 */
    @Excel(name = "设备状态")
    private String sbzt;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
    /** $column.columnComment */
    @Excel(name = "高程")
    private String z;
    /** $column.columnComment */
    @Excel(name = "位置")
    private String wz;
    /** $column.columnComment */
    @Excel(name = "楼栋ID")
    private String ldid;
    /** $column.columnComment */
    @Excel(name = "小区ID")
    private String xqid;
    /** $column.columnComment */
    @Excel(name = "社区ID")
    private String sqid;
}