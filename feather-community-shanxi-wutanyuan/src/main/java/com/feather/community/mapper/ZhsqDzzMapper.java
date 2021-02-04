package com.feather.community.mapper;


import com.feather.community.domain.ZhsqDzz;

import java.util.List;

/**
 * 党组织Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqDzzMapper {
    /**
     * 查询党组织
     * 
     * @param dzzid 党组织id
     * @return 党组织
     */
    public ZhsqDzz selectZhsqDzzById(String dzzid);

    /**
     * 查询党组织列表
     * 
     * @param zhsqDzz 党组织
     *
     * @return 党组织集合
     */
    public List<ZhsqDzz> selectZhsqDzzList(ZhsqDzz zhsqDzz);

    /**
     * 新增党组织
     * 
     * @param zhsqDzz 新增党组织
     *
     * @return 结果
     */
    public int insertZhsqDzz(ZhsqDzz zhsqDzz);

    /**
     * 修改党组织
     * 
     * @param zhsqDzz 党组织
     *
     * @return 结果
     */
    public int updateZhsqDzz(ZhsqDzz zhsqDzz);

    /**
     * 删除党组织
     * 
     * @param dzzid
     *
     * @return 结果
     */
    public int deleteZhsqDzzById(String dzzid);

    /**
     * 批量删除党组织
     * 
     * @param dzzids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqDzzByIds(String[] dzzids);
}
