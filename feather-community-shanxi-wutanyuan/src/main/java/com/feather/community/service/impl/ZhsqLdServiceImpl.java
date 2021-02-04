package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqLd;
import com.feather.community.mapper.ZhsqLdMapper;
import com.feather.community.service.IZhsqLdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqLdServiceImpl implements IZhsqLdService {
    @Autowired
    private ZhsqLdMapper zhsqLdMapper;

    /**
     * 查询楼栋
     * 
     * @param ldid 楼栋ID
     * @return 楼栋
     */
    @Override
    public ZhsqLd selectZhsqLdById(String ldid) {
        return zhsqLdMapper.selectZhsqLdById(ldid);
    }

    /**
     * 查询楼栋列表
     * 
     * @param zhsqLd 楼栋
     * @return 楼栋
     */
    @Override
    public List<ZhsqLd> selectZhsqLdList(ZhsqLd zhsqLd) {
        return zhsqLdMapper.selectZhsqLdList(zhsqLd);
    }

    @Override
    public List<Map<String, String>>  selectZhsqLdType(){
        return zhsqLdMapper.selectZhsqLdType();
    }

    /**
     * 新增楼栋
     * 
     * @param zhsqLd 楼栋
     * @return 结果
     */
    @Override
    public int insertZhsqLd(ZhsqLd zhsqLd) {
        return zhsqLdMapper.insertZhsqLd(zhsqLd);
    }

    /**
     * 修改楼栋
     * 
     * @param zhsqLd 楼栋
     * @return 结果
     */
    @Override
    public int updateZhsqLd(ZhsqLd zhsqLd) {
        return zhsqLdMapper.updateZhsqLd(zhsqLd);
    }

    /**
     * 删除楼栋对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqLdByIds(String ids) {
        return zhsqLdMapper.deleteZhsqLdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除楼栋信息
     * 
     * @param ldid 楼栋ID
     * @return 结果
     */
    @Override
    public int deleteZhsqLdById(String ldid) {
        return zhsqLdMapper.deleteZhsqLdById(ldid);
    }
}
