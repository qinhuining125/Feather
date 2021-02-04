package com.feather.community.service.impl;

import java.util.List;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqYg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqYgrzMapper;
import com.feather.community.domain.ZhsqYgrz;
import com.feather.community.service.IZhsqYgrzService;
import com.feather.common.core.text.Convert;

/**
 * 烟感日志Service业务层处理
 * 
 * @author qhn
 * @date 2021-01-08
 */
@Service
public class ZhsqYgrzServiceImpl implements IZhsqYgrzService 
{
    @Autowired
    private ZhsqYgrzMapper zhsqYgrzMapper;
    @Autowired
    private UidWorker uidWorker;
    /**
     * 查询烟感日志
     * 
     * @param sbrzid 烟感日志ID
     * @return 烟感日志
     */
    @Override
    public ZhsqYgrz selectZhsqYgrzById(String sbrzid)
    {
        return zhsqYgrzMapper.selectZhsqYgrzById(sbrzid);
    }

    /**
     * 查询烟感日志列表
     * 
     * @param zhsqYgrz 烟感日志
     * @return 烟感日志
     */
    @Override
    public List<ZhsqYgrz> selectZhsqYgrzList(ZhsqYgrz zhsqYgrz)
    {
        return zhsqYgrzMapper.selectZhsqYgrzList(zhsqYgrz);
    }

    /**
     * 新增烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    @Override
    public int insertZhsqYgrz(ZhsqYgrz zhsqYgrz)
    {
        String ygrzid = "YGRZ" + uidWorker.getNextId();
        zhsqYgrz.setSbrzid(ygrzid);
        return zhsqYgrzMapper.insertZhsqYgrz(zhsqYgrz);
    }

    /**
     * 修改烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    @Override
    public int updateZhsqYgrz(ZhsqYgrz zhsqYgrz)
    {
        return zhsqYgrzMapper.updateZhsqYgrz(zhsqYgrz);
    }

    /**
     * 删除烟感日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqYgrzByIds(String ids)
    {
        return zhsqYgrzMapper.deleteZhsqYgrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除烟感日志信息
     * 
     * @param sbrzid 烟感日志ID
     * @return 结果
     */
    public int deleteZhsqYgrzById(String sbrzid)
    {
        return zhsqYgrzMapper.deleteZhsqYgrzById(sbrzid);
    }

}
