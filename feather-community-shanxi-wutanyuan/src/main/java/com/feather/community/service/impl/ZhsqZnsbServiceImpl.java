package com.feather.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqZnsb;
import com.feather.community.mapper.ZhsqZnsbMapper;
import com.feather.community.service.IZhsqZnsbService;

/**
 * communityService业务层处理
 * 
 * @author fancy
 * @date 2020-09-01
 */
@Service
public class ZhsqZnsbServiceImpl implements IZhsqZnsbService {
    @Autowired
    private ZhsqZnsbMapper zhsqZnsbMapper;

    /**
     * 查询community
     * 
     * @param id
     *            communityID
     * @return community
     */
    @Override
    public ZhsqZnsb selectZhsqZnsbById(String id) {
        return zhsqZnsbMapper.selectZhsqZnsbById(id);
    }

    /**
     * 查询community列表
     * 
     * @param zhsqZnsb
     *            community
     * @return community
     */
    @Override
    public List<ZhsqZnsb> selectZhsqZnsbList(ZhsqZnsb zhsqZnsb) {
        return zhsqZnsbMapper.selectZhsqZnsbList(zhsqZnsb);
    }

    /**
     * 新增community
     * 
     * @param zhsqZnsb
     *            community
     * @return 结果
     */
    @Override
    public int insertZhsqZnsb(ZhsqZnsb zhsqZnsb) {
        return zhsqZnsbMapper.insertZhsqZnsb(zhsqZnsb);
    }

    /**
     * 修改community
     * 
     * @param zhsqZnsb
     *            community
     * @return 结果
     */
    @Override
    public int updateZhsqZnsb(ZhsqZnsb zhsqZnsb) {
        return zhsqZnsbMapper.updateZhsqZnsb(zhsqZnsb);
    }

    /**
     * 删除community对象
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqZnsbByIds(String ids) {
        return zhsqZnsbMapper.deleteZhsqZnsbByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除community信息
     * 
     * @param id
     *            communityID
     * @return 结果
     */
    public int deleteZhsqZnsbById(String id) {
        return zhsqZnsbMapper.deleteZhsqZnsbById(id);
    }
}
