package com.feather.community.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqSbMapper;
import com.feather.community.domain.ZhsqSb;
import com.feather.community.service.IZhsqSbService;
import com.feather.common.core.text.Convert;

/**
 * 水表Service业务层处理
 *
 * @author qhn
 * @date 2021-01-07
 */
@Service
public class ZhsqSbServiceImpl implements IZhsqSbService
{
    @Autowired
    private ZhsqSbMapper zhsqSbMapper;

    /**
     * 查询水表
     *
     * @param deviceCode 水表ID
     * @return 水表
     */
    @Override
    public ZhsqSb selectZhsqSbById(String deviceCode)
    {
        return zhsqSbMapper.selectZhsqSbById(deviceCode);
    }

    /**
     * 查询水表列表
     *
     * @param zhsqSb 水表
     * @return 水表
     */
    @Override
    public List<ZhsqSb> selectZhsqSbList(ZhsqSb zhsqSb)
    {
        return zhsqSbMapper.selectZhsqSbList(zhsqSb);
    }

    /**
     * 新增水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    @Override
    public int insertZhsqSb(ZhsqSb zhsqSb)
    {
        return zhsqSbMapper.insertZhsqSb(zhsqSb);
    }

    /**
     * 修改水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    @Override
    public int updateZhsqSb(ZhsqSb zhsqSb)
    {
        return zhsqSbMapper.updateZhsqSb(zhsqSb);
    }

    /**
     * 删除水表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSbByIds(String ids)
    {
        return zhsqSbMapper.deleteZhsqSbByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除水表信息
     *
     * @param deviceCode 水表ID
     * @return 结果
     */
    public int deleteZhsqSbById(String deviceCode)
    {
        return zhsqSbMapper.deleteZhsqSbById(deviceCode);
    }
}