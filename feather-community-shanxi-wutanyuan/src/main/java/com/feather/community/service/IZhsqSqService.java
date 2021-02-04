package com.feather.community.service;

import com.feather.community.domain.ZhsqSq;

import java.util.List;
import java.util.Map;

/**
 * 小区Service接口
 *
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqSqService {
    /**
     * 查询社区
     *
     * @param sqid 社区ID
     * @return 社区
     */
    ZhsqSq selectZhsqSqById(String sqid);

    /**
     * 查询社区列表
     *
     * @param zhsqSq 社区
     * @return 社区集合
     */
    List<ZhsqSq> selectZhsqSqList(ZhsqSq zhsqSq);

    /**
     * 查询社区列表（用于数据字典）
     * @return
     */
    List<Map<String, String>> selectZhsqSqType();

    /**
     * 新增社区
     *
     * @param zhsqSq 社区
     * @return 结果
     */
    int insertZhsqSq(ZhsqSq zhsqSq);

    /**
     * 修改社区
     *
     * @param zhsqSq 社区
     * @return 结果
     */
    int updateZhsqSq(ZhsqSq zhsqSq);

    /**
     * 批量删除社区
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqSqByIds(String ids);

    /**
     * 删除社区信息
     *
     * @param sqid
     *            社区ID
     * @return 结果
     */
    int deleteZhsqSqById(String sqid);
}
