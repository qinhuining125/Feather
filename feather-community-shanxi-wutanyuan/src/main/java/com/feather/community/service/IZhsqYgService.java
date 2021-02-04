package com.feather.community.service;


import com.feather.community.domain.ZhsqYg;

import java.util.List;

/**
 * 烟感Service接口
 *
 * @author fancy
 * @date 2020-12-10
 */
public interface IZhsqYgService
{
    /**
     * 查询烟感
     *
     * @param ygid 烟感ID
     * @return 烟感
     */
    public ZhsqYg selectZhsqYgById(String ygid);

    /**
     * 查询烟感列表
     *
     * @param zhsqYg 烟感
     * @return 烟感集合
     */
    public List<ZhsqYg> selectZhsqYgList(ZhsqYg zhsqYg);

    /**
     * 新增烟感
     *
     * @param zhsqYg 烟感
     * @return 结果
     */
    public int insertZhsqYg(ZhsqYg zhsqYg);

    /**
     * 修改烟感
     *
     * @param zhsqYg 烟感
     * @return 结果
     */
    public int updateZhsqYg(ZhsqYg zhsqYg);

    /**
     * 批量删除烟感
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqYgByIds(String ids);

    /**
     * 删除烟感信息
     *
     * @param ygid 烟感ID
     * @return 结果
     */
    public int deleteZhsqYgById(String ygid);
}