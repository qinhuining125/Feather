package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqMj;
import com.feather.community.mapper.ZhsqMjMapper;
import com.feather.community.service.IZhsqMjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门禁Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqMjServiceImpl implements IZhsqMjService {
    @Autowired
    private ZhsqMjMapper zhsqMjMapper;

    /**
     * 查询门禁
     * 
     * @param ldid 门禁ID
     * @return 门禁
     */
    @Override
    public ZhsqMj selectZhsqMjById(String ldid) {
        return zhsqMjMapper.selectZhsqMjById(ldid);
    }

    /**
     * 查询门禁列表
     * 
     * @param zhsqMj 门禁
     * @return 门禁
     */
    @Override
    public List<ZhsqMj> selectZhsqMjList(ZhsqMj zhsqMj) {
        return zhsqMjMapper.selectZhsqMjList(zhsqMj);
    }

    /**
     * 新增门禁
     * 
     * @param zhsqMj 门禁
     * @return 结果
     */
    @Override
    public int insertZhsqMj(ZhsqMj zhsqMj) {
        return zhsqMjMapper.insertZhsqMj(zhsqMj);
    }

    /**
     * 修改门禁
     * 
     * @param zhsqMj 门禁
     * @return 结果
     */
    @Override
    public int updateZhsqMj(ZhsqMj zhsqMj) {
        return zhsqMjMapper.updateZhsqMj(zhsqMj);
    }

    /**
     * 删除门禁对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqMjByIds(String ids) {
        return zhsqMjMapper.deleteZhsqMjByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除门禁信息
     * 
     * @param ldid 门禁ID
     * @return 结果
     */
    @Override
    public int deleteZhsqMjById(String mjid) {
        return zhsqMjMapper.deleteZhsqMjById(mjid);
    }
}
