package com.feather.community.controller;

import com.feather.common.config.Global;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.StringUtils;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqSbrz;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqShrz;
import com.feather.community.domain.ZhsqYgrz;
import com.feather.community.service.IDeviceService;
import com.feather.community.util.HttpUtil;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 17:30
 * @description 外接设备
 */
@Controller
@RequestMapping("/device")
@Api(value = "设备模块",description = "设备管理相关接口")
public class DeviceController {

    @Autowired
    IDeviceService deviceService;

    @ApiOperation("增加手环")
    @RequestMapping(value = "/api/addSh",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqSh",name = "zhsqSh")
    )
    public AjaxResult addSh(@RequestBody ZhsqSh zhsqSh) {
        return deviceService.addSh(zhsqSh);
    }

    @ApiOperation("增加手环日志")
    @RequestMapping(value = "/api/addShrz",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqShrz",name = "zhsqShrz")
    )
    public AjaxResult addShrz(@RequestBody ZhsqShrz zhsqShrz) {
        return deviceService.addShrz(zhsqShrz);
    }
    @ApiOperation("增加水表日志")
    @RequestMapping(value = "/api/addSbrzdevicedata",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqSbrz",name = "zhsqSbrz")
    )
    public AjaxResult addSbrzdevicedata(@RequestBody ZhsqSbrz zhsqSbrz) {
        return deviceService.addSbrz(zhsqSbrz);
    }
    @ApiOperation("增加烟感日志")
    @RequestMapping(value = "/api/addYgrz",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqYgrz",name = "zhsqYgrz")
    )
    public AjaxResult addYgrz(@RequestBody ZhsqYgrz zhsqYgrz) {
        return deviceService.addYgrz(zhsqYgrz);
    }

    @ApiOperation("下发手环指令")
    @RequestMapping(value = "/api/xfzlSh",method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(name = "imei",required = true)
    )
    public AjaxResult xfzl(String imei) {
        String url = Global.getConfig("device.sh.xfzl");
        return AjaxResult.success(HttpUtil.sendGet(url, "imei="+imei));
    }
}
