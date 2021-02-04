package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqXq;
import com.feather.community.mapper.ZhsqXqMapper;
import com.feather.community.service.IZhsqXqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 小区Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqXqServiceImpl implements IZhsqXqService {
    @Autowired
    private ZhsqXqMapper zhsqXqMapper;

    /**
     * 查询小区
     * 
     * @param xqid 小区ID
     * @return 小区
     */
    @Override
    public ZhsqXq selectZhsqXqById(String xqid) {
        return zhsqXqMapper.selectZhsqXqById(xqid);
    }

    /**
     * 查询小区列表
     * 
     * @param zhsqXq 小区
     * @return 小区
     */
    @Override
    public List<ZhsqXq> selectZhsqXqList(ZhsqXq zhsqXq) {
        return zhsqXqMapper.selectZhsqXqList(zhsqXq);
    }


    /**
     * 获取小区列表(用于数据字典)
     * @return
     */
    @Override
    public List<Map<String, String>> selectZhsqXqType() {
        return zhsqXqMapper.selectZhsqXqType();
    }

    /**
     * 新增小区
     * 
     * @param zhsqXq 小区
     * @return 结果
     */
    @Override
    public int insertZhsqXq(ZhsqXq zhsqXq) {
        return zhsqXqMapper.insertZhsqXq(zhsqXq);
    }

    /**
     * 修改小区
     * 
     * @param zhsqXq 小区
     * @return 结果
     */
    @Override
    public int updateZhsqXq(ZhsqXq zhsqXq) {
        return zhsqXqMapper.updateZhsqXq(zhsqXq);
    }

    /**
     * 删除小区对象
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqXqByIds(String ids) {
        return zhsqXqMapper.deleteZhsqXqByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小区信息
     * 
     * @param xqid
     *            小区ID
     * @return 结果
     */
    @Override
    public int deleteZhsqXqById(String xqid) {
        return zhsqXqMapper.deleteZhsqXqById(xqid);
    }
}
