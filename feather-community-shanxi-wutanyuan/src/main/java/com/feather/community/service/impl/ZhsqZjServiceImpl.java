package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqZj;
import com.feather.community.mapper.ZhsqZjMapper;
import com.feather.community.service.IZhsqZjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 闸机Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqZjServiceImpl implements IZhsqZjService {
    @Autowired
    private ZhsqZjMapper zhsqZjMapper;

    /**
     * 查询闸机
     * 
     * @param zjid 闸机ID
     * @return 闸机
     */
    @Override
    public ZhsqZj selectZhsqZjById(String zjid) {
        return zhsqZjMapper.selectZhsqZjById(zjid);
    }

    /**
     * 查询闸机列表
     * 
     * @param zhsqZj 闸机
     * @return 闸机
     */
    @Override
    public List<ZhsqZj> selectZhsqZjList(ZhsqZj zhsqZj) {
        return zhsqZjMapper.selectZhsqZjList(zhsqZj);
    }

    /**
     * 新增闸机
     * 
     * @param zhsqZj 闸机
     * @return 结果
     */
    @Override
    public int insertZhsqZj(ZhsqZj zhsqZj) {
        return zhsqZjMapper.insertZhsqZj(zhsqZj);
    }

    /**
     * 修改闸机
     * 
     * @param zhsqZj 闸机
     * @return 结果
     */
    @Override
    public int updateZhsqZj(ZhsqZj zhsqZj) {
        return zhsqZjMapper.updateZhsqZj(zhsqZj);
    }

    /**
     * 删除闸机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqZjByIds(String ids) {
        return zhsqZjMapper.deleteZhsqZjByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除闸机信息
     * 
     * @param zjid 闸机ID
     * @return 结果
     */
    @Override
    public int deleteZhsqZjById(String zjid) {
        return zhsqZjMapper.deleteZhsqZjById(zjid);
    }
}
