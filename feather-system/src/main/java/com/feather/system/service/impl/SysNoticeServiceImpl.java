package com.feather.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.config.UidWorker;
import com.feather.common.core.text.Convert;
import com.feather.system.domain.SysNotice;
import com.feather.system.mapper.SysNoticeMapper;
import com.feather.system.service.ISysNoticeService;

/**
 * 公告 服务层实现
 * 
 * @author feather
 * @date 2018-06-25
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService {
    @Autowired
    private SysNoticeMapper noticeMapper;

    @Autowired
    private UidWorker uidWorker;

    /**
     * 查询公告信息
     * 
     * @param noticeId
     *            公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId) {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice
     *            公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice
     *            公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice) {
        if (notice.getNoticeId() == null) {
            notice.setNoticeId(uidWorker.getNextId());
        }
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice
     *            公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice) {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids) {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }
}