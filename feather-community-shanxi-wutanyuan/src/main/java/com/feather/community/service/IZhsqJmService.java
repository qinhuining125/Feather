package com.feather.community.service;

import java.util.List;
import java.util.Map;

import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.ZhsqJm;

/**
 * 居民Service接口
 * 
 * @author fancy
 * @date 2020-05-14
 */
public interface IZhsqJmService {
    /**
     * 查询居民
     * 
     * @param jmid
     *            居民ID
     * @return 居民
     */
    ZhsqJm selectZhsqJmById(String jmid);

    /**
     * 查询居民列表
     * 
     * @param zhsqJm
     *            居民
     * @return 居民集合
     */
    List<ZhsqJm> selectZhsqJmList(ZhsqJm zhsqJm);


    /**
     * 居民列表（数据字典）
     * @return
     */
    List<Map<String, String>> selectZhsqJmType();

    /**
     * 新增居民
     * 
     * @param zhsqJm
     *            居民
     * @return 结果
     */
    int insertZhsqJm(ZhsqJm zhsqJm);

    /**
     * 修改居民
     * 
     * @param zhsqJm
     *            居民
     * @return 结果
     */
    int updateZhsqJm(ZhsqJm zhsqJm);

    /**
     * 批量删除居民
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqJmByIds(String ids);

    /**
     * 删除居民信息
     * 
     * @param jmid
     *            居民ID
     * @return 结果
     */
    int deleteZhsqJmById(String jmid);

    List<Map> getPersonInfo(Map<String, Object> maps);

    List<Map<String, Object>> getFwRy(Map<String, Object> maps);

    /**
     * 查询重点人员信息
     * @param params
     * @return
     */
    AjaxResult getZdryTj(Map<String, Object> params);


    /**
     * 社区概况统计
     * @param params
     * @return
     */
    AjaxResult getSqgkTj(Map<String, Object> params);


    /**
     * 常驻人口统计
     * @param params
     * @return
     */
    AjaxResult getSfczTj(Map<String, Object> params);

    /**
     * 年龄结构统计
     * @param params
     * @return
     */
    AjaxResult getNljgTj(Map<String, Object> params);

    /**
     * 性别统计
     * @param params
     * @return
     */
    AjaxResult getXbTj(Map<String, Object> params);

    /**
     * 民族统计
     * @param params
     * @return
     */
    AjaxResult getMzTj(Map<String, Object> params);


    /**
     * 查询居民(根据id)
     *
     * @param jmid
     *            居民ID
     * @return 居民
     */
    AjaxResult getZhsqJmById(String jmid);

    List<Map<String, Object>> getZdRyLd();
}
