package com.feather.community.mapper;


import com.feather.community.domain.ZhsqZj;

import java.util.List;

/**
 * 闸机Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqZjMapper {
    /**
     * 查询闸机
     * 
     * @param zjid 闸机id
     * @return 闸机
     */
    public ZhsqZj selectZhsqZjById(String zjid);

    /**
     * 查询闸机列表
     * 
     * @param ZhsqZj 闸机id
     *
     * @return 闸机集合
     */
    public List<ZhsqZj> selectZhsqZjList(ZhsqZj ZhsqZj);

    /**
     * 新增闸机
     * 
     * @param ZhsqZj 新增闸机
     *
     * @return 结果
     */
    public int insertZhsqZj(ZhsqZj ZhsqZj);

    /**
     * 修改闸机
     * 
     * @param ZhsqZj 闸机
     *
     * @return 结果
     */
    public int updateZhsqZj(ZhsqZj ZhsqZj);

    /**
     * 删除闸机
     * 
     * @param zjid
     *
     * @return 结果
     */
    public int deleteZhsqZjById(String zjid);

    /**
     * 批量删除闸机
     * 
     * @param zjids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqZjByIds(String[] zjids);
}
