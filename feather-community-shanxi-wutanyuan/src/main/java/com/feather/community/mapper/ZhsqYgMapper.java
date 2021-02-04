package com.feather.community.mapper;


import com.feather.community.domain.ZhsqYg;

import java.util.List;

/**
 * 烟感Mapper接口
 *
 * @author fancy
 * @date 2020-12-10
 */
public interface ZhsqYgMapper
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
     * 删除烟感
     *
     * @param ygid 烟感ID
     * @return 结果
     */
    public int deleteZhsqYgById(String ygid);

    /**
     * 批量删除烟感
     *
     * @param ygids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqYgByIds(String[] ygids);
}