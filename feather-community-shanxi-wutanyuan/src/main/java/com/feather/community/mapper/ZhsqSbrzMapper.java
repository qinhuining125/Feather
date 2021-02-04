package com.feather.community.mapper;

import com.feather.community.domain.ZhsqSbrz;
import java.util.List;

/**
 * 水表日志Mapper接口
 * 
 * @author qhn
 * @date 2021-01-07
 */
public interface ZhsqSbrzMapper 
{
    /**
     * 查询水表日志
     * 
     * @param sbrzid 水表日志ID
     * @return 水表日志
     */
    public ZhsqSbrz selectZhsqSbrzById(String sbrzid);

    /**
     * 查询水表日志列表
     * 
     * @param zhsqSbrz 水表日志
     * @return 水表日志集合
     */
    public List<ZhsqSbrz> selectZhsqSbrzList(ZhsqSbrz zhsqSbrz);

    /**
     * 新增水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    public int insertZhsqSbrz(ZhsqSbrz zhsqSbrz);

    /**
     * 修改水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    public int updateZhsqSbrz(ZhsqSbrz zhsqSbrz);

    /**
     * 删除水表日志
     * 
     * @param sbrzid 水表日志ID
     * @return 结果
     */
    public int deleteZhsqSbrzById(String sbrzid);

    /**
     * 批量删除水表日志
     * 
     * @param sbrzids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqSbrzByIds(String[] sbrzids);
    /**
     * 获取过去一周内用水情况
     *
     * @return 结果
     */
    List<ZhsqSbrz> get5DayData(String current);
}
