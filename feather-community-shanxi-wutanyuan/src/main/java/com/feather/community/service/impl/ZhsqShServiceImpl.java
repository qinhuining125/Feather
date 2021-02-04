package com.feather.community.service.impl;

import java.util.List;
import java.util.Objects;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.mapper.ZhsqShMapper;
import com.feather.community.service.IZhsqJmService;
import com.feather.community.service.IZhsqShService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.common.core.text.Convert;

/**
 * 手环Service业务层处理
 *
 * @author fancy
 * @date 2020-12-14
 */
@Service
public class ZhsqShServiceImpl implements IZhsqShService {
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private IZhsqJmService zhsqJmService;
    @Autowired
    private ZhsqShMapper zhsqShMapper;

    /**
     * 查询手环
     *
     * @param shid 手环ID
     * @return 手环
     */
    @Override
    public ZhsqSh selectZhsqShById(String shid) {
        return zhsqShMapper.selectZhsqShById(shid);
    }

    @Override
    public ZhsqSh selectZhsqShByImei(String imei){
        return zhsqShMapper.selectZhsqShByImei(imei);
    }

    /**
     * 查询手环列表
     *
     * @param zhsqSh 手环
     * @return 手环
     */
    @Override
    public List<ZhsqSh> selectZhsqShList(ZhsqSh zhsqSh) {
        return zhsqShMapper.selectZhsqShList(zhsqSh);
    }

    /**
     * 新增手环
     *
     * @param zhsqSh 手环
     * @return 结果
     */
    @Override
    public int insertZhsqSh(ZhsqSh zhsqSh) {
        String shid = "SH" + uidWorker.getNextId();
        zhsqSh.setShid(shid);
        ZhsqJm zhsqJm = zhsqJmService.selectZhsqJmById(zhsqSh.getJmid());
        if(!Objects.isNull(zhsqJm)){
            zhsqSh.setXm(zhsqJm.getXm());;
        }
        return zhsqShMapper.insertZhsqSh(zhsqSh);
    }

    /**
     * 修改手环
     *
     * @param zhsqSh 手环
     * @return 结果
     */
    @Override
    public int updateZhsqSh(ZhsqSh zhsqSh) {
        return zhsqShMapper.updateZhsqSh(zhsqSh);
    }

    /**
     * 删除手环对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShByIds(String ids) {
        return zhsqShMapper.deleteZhsqShByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手环信息
     *
     * @param shid 手环ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShById(String shid) {
        return zhsqShMapper.deleteZhsqShById(shid);
    }
}