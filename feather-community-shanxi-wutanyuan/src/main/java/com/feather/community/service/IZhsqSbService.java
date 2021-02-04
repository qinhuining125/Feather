package com.feather.community.service;

import com.feather.community.domain.ZhsqSb;
import java.util.List;

/**
 * 水表Service接口
 *
 * @author qhn
 * @date 2021-01-07
 */
public interface IZhsqSbService
{
    /**
     * 查询水表
     *
     * @param deviceCode 水表ID
     * @return 水表
     */
    public ZhsqSb selectZhsqSbById(String deviceCode);

    /**
     * 查询水表列表
     *
     * @param zhsqSb 水表
     * @return 水表集合
     */
    public List<ZhsqSb> selectZhsqSbList(ZhsqSb zhsqSb);

    /**
     * 新增水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    public int insertZhsqSb(ZhsqSb zhsqSb);

    /**
     * 修改水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    public int updateZhsqSb(ZhsqSb zhsqSb);

    /**
     * 批量删除水表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqSbByIds(String ids);

    /**
     * 删除水表信息
     *
     * @param deviceCode 水表ID
     * @return 结果
     */
    public int deleteZhsqSbById(String deviceCode);
}