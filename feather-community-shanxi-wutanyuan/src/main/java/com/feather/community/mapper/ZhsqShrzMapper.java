package com.feather.community.mapper;


import com.feather.community.domain.ZhsqShrz;

import java.util.List;

/**
 * 手环日志Mapper接口
 *
 * @author fancy
 * @date 2020-12-14
 */
public interface ZhsqShrzMapper
{
    /**
     * 查询手环日志
     *
     * @param shrzid 手环日志ID
     * @return 手环日志
     */
    public ZhsqShrz selectZhsqShrzById(String shrzid);

    /**
     * 查询手环日志列表
     *
     * @param zhsqShrz 手环日志
     * @return 手环日志集合
     */
    public List<ZhsqShrz> selectZhsqShrzList(ZhsqShrz zhsqShrz);

    /**
     * 新增手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    public int insertZhsqShrz(ZhsqShrz zhsqShrz);

    /**
     * 修改手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    public int updateZhsqShrz(ZhsqShrz zhsqShrz);

    /**
     * 删除手环日志
     *
     * @param shrzid 手环日志ID
     * @return 结果
     */
    public int deleteZhsqShrzById(String shrzid);

    /**
     * 批量删除手环日志
     *
     * @param shrzids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqShrzByIds(String[] shrzids);
}