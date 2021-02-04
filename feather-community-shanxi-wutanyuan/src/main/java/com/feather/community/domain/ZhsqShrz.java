package com.feather.community.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 手环日志对象 zhsq_shrz
 *
 * @author fancy
 * @date 2020-12-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ZhsqShrz",description = "手环日志")
public class ZhsqShrz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 手环日志ID */
    @Excel(name = "手环日志ID")
    private String shrzid;
    /** 高压 */
    @Excel(name = "高压")
    @ApiModelProperty("高压")
    private String high;
    /** 低压 */
    @Excel(name = "低压")
    @ApiModelProperty("低压")
    private String low;
    /** 心率 */
    @Excel(name = "心率")
    @ApiModelProperty("心率")
    private String heartRate;
    /** 血氧 */
    @Excel(name = "血氧")
    @ApiModelProperty("血氧")
    private String bloodOxygen;
    /** 体温 */
    @Excel(name = "体温")
    @ApiModelProperty("体温")
    private String temperature ;
    /** 电量 */
    @Excel(name = "电量")
    @ApiModelProperty("电量")
    private String battery;
    /** 是否佩戴
     * 1：表示佩戴，0表示没有佩戴
     * */
    @Excel(name = "是否佩戴")
    @ApiModelProperty(value = "是否佩戴", allowableValues = "1,0")
    private String wearState;
    /** 是否充电
     * 1：表示充电，0表示没有充电
     * */
    @Excel(name = "是否充电")
    @ApiModelProperty(value = "是否充电", allowableValues = "1,0")
    private String chargeState;
    /** 手环ID */
    @Excel(name = "手环ID")
    private String shid;
    @ApiModelProperty(value="手环imei", required = true)
    private String imei;
    /** gps纬度 */
    @Excel(name = "gps纬度")
    @ApiModelProperty("gps纬度")
    private String gpsLat;
    /** gps经度 */
    @Excel(name = "gps经度")
    @ApiModelProperty("gps经度")
    private String gpsLng;
    /** gps是否有效 true:有效 false:无效*/
    @Excel(name = "gps是否有效")
    @ApiModelProperty("gps是否有效")
    private String gpsIsValid;
    /** 基站纬度 */
    @Excel(name = "基站纬度")
    @ApiModelProperty("基站纬度")
    private String nodeBLat;
    /** 基站经度 */
    @Excel(name = "基站经度")
    @ApiModelProperty("基站经度")
    private String nodeBLng;
    /** 报警状态
     * 00：为无任何报警 01：SOS 02：低电 03：脱落报警 04：佩戴提醒 05：剪断报警 06：跌倒报警 07：心率异常 08：心率过高 09：心率过低 10：收缩压过高 11：收缩压过低 12：舒张压过高 13：舒张压过低
     * */
    @Excel(name = "报警状态")
    @ApiModelProperty("报警状态")
    private String alarmState ;

}