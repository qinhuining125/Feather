package com.feather.community.service.impl;

import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.ExceptionUtil;
import com.feather.community.config.CommunityConstants;
import com.feather.community.domain.*;
import com.feather.community.service.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 17:34
 * @description 设备service
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    IZhsqShService zhsqShService;
    @Autowired
    IZhsqShrzService zhsqShrzService;
    @Autowired
    IZhsqSbService zhsqSbService;
    @Autowired
    IZhsqSbrzService zhsqSbrzService;
    @Autowired
    IZhsqYgService zhsqYgService;
    @Autowired
    IZhsqYgrzService zhsqYgrzService;

    @Override
    public AjaxResult addSh(ZhsqSh zhsqSh) {
        try {
            zhsqShService.insertZhsqSh(zhsqSh);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addShrz(ZhsqShrz zhsqShrz) {
        try {
            String imei = zhsqShrz.getImei();
            if (Strings.isBlank(imei)) {
                return AjaxResult.error(CommunityConstants.NO_IEMI);
            }
            ZhsqSh zhsqSh = zhsqShService.selectZhsqShByImei(imei);
            if (Objects.isNull(zhsqSh)) {
                return AjaxResult.error(CommunityConstants.NO_DEVICE_FOUND);
            }
            zhsqShrz.setShid(zhsqSh.getShid());
            int affectNum = zhsqShrzService.insertZhsqShrz(zhsqShrz);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addSbrz(ZhsqSbrz zhsqSbrz) {
        try {
            String deviceCode = zhsqSbrz.getDeviceCode();
            if (Strings.isBlank(deviceCode)) {
                return AjaxResult.error(CommunityConstants.NO_DEVICE_CODE);
            }
            ZhsqSb zhsqSb = zhsqSbService.selectZhsqSbById(deviceCode);
            if (Objects.isNull(zhsqSb)) {
                return AjaxResult.error(CommunityConstants.NO_DEVICE_CODE);
            }
            zhsqSbrz.setDeviceCode(zhsqSb.getDeviceCode());
//            zhsqSbrz.setShid(zhsqSh.getShid());
            int affectNum = zhsqSbrzService.insertZhsqSbrz(zhsqSbrz);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addYgrz(ZhsqYgrz zhsqYgrz) {
        try {
//            sn为烟感id
            String ygid = zhsqYgrz.getImsi();
            if (Strings.isBlank(ygid)) {
                return AjaxResult.error(CommunityConstants.NO_YGID_CODE);
            }
            ZhsqYg zhsqYg = zhsqYgService.selectZhsqYgById(ygid);
            if (Objects.isNull(zhsqYg)) {
                return AjaxResult.error(CommunityConstants.NO_YGID_CODE);
            }
            zhsqYgrz.setImsi(zhsqYg.getYgid());
//            zhsqSbrz.setShid(zhsqSh.getShid());
            int affectNum = zhsqYgrzService.insertZhsqYgrz(zhsqYgrz);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }
}
