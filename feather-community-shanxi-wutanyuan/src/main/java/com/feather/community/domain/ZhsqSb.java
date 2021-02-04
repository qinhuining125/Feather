package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 水表对象 zhsq_sb
 *
 * @author qhn
 * @date 2021-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水表ID */
    @Excel(name = "水表ID")
    private String deviceCode;
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
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 位置 */
    @Excel(name = "位置")
    private String wz;
    /** $column.columnComment */
    @Excel(name = "位置")
    private String ldid;
    /** 小区ID */
    @Excel(name = "小区ID")
    private String xqid;
    /** 社区ID */
    @Excel(name = "社区ID")
    private String sqid;
}