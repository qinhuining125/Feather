package com.feather.community.dict;

import com.feather.community.domain.ZhsqFw;
import com.feather.community.domain.ZhsqLd;
import com.feather.community.domain.ZhsqSq;
import com.feather.community.domain.ZhsqXq;
import com.feather.community.service.*;
import com.feather.system.domain.SysDictData;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-09 14:43
 * @description 物探院数据字典服务
 */
@Service("wty")
public class WtyService {
    @Autowired
    IZhsqSqService sqService;
    @Autowired
    IZhsqXqService xqService;
    @Autowired
    IZhsqLdService ldService;
    @Autowired
    IZhsqFwService fwService;
    @Autowired
    IZhsqJmService jmService;

    public List<Map<String, String>> getSqType() {
        List<Map<String, String>> list = sqService.selectZhsqSqType();
        return list;
    }

    public List<Map<String, String>> getXqType() {
        List<Map<String, String>> list = xqService.selectZhsqXqType();
        return list;
    }

    public List<Map<String, String>> getLdType() {
        List<Map<String, String>> list = ldService.selectZhsqLdType();
        return list;
    }

    public List<Map<String, String>> getFwType() {
        List<Map<String, String>> list = fwService.selectZhsqFwType();
        return list;
    }

    public List<Map<String, String>> getJmType(){
        List<Map<String, String>> list = jmService.selectZhsqJmType();
        return list;
    }
}
