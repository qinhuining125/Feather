package com.feather.community.service.impl;

import java.util.List;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqShrz;
import com.feather.community.mapper.ZhsqShrzMapper;
import com.feather.community.service.IZhsqShrzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;

/**
 * 手环日志Service业务层处理
 *
 * @author fancy
 * @date 2020-12-14
 */
@Service
public class ZhsqShrzServiceImpl implements IZhsqShrzService
{
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private ZhsqShrzMapper zhsqShrzMapper;

    /**
     * 查询手环日志
     *
     * @param shrzid 手环日志ID
     * @return 手环日志
     */
    @Override
    public ZhsqShrz selectZhsqShrzById(String shrzid)
    {
        return zhsqShrzMapper.selectZhsqShrzById(shrzid);
    }

    /**
     * 查询手环日志列表
     *
     * @param zhsqShrz 手环日志
     * @return 手环日志
     */
    @Override
    public List<ZhsqShrz> selectZhsqShrzList(ZhsqShrz zhsqShrz)
    {
        return zhsqShrzMapper.selectZhsqShrzList(zhsqShrz);
    }

    /**
     * 新增手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    @Override
    public int insertZhsqShrz(ZhsqShrz zhsqShrz)
    {
        String shrzid = "SHRZ" + uidWorker.getNextId();
        zhsqShrz.setShrzid(shrzid);
        return zhsqShrzMapper.insertZhsqShrz(zhsqShrz);
    }

    /**
     * 修改手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    @Override
    public int updateZhsqShrz(ZhsqShrz zhsqShrz)
    {
        return zhsqShrzMapper.updateZhsqShrz(zhsqShrz);
    }

    /**
     * 删除手环日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShrzByIds(String ids)
    {
        return zhsqShrzMapper.deleteZhsqShrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手环日志信息
     *
     * @param shrzid 手环日志ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShrzById(String shrzid)
    {
        return zhsqShrzMapper.deleteZhsqShrzById(shrzid);
    }
}