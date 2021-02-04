package com.feather.community.service.impl;


import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqYg;
import com.feather.community.mapper.ZhsqYgMapper;
import com.feather.community.service.IZhsqYgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 烟感Service业务层处理
 *
 * @author fancy
 * @date 2020-12-10
 */
@Service
public class ZhsqYgServiceImpl implements IZhsqYgService
{
    @Autowired
    private ZhsqYgMapper zhsqYgMapper;

    /**
     * 查询烟感
     *
     * @param ygid 烟感ID
     * @return 烟感
     */
    @Override
    public ZhsqYg selectZhsqYgById(String ygid)
    {
        return zhsqYgMapper.selectZhsqYgById(ygid);
    }

    /**
     * 查询烟感列表
     *
     * @param zhsqYg 烟感
     * @return 烟感
     */
    @Override
    public List<ZhsqYg> selectZhsqYgList(ZhsqYg zhsqYg)
    {
        return zhsqYgMapper.selectZhsqYgList(zhsqYg);
    }

    /**
     * 新增烟感
     *
     * @param zhsqYg 烟感
     * @return 结果
     */
    @Override
    public int insertZhsqYg(ZhsqYg zhsqYg)
    {
        return zhsqYgMapper.insertZhsqYg(zhsqYg);
    }

    /**
     * 修改烟感
     *
     * @param zhsqYg 烟感
     * @return 结果
     */
    @Override
    public int updateZhsqYg(ZhsqYg zhsqYg)
    {
        return zhsqYgMapper.updateZhsqYg(zhsqYg);
    }

    /**
     * 删除烟感对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqYgByIds(String ids)
    {
        return zhsqYgMapper.deleteZhsqYgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除烟感信息
     *
     * @param ygid 烟感ID
     * @return 结果
     */
    public int deleteZhsqYgById(String ygid)
    {
        return zhsqYgMapper.deleteZhsqYgById(ygid);
    }
}
