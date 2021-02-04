package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.feather.common.config.UidWorker;
//import com.feather.community.domain.ZhsqSbjl;
//import com.feather.community.domain.ZhsqSbll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqSbrzMapper;
import com.feather.community.domain.ZhsqSbrz;
import com.feather.community.service.IZhsqSbrzService;
import com.feather.common.core.text.Convert;

/**
 * 水表日志Service业务层处理
 * 
 * @author qhn
 * @date 2021-01-07
 */
@Service
public class ZhsqSbrzServiceImpl implements IZhsqSbrzService 
{
    @Autowired
    private ZhsqSbrzMapper zhsqSbrzMapper;
    @Autowired
    private UidWorker uidWorker;
    /**
     * 查询水表日志
     * 
     * @param sbrzid 水表日志ID
     * @return 水表日志
     */
    @Override
    public ZhsqSbrz selectZhsqSbrzById(String sbrzid)
    {
        return zhsqSbrzMapper.selectZhsqSbrzById(sbrzid);
    }

    /**
     * 查询水表日志列表
     * 
     * @param zhsqSbrz 水表日志
     * @return 水表日志
     */
    @Override
    public List<ZhsqSbrz> selectZhsqSbrzList(ZhsqSbrz zhsqSbrz)
    {
        return zhsqSbrzMapper.selectZhsqSbrzList(zhsqSbrz);
    }

    /**
     * 新增水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    @Override
    public int insertZhsqSbrz(ZhsqSbrz zhsqSbrz)
    {
        String shrzid = "SHRZ" + uidWorker.getNextId();
        zhsqSbrz.setSbrzid(shrzid);
        return zhsqSbrzMapper.insertZhsqSbrz(zhsqSbrz);
    }

    /**
     * 修改水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    @Override
    public int updateZhsqSbrz(ZhsqSbrz zhsqSbrz)
    {
        return zhsqSbrzMapper.updateZhsqSbrz(zhsqSbrz);
    }

    /**
     * 删除水表日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSbrzByIds(String ids)
    {
        return zhsqSbrzMapper.deleteZhsqSbrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除水表日志信息
     * 
     * @param sbrzid 水表日志ID
     * @return 结果
     */
    public int deleteZhsqSbrzById(String sbrzid)
    {
        return zhsqSbrzMapper.deleteZhsqSbrzById(sbrzid);
    }

    @Override
    public List<ZhsqSbrz> get5DayData() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String before1= sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs1 = zhsqSbrzMapper.get5DayData(before1);
        long ddd=zhsqSbrzs1.get(zhsqSbrzs1.size()-1).getDeviceTotalData();
        Long day1 = zhsqSbrzs1.get(0).getDeviceTotalData()-zhsqSbrzs1.get(zhsqSbrzs1.size()-1).getDeviceTotalData();
//        ZhsqSbll sbjl
//        return  zhsqSbrzMapper.get5DayData(before1);
        return null;
    }
}
