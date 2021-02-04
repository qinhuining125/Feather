package com.feather.community.service;

import com.feather.community.domain.ZhsqDy;

import java.util.List;

/**
 * 党员Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqDyService {
    /**
     * 查询党员
     * 
     * @param dyid 党员ID
     * @return 党员
     */
    public ZhsqDy selectZhsqDyById(String dyid);

    /**
     * 查询党员列表
     * 
     * @param zhsqDy 党员
     * @return 党员集合
     */
    public List<ZhsqDy> selectZhsqDyList(ZhsqDy zhsqDy);

    /**
     * 新增党员
     * 
     * @param zhsqDy 党员
     * @return 结果
     */
    public int insertZhsqDy(ZhsqDy zhsqDy);

    /**
     * 修改党员
     * 
     * @param zhsqDy 党员
     * @return 结果
     */
    public int updateZhsqDy(ZhsqDy zhsqDy);

    /**
     * 批量删除党员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqDyByIds(String ids);

    /**
     * 删除党员信息
     * 
     * @param dyid 党员ID
     * @return 结果
     */
    public int deleteZhsqDyById(String dyid);
}
