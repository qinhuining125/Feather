package com.feather.community.mapper;

import com.feather.community.domain.ZhsqYgrz;
import java.util.List;

/**
 * 烟感日志Mapper接口
 * 
 * @author qhn
 * @date 2021-01-08
 */
public interface ZhsqYgrzMapper 
{
    /**
     * 查询烟感日志
     * 
     * @param sbrzid 烟感日志ID
     * @return 烟感日志
     */
    public ZhsqYgrz selectZhsqYgrzById(String sbrzid);

    /**
     * 查询烟感日志列表
     * 
     * @param zhsqYgrz 烟感日志
     * @return 烟感日志集合
     */
    public List<ZhsqYgrz> selectZhsqYgrzList(ZhsqYgrz zhsqYgrz);

    /**
     * 新增烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    public int insertZhsqYgrz(ZhsqYgrz zhsqYgrz);

    /**
     * 修改烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    public int updateZhsqYgrz(ZhsqYgrz zhsqYgrz);

    /**
     * 删除烟感日志
     * 
     * @param sbrzid 烟感日志ID
     * @return 结果
     */
    public int deleteZhsqYgrzById(String sbrzid);

    /**
     * 批量删除烟感日志
     * 
     * @param sbrzids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqYgrzByIds(String[] sbrzids);
}
