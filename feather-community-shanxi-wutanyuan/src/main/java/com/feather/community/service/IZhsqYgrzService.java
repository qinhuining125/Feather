package com.feather.community.service;

import com.feather.community.domain.ZhsqYg;
import com.feather.community.domain.ZhsqYgrz;
import java.util.List;

/**
 * 烟感日志Service接口
 * 
 * @author qhn
 * @date 2021-01-08
 */
public interface IZhsqYgrzService 
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
     * 批量删除烟感日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqYgrzByIds(String ids);

    /**
     * 删除烟感日志信息
     * 
     * @param sbrzid 烟感日志ID
     * @return 结果
     */
    public int deleteZhsqYgrzById(String sbrzid);

}
