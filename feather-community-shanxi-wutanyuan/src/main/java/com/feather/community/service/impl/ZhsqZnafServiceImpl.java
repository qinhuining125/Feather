package com.feather.community.service.impl;

import com.feather.community.mapper.ZhsqZnafMapper;
import com.feather.community.service.IZhsqZnafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 社区资产Service业务层处理
 *
 * @author fancy
 * @date 2020-05-14
 */
@Service
public class ZhsqZnafServiceImpl implements IZhsqZnafService  {
    @Autowired
    private ZhsqZnafMapper zhsqZnafMapper;

    @Override
    public List<Map> getCountSb(String sqid, String xqid) {
        return zhsqZnafMapper.getCountSb(sqid, xqid);
    }

    @Override
    public List<Map> getYcList(String sqid, String xqid) {
        return zhsqZnafMapper.getYcList(sqid, xqid);
    }

    @Override
    public List<Map> getCountMj(String sqid, String xqid) {
        return zhsqZnafMapper.getCountMj(sqid, xqid);
    }

    @Override
    public List<Map> getMjjcList(String sqid, String xqid) {
        return zhsqZnafMapper.getMjjcList(sqid, xqid);
    }

    @Override
    public List<Map> getCountZj(String sqid, String xqid) {
        return zhsqZnafMapper.getCountZj(sqid, xqid);
    }

    @Override
    public List<Map> getZjjcList(String sqid, String xqid) {
        return zhsqZnafMapper.getZjjcList(sqid, xqid);
    }

    @Override
    public List<Map> getCountDg(String sqid, String xqid) {
        return zhsqZnafMapper.getCountDg(sqid, xqid);
    }

    @Override
    public List<Map> getDgjcList(String sqid, String xqid) {
        return zhsqZnafMapper.getDgjcList(sqid, xqid);
    }

    @Override
    public List<Map> getSxtList(String wzlx, String sqid, String xqid) {
        return zhsqZnafMapper.getSxtList(wzlx, sqid, xqid);
    }

    @Override
    public List<Map<String, Object>>  getSbtj(String sqid, String xqid) {
        return zhsqZnafMapper.getSbtj(sqid,xqid);
    }

    @Override
    public List<Map<String, Object>>  getBjtj(String sqid, String xqid) {
        return zhsqZnafMapper.getBjtj(sqid,xqid);
    }

    @Override
    public List<Map<String, Object>> getBjcz(Map<String, Object> maps) {
        return zhsqZnafMapper.getBjcz(maps);
    }

    @Override
    public List<Map<String,Object>>  getYcnr(String sqid, String xqid) {
        return zhsqZnafMapper.getYcnr(sqid,xqid);
    }

    @Override
    public List<Map<String, Object>>getSplb() {
        return zhsqZnafMapper.getSplb();
    }

    @Override
    public List<Map<String, Object>> getMjjc(Integer page, Integer size,String jczt) {

        return zhsqZnafMapper.getMjjc(page,size,jczt);
    }

    @Override
    public Integer getMjjcCount(String jczt) {
        return zhsqZnafMapper.getMjjcCount(jczt);
    }

    @Override
    public List<Map<String, Object>> getMj() {
        return zhsqZnafMapper.getMj();
    }

    @Override
    public List<Map<String, Object>> getDg() {
        return zhsqZnafMapper.getDg();
    }

    @Override
    public List<Map<String, Object>> getDgjc(Integer page, Integer size, String jczt) {
        return zhsqZnafMapper.getDgjc(page,size,jczt);
    }

    @Override
    public Integer getDgjcCount(String jczt) {
        return zhsqZnafMapper.getDgjcCount(jczt);
    }

    @Override
    public List<Map<String, Object>> getYgzs(Integer page, Integer size) {
        return zhsqZnafMapper.getYgzs(page,size);
    }
    @Override
    public List<Map<String, Object>> getYg() {
        return zhsqZnafMapper.getYg();
    }
    @Override
    public Integer getYgzsCount() {
        return zhsqZnafMapper.getYgzsCount();
    }

    @Override
    public List<Map<String, Object>> getJgzs(Integer page, Integer size) {
        return zhsqZnafMapper.getJgzs(page,size);
    }

    @Override
    public List<Map<String, Object>> getJg() {
            return zhsqZnafMapper.getJg();
    }

    @Override
    public Integer getJgzsCount() {
        return zhsqZnafMapper.getJgzsCount();
    }

    @Override
    public List<Map<String, Object>> getSbzs(Integer page, Integer size) {
        return zhsqZnafMapper.getSbzs(page,size);
    }

    @Override
    public List<Map<String, Object>> getSb() {
        return zhsqZnafMapper.getSb();
    }

    @Override
    public Integer getSbzsCount() {
        return zhsqZnafMapper.getSbzsCount();
    }


    //新闻公告
    @Override
    public List<Map<String, Object>> getXwgg(String sqid, String xqid) {
        return zhsqZnafMapper.getXwgg(sqid,xqid);
    }

}