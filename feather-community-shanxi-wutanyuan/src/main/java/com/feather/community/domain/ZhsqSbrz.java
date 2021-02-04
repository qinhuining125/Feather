package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 水表日志对象 ZHSQ_SBRZ
 * 
 * @author qhn
 * @date 2021-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSbrz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 手环日志ID */
    private String sbrzid;
    /** 水表ID */
    @Excel(name = "水表ID")
    private String deviceCode;
    /** 结算日 */
    @Excel(name = "结算日")
    private Long deviceSettleDay;
    /** 结算日流量 */
    @Excel(name = "结算日流量")
    private Long deviceSettleDayData;
    /** 设备累计流量 */
    @Excel(name = "设备累计流量")
    private Long deviceTotalData;
    /** 设备状态 */
    @Excel(name = "设备状态")
    private String deviceStatus;
    /** 电池电压 */
    @Excel(name = "电池电压")
    private String deviceVoltage;
    /** 信号强度 */
    @Excel(name = "信号强度")
    private Long deviceRssi;
    /** 设备时钟 */
    @Excel(name = "设备时钟")
    private String deviceClock;
}
