package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqJg;
import com.feather.community.mapper.ZhsqJgMapper;
import com.feather.community.service.IZhsqJgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 井盖Service业务层处理
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Service
public class ZhsqJgServiceImpl implements IZhsqJgService 
{
    @Autowired
    private ZhsqJgMapper zhsqJgMapper;

    /**
     * 查询井盖
     * 
     * @param jgid 井盖ID
     * @return 井盖
     */
    @Override
    public ZhsqJg selectZhsqJgById(String jgid)
    {
        return zhsqJgMapper.selectZhsqJgById(jgid);
    }

    /**
     * 查询井盖列表
     * 
     * @param zhsqJg 井盖
     * @return 井盖
     */
    @Override
    public List<ZhsqJg> selectZhsqJgList(ZhsqJg zhsqJg)
    {
        return zhsqJgMapper.selectZhsqJgList(zhsqJg);
    }

    /**
     * 新增井盖
     * 
     * @param zhsqJg 井盖
     * @return 结果
     */
    @Override
    public int insertZhsqJg(ZhsqJg zhsqJg)
    {
        return zhsqJgMapper.insertZhsqJg(zhsqJg);
    }

    /**
     * 修改井盖
     * 
     * @param zhsqJg 井盖
     * @return 结果
     */
    @Override
    public int updateZhsqJg(ZhsqJg zhsqJg)
    {
        System.out.println(zhsqJg.toString());
        return zhsqJgMapper.updateZhsqJg(zhsqJg);
    }

    /**
     * 删除井盖对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqJgByIds(String ids)
    {
        return zhsqJgMapper.deleteZhsqJgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除井盖信息
     * 
     * @param jgid 井盖ID
     * @return 结果
     */
    public int deleteZhsqJgById(String jgid)
    {
        return zhsqJgMapper.deleteZhsqJgById(jgid);
    }
}
