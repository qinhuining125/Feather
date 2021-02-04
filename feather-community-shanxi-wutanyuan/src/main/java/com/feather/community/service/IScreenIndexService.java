package com.feather.community.service;

import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqLd;
import com.feather.community.pojo.SearchEntity;

import java.util.List;
import java.util.Map;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-10 16:22
 * @description 统计的service
 */
public interface IScreenIndexService {

    /**
     * 常驻人口统计
     * @param param
     * @return
     */
    AjaxResult getSfczTj(Map<String, Object> param);

    /**
     * 社区管理居民统计
     * @return
     */
    AjaxResult sqglJmTj(Map<String, Object> params);

    /**
     * 社区管理房屋统计
     * @return
     */
    AjaxResult sqglFwTj();

    /**
     * 社区管理设备统计
     * @return
     */
    AjaxResult sqglSbTj();

    /**
     * 智慧党建统计
     * @return
     */
    AjaxResult zhdjTj(Map<String, Object> params);

    /**
     * 综合治理统计
     * @param params
     * @return
     */
    AjaxResult zhzlZdryTj(Map<String, Object> params);

    /**
     * 查询居民列表
     * @param searchEntity（1.楼栋 2房屋 3居民）
     * @return
     */
    TableDataInfo searZhsqListByType(SearchEntity searchEntity);

    /**
     * 查询楼栋列表
     * @param zhsqLd
     * @return
     */
    TableDataInfo searchLdList(ZhsqLd zhsqLd);
}
