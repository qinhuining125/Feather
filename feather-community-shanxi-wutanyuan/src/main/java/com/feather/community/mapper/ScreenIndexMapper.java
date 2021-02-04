package com.feather.community.mapper;

import com.feather.community.domain.ZhsqCl;

import java.util.List;
import java.util.Map;

/**
 * 大屏Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ScreenIndexMapper {
    /**
     *
     * @param params
     * @return
     */
    List<Map<String, String>> getSfczTj(Map<String, Object> params);

    /**
     * 设备统计
     * @return
     */
    List<Map<String, String>> sqglSbTj();

    /**
     * 年龄结构统计
     * @return
     */
    List<Map<String, String>> getNljgTjByJm(Map<String, Object> params);

    /**
     * 性别统计
     * @param params
     * @return
     */
    List<Map<String, String>> getXbTjByJm(Map<String, Object> params);

    /**
     * 民族统计
     * @param params
     * @return
     */
    List<Map<String, String>> getMzTjByJm(Map<String, Object> params);

    /**
     * 党政队伍统计
     * @param params
     * @return
     */
    List<Map<String, String>> getDzdwTj(Map<String, Object> params);

    /**
     * 党员学历统计
     * @param params
     * @return
     */
    List<Map<String, String>> getDyxlfbTj(Map<String, Object> params);

    /**
     * 党员年龄分布统计
     * @param params
     * @return
     */
    List<Map<String, String>> getDynlfbTj(Map<String, Object> params);

    /**
     * 党员性别比例统计
     * @param params
     * @return
     */
    List<Map<String, String>> getDyxbblTj(Map<String, Object> params);

    /**
     * 党员民族比例统计
     * @param params
     * @return
     */
    List<Map<String, String>> getDymzblTj(Map<String, Object> params);

    /**
     * 重点人员人数统计
     * @param params
     * @return
     */
    List<Map<String, String>> getZdryrsTj(Map<String, Object> params);

    /**
     * 重点人员分布
     * @param params
     * @return
     */
    List<Map<String, String>> getZdryfbTj(Map<String, Object> params);
}
