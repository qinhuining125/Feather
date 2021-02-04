package com.feather.community.service;

import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.ZhsqSbrz;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqShrz;
import com.feather.community.domain.ZhsqYgrz;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 17:33
 * @description 设备service
 */
public interface IDeviceService {

    /**
     * 增加手环
     * @param zhsqSh
     * @return
     */
    AjaxResult addSh(ZhsqSh zhsqSh);

    /**
     * 增加手环日志
     * @param zhsqShrz
     * @return
     */
    AjaxResult addShrz(ZhsqShrz zhsqShrz);
    /**
     * 增加水表日志
     * @param zhsqSbrz
     * @return
     */
    AjaxResult addSbrz(ZhsqSbrz zhsqSbrz);
    /**
     * 增加烟感日志
     * @param zhsqYgrz
     * @return
     */
    AjaxResult addYgrz(ZhsqYgrz zhsqYgrz);
}
