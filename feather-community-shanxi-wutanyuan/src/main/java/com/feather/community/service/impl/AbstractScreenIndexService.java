package com.feather.community.service.impl;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.config.CommunityConstants;
import com.feather.community.mapper.KeyEntityMapper;
import com.feather.community.mapper.ScreenIndexMapper;
import com.feather.community.pojo.DataEntity;
import com.feather.community.pojo.KeyEntity;
import com.feather.community.pojo.ResultEntity;
import com.feather.community.service.*;
import com.feather.community.stragegy.*;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 13:38
 * @description 抽象类
 */
public abstract class AbstractScreenIndexService implements IScreenIndexService {
    @Autowired
    IZhsqTsjyService zhsqTsjyService;
    @Autowired
    IZhsqYcService zhsqYcService;
    @Autowired
    IZhsqJmService zhsqJmService;
    @Autowired
    IZhsqGgService zhsqGgService;
    @Autowired
    IZhsqZcService zhsqZcService;
    @Autowired
    IZhsqLdService zhsqLdService;
    @Autowired
    IZhsqFwService zhsqFwService;
    @Autowired
    IZhsqCwService zhsqCwService;
    @Autowired
    IZhsqSxtService zhsqSxtService;
    @Autowired
    IZhsqClService zhsqClService;
    @Autowired
    IZhsqDzzService zhsqDzzService;
    @Autowired
    IZhsqDyService zhsqDyService;
    @Autowired
    ScreenIndexMapper screenIndexMapper;
    @Autowired
    KeyEntityMapper keyEntityMapper;

    @Autowired
    TableStrategyContext tableStrategyContext;
    @Autowired
    ZhsqLdTableStrategy zhsqLdTableStrategy;
    @Autowired
    ZhsqFwTableStrategy zhsqFwTableStrategy;
    @Autowired
    ZhsqJmTableStrategy zhsqJmTableStrategy;
    @Autowired
    ZhsqClTableStrategy zhsqClTableStrategy;
    @Autowired
    ZhsqDzzTableStrategy zhsqDzzTableStrategy;
    @Autowired
    ZhsqDyTableStrategy zhsqDyTableStrategy;
    @Autowired
    ZhsqYcTableStrategy zhsqYcTableStrategy;


    TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 将房屋统计变为list
     *
     * @param param
     * @return
     */
    ResultEntity convertFwTjToList(Map<String, String> param) {
        ResultEntity resultEntity = new ResultEntity();
        Map<String, List<DataEntity>> result = new HashMap<>(16);
        // 房屋入住情况
        List<DataEntity> fwrzqkList = new ArrayList<>();
        // 房屋使用用途
        List<DataEntity> fwsyytList = new ArrayList<>();
        // 房屋产权状态
        List<DataEntity> fwcqztList = new ArrayList<>();
        DataEntity dataEntity = null;
        Double percentage = 0d;
        Long mapValueLong = 0L;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            if (mapKey.equals("sy") || mapKey.equals("zz") || mapKey.equals("qt")) {
                mapValueLong = Long.parseLong(mapValue);
                if (mapKey.equals("sy")) {
                    percentage = Double.parseDouble(param.get("sybfb"));
                    dataEntity = new DataEntity("商业", mapValueLong, percentage, "#43e8fb");
                } else if (mapKey.equals("zz")) {
                    percentage = Double.parseDouble(param.get("zzbfb"));
                    dataEntity = new DataEntity("住宅", mapValueLong, percentage, "#fde57c");
                } else {
                    percentage = Double.parseDouble(param.get("qtbfb"));
                    dataEntity = new DataEntity("其他", mapValueLong, percentage, "#fee47c");
                }
                fwsyytList.add(dataEntity);
            } else if (mapKey.equals("cz") || mapKey.equals("zy")) {
                mapValueLong = Long.parseLong(mapValue);
                if (mapKey.equals("cz")) {
                    dataEntity = new DataEntity("租房", mapValueLong);
                } else {
                    dataEntity = new DataEntity("自有", mapValueLong);
                }
                fwcqztList.add(dataEntity);
            } else if (mapKey.equals("fwzs")) {
                mapValueLong = Long.parseLong(mapValue);
                resultEntity.setTotal(mapValueLong);
            } else if (mapKey.equals("rz") || mapKey.equals("kz")) {
                mapValueLong = Long.parseLong(mapValue);
                if (mapKey.equals("rz")) {
                    dataEntity = new DataEntity("入住", mapValueLong, "");
                } else {
                    dataEntity = new DataEntity("空置", mapValueLong, "");
                }
                fwrzqkList.add(dataEntity);
            }
        }
        result.put("fwrzqkList", fwrzqkList);
        result.put("fwsyytList", fwsyytList);
        result.put("fwcqztList", fwcqztList);
        resultEntity.setMap(result);
        return resultEntity;
    }

    /**
     * 根据list字段进行分组
     *
     * @param type
     * @return
     */
    Map<String, List<KeyEntity>> groupByListCol(String type) {
        List<KeyEntity> keyEntityList = keyEntityMapper.selectKeyEntityListByType(type);
        Map<String, List<KeyEntity>> mapList = keyEntityList.stream()
                .collect(Collectors.groupingBy(keyEntity -> keyEntity.getList()));
        return mapList;
    }

    /**
     * 初始化resultMap
     *
     * @param mapList
     * @return
     */
    Map<String, List<DataEntity>> initResultMapList(Map<String, List<KeyEntity>> mapList) {
        Map<String, List<DataEntity>> result = new HashMap<>(16);
        Set<String> mapKeys = mapList.keySet();
        for (String key : mapKeys) {
            List<DataEntity> list = new ArrayList<>();
            result.put(key, list);
        }
        return result;
    }

    /**
     * 将结果转换为前端需要
     *
     * @param type
     * @param data
     */
    ResultEntity parseToFrontResult(String type, Map<String, String> data) {
        ResultEntity resultEntity = new ResultEntity();
        Map<String, List<KeyEntity>> paramMapList = groupByListCol(type);
        Map<String, List<DataEntity>> resultMapList = initResultMapList(paramMapList);

        if (data.containsKey(CommunityConstants.TOTAL)) {
            resultEntity.setTotal(Long.parseLong(data.get(CommunityConstants.TOTAL)));
        }

        for (Map.Entry<String, List<KeyEntity>> entry : paramMapList.entrySet()) {
            Double percentage = 0d;
            Long mapValueLong = 0L;
            String color = "";
            List<KeyEntity> mapValue = entry.getValue();
            for (KeyEntity keyEntity : mapValue) {
                String typeList = keyEntity.getList();
                String searchKey = keyEntity.getKey();
                if (data.containsKey(searchKey) && resultMapList.containsKey(typeList)) {
                    List<DataEntity> dataEntityList = resultMapList.get(typeList);
                    mapValueLong = Long.parseLong(data.get(searchKey));
                    if (data.containsKey(searchKey + "bfb")) {
                        percentage = Double.parseDouble(data.get(searchKey + "bfb"));
                    }
                    if (Strings.isNotBlank(keyEntity.getColor())) {
                        color = keyEntity.getColor();
                    }
                    DataEntity dataEntity = new DataEntity(keyEntity.getName(), mapValueLong, percentage, color);
                    dataEntityList.add(dataEntity);
                }
            }
        }
        resultEntity.setMap(resultMapList);
        return resultEntity;
    }

    ResultEntity otherChartData(Map<String, String> data) {
        ResultEntity resultEntity = new ResultEntity();
        List<String> keys = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        List<DataEntity> datas = new ArrayList<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Long longValue = Long.parseLong(value);
            keys.add(key);
            values.add(longValue);
            DataEntity dataEntity = new DataEntity(key, longValue);
            datas.add(dataEntity);

        }
        resultEntity.setKeys(keys);
        resultEntity.setValues(values);
        resultEntity.setDatas(datas);
        return resultEntity;
    }

    /**
     * 动态调用mapper方法
     *
     * @param params
     * @param methodName
     * @return
     */
    ResultEntity getDynamicMethodResultEntity(Map<String, Object> params, String methodName) {
        Map<String, String> result = new HashMap<>(16);
        try {
            Method method = screenIndexMapper.getClass().getMethod(methodName, Map.class);
            List<Map<String, String>> resultList = (List<Map<String, String>>) method.invoke(screenIndexMapper, params);
            if (resultList != null && resultList.size() > 0) {
                for (Map<String, String> map : resultList) {
                    String xb = map.get("keys");
                    String sl = map.get("sl");
                    result.put(xb, sl);
                }
            }
            ResultEntity resultEntity = otherChartData(result);
            return resultEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加反射的统计结果到结果集中
     *
     * @param params 参数
     * @param map    拼接的要反射的方法
     * @param result 结果
     */
    void addTjResultToMapByDynamicMethod(Map<String, Object> params, Map<String, String> map, Map<String, ResultEntity> result) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String methodName = entry.getValue();
            ResultEntity resultEntity = getDynamicMethodResultEntity(params, methodName);
            if (resultEntity != null) {
                result.put(key, resultEntity);
            }
        }
    }

    /**
     * 党政队伍统计
     *
     * @param params
     */
    ResultEntity getDzdwTjResultEntity(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        List<Map<String, String>> resultList = screenIndexMapper.getDzdwTj(params);
        if (resultList != null && resultList.size() > 0) {
            for (Map<String, String> map : resultList) {
                String res = map.get("sl");
                String[] arr = res.split(",");
                result.put(arr[0], arr[1]);
            }
        }
        ResultEntity resultEntity = parseToFrontResult("zhdjdzdw", result);
        return resultEntity;
    }

    /**
     * 重点人员人数统计
     *
     * @param params
     * @return
     */
    ResultEntity getZdryrzTjResultEntity(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        List<Map<String, String>> resultList = screenIndexMapper.getZdryrsTj(params);
        if (resultList != null && resultList.size() > 0) {
            for (Map<String, String> map : resultList) {
                String res = map.get("sl");
                String[] arr = res.split(",");
                result.put(arr[0], arr[1]);
            }
        }
        ResultEntity resultEntity = parseToFrontResult("zhzl", result);
        return resultEntity;
    }
}
