package com.feather.community.service;

import com.feather.community.domain.ZhsqZj;

import java.util.List;

/**
 * 闸机Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqZjService {
    /**
     * 查询闸机
     * 
     * @param zjid 闸机ID
     * @return 车辆
     */
    public ZhsqZj selectZhsqZjById(String zjid);

    /**
     * 查询闸机列表
     * 
     * @param zhsqZj 闸机
     * @return 闸机集合
     */
    public List<ZhsqZj> selectZhsqZjList(ZhsqZj zhsqZj);

    /**
     * 新增闸机
     * 
     * @param zhsqZj 闸机
     * @return 结果
     */
    public int insertZhsqZj(ZhsqZj zhsqZj);

    /**
     * 修改闸机
     * 
     * @param zhsqZj 闸机
     * @return 结果
     */
    public int updateZhsqZj(ZhsqZj zhsqZj);

    /**
     * 批量删除闸机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqZjByIds(String ids);

    /**
     * 删除闸机信息
     * 
     * @param zjid 闸机ID
     * @return 结果
     */
    public int deleteZhsqZjById(String zjid);
}
