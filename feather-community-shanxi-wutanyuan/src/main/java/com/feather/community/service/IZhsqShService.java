package com.feather.community.service;

import com.feather.community.domain.ZhsqSh;
import java.util.List;

/**
 * 手环Service接口
 *
 * @author fancy
 * @date 2020-12-14
 */
public interface IZhsqShService
{
    /**
     * 查询手环
     *
     * @param shid 手环ID
     * @return 手环
     */
     ZhsqSh selectZhsqShById(String shid);

    /**
     * 查询手环
     * @param imei
     * @return
     */
    ZhsqSh selectZhsqShByImei(String imei);

    /**
     * 查询手环列表
     *
     * @param zhsqSh 手环
     * @return 手环集合
     */
     List<ZhsqSh> selectZhsqShList(ZhsqSh zhsqSh);

    /**
     * 新增手环
     *
     * @param zhsqSh 手环
     * @return 结果
     */
     int insertZhsqSh(ZhsqSh zhsqSh);

    /**
     * 修改手环
     *
     * @param zhsqSh 手环
     * @return 结果
     */
     int updateZhsqSh(ZhsqSh zhsqSh);

    /**
     * 批量删除手环
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteZhsqShByIds(String ids);

    /**
     * 删除手环信息
     *
     * @param shid 手环ID
     * @return 结果
     */
     int deleteZhsqShById(String shid);
}