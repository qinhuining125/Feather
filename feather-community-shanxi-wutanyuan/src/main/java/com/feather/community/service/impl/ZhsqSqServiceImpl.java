package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqSq;
import com.feather.community.mapper.ZhsqSqMapper;
import com.feather.community.service.IZhsqSqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 社区Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqSqServiceImpl implements IZhsqSqService {
    @Autowired
    private ZhsqSqMapper zhsqSqMapper;

    /**
     * 查询社区
     * 
     * @param xqid 社区ID
     * @return 社区
     */
    @Override
    public ZhsqSq selectZhsqSqById(String xqid) {
        return zhsqSqMapper.selectZhsqSqById(xqid);
    }

    /**
     * 查询社区列表
     * 
     * @param zhsqSq 社区
     * @return 社区
     */
    @Override
    public List<ZhsqSq> selectZhsqSqList(ZhsqSq zhsqSq) {
        return zhsqSqMapper.selectZhsqSqList(zhsqSq);
    }


    /**
     * 获取社区列表(用于数据字典)
     * @return
     */
    @Override
    public List<Map<String, String>> selectZhsqSqType() {
        return zhsqSqMapper.selectZhsqSqType();
    }

    /**
     * 新增社区
     * 
     * @param zhsqSq 社区
     * @return 结果
     */
    @Override
    public int insertZhsqSq(ZhsqSq zhsqSq) {
        return zhsqSqMapper.insertZhsqSq(zhsqSq);
    }

    /**
     * 修改社区
     * 
     * @param zhsqSq 社区
     * @return 结果
     */
    @Override
    public int updateZhsqSq(ZhsqSq zhsqSq) {
        return zhsqSqMapper.updateZhsqSq(zhsqSq);
    }

    /**
     * 删除社区对象
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSqByIds(String ids) {
        return zhsqSqMapper.deleteZhsqSqByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区信息
     * 
     * @param xqid
     *            社区ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSqById(String xqid) {
        return zhsqSqMapper.deleteZhsqSqById(xqid);
    }
}
