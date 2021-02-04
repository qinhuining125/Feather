package com.feather.community.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 手环对象 zhsq_sh
 *
 * @author fancy
 * @date 2020-12-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ZhsqSh",description = "手环")
public class ZhsqSh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 手环ID */
    @Excel(name = "手环ID")
    private String shid;
    /** 设备类型 */
    @Excel(name = "设备类型")
    @ApiModelProperty("设备类型")
    private String sblx;
    /** 设备名称 */
    @Excel(name = "设备名称")
    @ApiModelProperty("设备名称")
    private String sbmc;
    /** 品牌名称 */
    @Excel(name = "品牌名称")
    @ApiModelProperty("品牌名称")
    private String ppmc;
    /** 设备型号 */
    @Excel(name = "设备型号")
    @ApiModelProperty("设备型号")
    private String sbxh;
    /** 设备状态 */
    @Excel(name = "设备状态")
    @ApiModelProperty("设备状态")
    private String sbzt;
    /** 设备唯一编号 */
    @Excel(name = "设备唯一编号")
    @ApiModelProperty("设备唯一编号")
    private String imei;
    /** 居民编号 */
    @Excel(name = "居民编号")
    @ApiModelProperty("居民编号")
    private String jmid;
    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;
}