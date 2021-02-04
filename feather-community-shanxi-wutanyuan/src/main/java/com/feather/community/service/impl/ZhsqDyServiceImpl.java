package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqDy;
import com.feather.community.mapper.ZhsqDyMapper;
import com.feather.community.service.IZhsqDyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 党员Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqDyServiceImpl implements IZhsqDyService {
    @Autowired
    private ZhsqDyMapper zhsqDyMapper;

    /**
     * 查询党员
     * 
     * @param dyid 党员ID
     * @return 党员
     */
    @Override
    public ZhsqDy selectZhsqDyById(String dyid) {
        return zhsqDyMapper.selectZhsqDyById(dyid);
    }

    /**
     * 查询党员列表
     * 
     * @param zhsqDy 党员
     * @return 党员
     */
    @Override
    public List<ZhsqDy> selectZhsqDyList(ZhsqDy zhsqDy) {
        return zhsqDyMapper.selectZhsqDyList(zhsqDy);
    }

    /**
     * 新增党员
     * 
     * @param zhsqDy 党员
     * @return 结果
     */
    @Override
    public int insertZhsqDy(ZhsqDy zhsqDy) {
        return zhsqDyMapper.insertZhsqDy(zhsqDy);
    }

    /**
     * 修改党员
     * 
     * @param zhsqDy 党员
     * @return 结果
     */
    @Override
    public int updateZhsqDy(ZhsqDy zhsqDy) {
        return zhsqDyMapper.updateZhsqDy(zhsqDy);
    }

    /**
     * 删除党员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqDyByIds(String ids) {
        return zhsqDyMapper.deleteZhsqDyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除党员信息
     * 
     * @param dyid 党员ID
     * @return 结果
     */
    @Override
    public int deleteZhsqDyById(String dyid) {
        return zhsqDyMapper.deleteZhsqDyById(dyid);
    }
}
