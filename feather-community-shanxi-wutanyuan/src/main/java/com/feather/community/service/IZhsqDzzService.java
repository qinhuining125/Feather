package com.feather.community.service;

import com.feather.community.domain.ZhsqDzz;

import java.util.List;

/**
 * 党组织Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqDzzService {
    /**
     * 查询党组织
     * 
     * @param dzzid 党组织ID
     * @return 党组织
     */
    public ZhsqDzz selectZhsqDzzById(String dzzid);

    /**
     * 查询党组织列表
     * 
     * @param zhsqDzz 党组织
     * @return 党组织集合
     */
    public List<ZhsqDzz> selectZhsqDzzList(ZhsqDzz zhsqDzz);

    /**
     * 新增党组织
     * 
     * @param zhsqDzz 党组织
     * @return 结果
     */
    public int insertZhsqDzz(ZhsqDzz zhsqDzz);

    /**
     * 修改党组织
     * 
     * @param zhsqDzz 党组织
     * @return 结果
     */
    public int updateZhsqDzz(ZhsqDzz zhsqDzz);

    /**
     * 批量删除党组织
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqDzzByIds(String ids);

    /**
     * 删除党组织信息
     * 
     * @param dzzid 党组织ID
     * @return 结果
     */
    public int deleteZhsqDzzById(String dzzid);
}
