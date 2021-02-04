package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 烟感日志对象 ZHSQ_YGRZ
 * 
 * @author qhn
 * @date 2021-01-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqYgrz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 烟感日志ID */
    @Excel(name = "烟感日志ID")
    private String sbrzid;
    /** SN */
    @Excel(name = "SN")
    private String sn;
    /** IMSI */
    @Excel(name = "IMSI")
    private String imsi;
    /** 信号强度 */
    @Excel(name = "信号强度")
    private String rssi;
    /** 电池 */
    @Excel(name = "电池")
    private String baterry;
    /** 7解绑 2烟感报警 */
    @Excel(name = "7解绑 2烟感报警")
    private Long infotype;
    /** 1烟感报警 2烟感防拆报警 3低电量报警 */
    @Excel(name = "1烟感报警 2烟感防拆报警 3低电量报警")
    private Long content;
    /** 烟感ID */
    @Excel(name = "烟感ID")
    private String ygid;
}
