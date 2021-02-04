package com.feather.community.mapper;


import com.feather.community.domain.ZhsqDy;

import java.util.List;

/**
 * 党员Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqDyMapper {
    /**
     * 查询党员
     * 
     * @param dyid 党员id
     * @return 党员
     */
    public ZhsqDy selectZhsqDyById(String dyid);

    /**
     * 查询党员列表
     * 
     * @param zhsqDy 党员
     *
     * @return 党员集合
     */
    public List<ZhsqDy> selectZhsqDyList(ZhsqDy zhsqDy);

    /**
     * 新增党员
     * 
     * @param zhsqDy 新增党员
     *
     * @return 结果
     */
    public int insertZhsqDy(ZhsqDy zhsqDy);

    /**
     * 修改党员
     * 
     * @param zhsqDy 党员
     *
     * @return 结果
     */
    public int updateZhsqDy(ZhsqDy zhsqDy);

    /**
     * 删除党员
     * 
     * @param dyid
     *
     * @return 结果
     */
    public int deleteZhsqDyById(String dyid);

    /**
     * 批量删除党员
     * 
     * @param dyids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqDyByIds(String[] dyids);
}
