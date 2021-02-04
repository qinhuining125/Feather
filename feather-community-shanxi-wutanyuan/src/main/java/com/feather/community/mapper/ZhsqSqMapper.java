package com.feather.community.mapper;

import com.feather.community.domain.ZhsqSq;

import java.util.List;
import java.util.Map;

/**
 * 社区Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqSqMapper {
    /**
     * 查询社区
     * 
     * @param xqid 社区ID
     * @return 社区
     */
    ZhsqSq selectZhsqSqById(String xqid);

    /**
     * 查询社区列表
     * 
     * @param zhsqSq
     *            社区
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
     * 删除社区
     * 
     * @param xqid 社区ID
     * @return 结果
     */
    int deleteZhsqSqById(String xqid);

    /**
     * 批量删除社区
     * 
     * @param xqids  需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqSqByIds(String[] xqids);
}
