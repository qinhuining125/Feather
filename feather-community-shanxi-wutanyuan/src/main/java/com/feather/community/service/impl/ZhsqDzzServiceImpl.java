package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqDzz;
import com.feather.community.mapper.ZhsqDzzMapper;
import com.feather.community.service.IZhsqDzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 党组织Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqDzzServiceImpl implements IZhsqDzzService {
    @Autowired
    private ZhsqDzzMapper zhsqDzzMapper;

    /**
     * 查询党组织
     * 
     * @param dzzid 党组织ID
     * @return 党组织
     */
    @Override
    public ZhsqDzz selectZhsqDzzById(String dzzid) {
        return zhsqDzzMapper.selectZhsqDzzById(dzzid);
    }

    /**
     * 查询党组织列表
     * 
     * @param zhsqDzz 党组织
     * @return 党组织
     */
    @Override
    public List<ZhsqDzz> selectZhsqDzzList(ZhsqDzz zhsqDzz) {
        return zhsqDzzMapper.selectZhsqDzzList(zhsqDzz);
    }

    /**
     * 新增党组织
     * 
     * @param zhsqDzz 党组织
     * @return 结果
     */
    @Override
    public int insertZhsqDzz(ZhsqDzz zhsqDzz) {
        return zhsqDzzMapper.insertZhsqDzz(zhsqDzz);
    }

    /**
     * 修改党组织
     * 
     * @param zhsqDzz 党组织
     * @return 结果
     */
    @Override
    public int updateZhsqDzz(ZhsqDzz zhsqDzz) {
        return zhsqDzzMapper.updateZhsqDzz(zhsqDzz);
    }

    /**
     * 删除党组织对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqDzzByIds(String ids) {
        return zhsqDzzMapper.deleteZhsqDzzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除党组织信息
     * 
     * @param dzzid 党组织ID
     * @return 结果
     */
    @Override
    public int deleteZhsqDzzById(String dzzid) {
        return zhsqDzzMapper.deleteZhsqDzzById(dzzid);
    }
}
