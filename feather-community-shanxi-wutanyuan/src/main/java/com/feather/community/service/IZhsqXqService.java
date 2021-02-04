package com.feather.community.service;

import java.util.List;
import java.util.Map;

import com.feather.community.domain.ZhsqXq;

/**
 * 小区Service接口
 *
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqXqService {
    /**
     * 查询小区
     *
     * @param xqid 小区ID
     * @return 小区
     */
    ZhsqXq selectZhsqXqById(String xqid);

    /**
     * 查询小区列表
     *
     * @param zhsqXq 小区
     * @return 小区集合
     */
    List<ZhsqXq> selectZhsqXqList(ZhsqXq zhsqXq);

    /**
     * 查询小区列表（用于数据字典）
     * @return
     */
    List<Map<String, String>> selectZhsqXqType();

    /**
     * 新增小区
     *
     * @param zhsqXq 小区
     * @return 结果
     */
    int insertZhsqXq(ZhsqXq zhsqXq);

    /**
     * 修改小区
     *
     * @param zhsqXq 小区
     * @return 结果
     */
    int updateZhsqXq(ZhsqXq zhsqXq);

    /**
     * 批量删除小区
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqXqByIds(String ids);

    /**
     * 删除小区信息
     *
     * @param xqid
     *            小区ID
     * @return 结果
     */
    int deleteZhsqXqById(String xqid);
}
