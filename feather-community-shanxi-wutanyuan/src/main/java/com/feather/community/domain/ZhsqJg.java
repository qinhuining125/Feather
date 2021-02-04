package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 井盖对象 ZHSQ_JG
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqJg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 井盖ID */
    @Excel(name = "井盖ID")
    private String jgid;
    /** 小区ID */
    @Excel(name = "小区ID")
    private String xqid;
    /** 楼栋ID */
    @Excel(name = "楼栋ID")
    private String ldid;
    /** 位置 */
    @Excel(name = "位置")
    private String wz;
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
    /** 社区ID */
    @Excel(name = "社区ID")
    private String sqid;
    /** 设备状态 */
    @Excel(name = "设备状态")
    private String sbzt;
    /** 设备型号 */
    @Excel(name = "设备型号")
    private String sbxh;
    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String ppmc;
    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;
    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
}
