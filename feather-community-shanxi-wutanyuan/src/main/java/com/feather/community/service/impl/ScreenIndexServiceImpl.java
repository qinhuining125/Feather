package com.feather.community.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.*;
import com.feather.community.pojo.SearchEntity;
import org.springframework.stereotype.Service;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.ExceptionUtil;
import com.feather.community.pojo.ResultEntity;
import com.feather.community.util.MathUtil;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-10 16:23
 * @description 统计service
 */
@Service
public class ScreenIndexServiceImpl extends AbstractScreenIndexService {

    @Override
    public AjaxResult getSfczTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            params.put("czrk", "常驻人口");
            params.put("wlrk", "外来人口");
            List<Map<String, String>> sfcz = screenIndexMapper.getSfczTj(params);
            if (sfcz != null && sfcz.size() > 0) {
                for (Map<String, String> map : sfcz) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
            }
            return AjaxResult.success(parseToFrontResult("sqglry", result));
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglJmTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            Map<String, String> map = new HashMap<>(8);
            map.put("nl", "getNljgTjByJm");
            map.put("xb", "getXbTjByJm");
            map.put("mz", "getMzTjByJm");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglFwTj() {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> fwtj = zhsqFwService.sqglFwTj();
            if (fwtj != null && fwtj.size() > 0) {
                for (Map<String, String> map : fwtj) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
                // 入住率
                String rzlbfb = MathUtil.getPercent(result, "rz", "fwzs");
                result.put("rzl", result.get("rz"));
                result.put("rzlbfb", rzlbfb);
                // 商业百分比
                String sybfb = MathUtil.getPercent(result, "sy", "fwzs");
                result.put("sybfb", sybfb);
                // 住宅百分比
                String zzbfb = MathUtil.getPercent(result, "zz", "fwzs");
                result.put("zzbfb", zzbfb);
                // 其他百分比
                String qtbfb = MathUtil.getPercent(result, "qt", "fwzs");
                result.put("qtbfb", qtbfb);
                // 自有百分比
                String zybfb = MathUtil.getPercent(result, "zy", "fwzs");
                result.put("zybfb", zybfb);
                // 出租百分比
                String czbfb = MathUtil.getPercent(result, "cz", "fwzs");
                result.put("czbfb", czbfb);
            }
            return AjaxResult.success(parseToFrontResult("sqglfw", result));
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglSbTj() {
        int sbzs = 0;
        int sbyc = 0;
        int sbzx = 0;
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> sbtj = screenIndexMapper.sqglSbTj();
            if (sbtj != null && sbtj.size() > 0) {
                for (Map<String, String> map : sbtj) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
                for (Map.Entry<String, String> entry : result.entrySet()) {
                    String mapKey = entry.getKey();
                    String mapValue = entry.getValue();
                    int mapValueInt = Integer.parseInt(mapValue);
                    // 离线设备
                    if (mapKey.endsWith("lx")) {
                        sbyc += mapValueInt;
                    }
                    // 在线设备
                    if (mapKey.endsWith("zx")) {
                        sbzx += mapValueInt;
                    }
                    sbzs += mapValueInt;
                }
                result.put("sbzs", String.valueOf(sbzs));
                result.put("sbyc", String.valueOf(sbyc));
                result.put("sbzx", String.valueOf(sbzx));
            }
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult zhdjTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            ResultEntity resultEntity = getDzdwTjResultEntity(params);
            result.put("dzdw", resultEntity);

            Map<String, String> map = new HashMap<>(8);
            map.put("xl", "getDyxlfbTj");
            map.put("nl", "getDynlfbTj");
            map.put("xb", "getDyxbblTj");
            map.put("mz", "getDymzblTj");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult zhzlZdryTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            ResultEntity resultEntity = getZdryrzTjResultEntity(params);
            result.put("zdry", resultEntity);

            Map<String, String> map = new HashMap<>(8);
            map.put("zdryfb", "getZdryfbTj");
            map.put("nl", "getNljgTjByJm");
            map.put("xb", "getXbTjByJm");
            map.put("mz", "getMzTjByJm");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public TableDataInfo searZhsqListByType(SearchEntity searchEntity) {
        int type = searchEntity.getType();
        switch(type){
            case 1:
                tableStrategyContext.setTableStrategy(zhsqLdTableStrategy);
                break;
            case 2:
                tableStrategyContext.setTableStrategy(zhsqFwTableStrategy);
                break;
            case 4:
                tableStrategyContext.setTableStrategy(zhsqClTableStrategy);
                break;
            case 5:
                tableStrategyContext.setTableStrategy(zhsqDzzTableStrategy);
                break;
            case 6:
                tableStrategyContext.setTableStrategy(zhsqDyTableStrategy);
                break;
            case 7: //添加硬件异常信息查询
                tableStrategyContext.setTableStrategy(zhsqYcTableStrategy);
                break;
            default:
                tableStrategyContext.setTableStrategy(zhsqJmTableStrategy);
        }
        TableDataInfo tableDataInfo = tableStrategyContext.handle(searchEntity);
        return tableDataInfo;
    }

    @Override
    public TableDataInfo searchLdList(ZhsqLd zhsqLd) {
        List<ZhsqLd> zhsqLds = zhsqLdService.selectZhsqLdList(zhsqLd);
        List<String> ldids = zhsqLds.stream().map(ZhsqLd::getLdid).collect(Collectors.toList());
        if (ldids != null && ldids.size() > 0) {
            List<ZhsqFw> zhsqFws = zhsqFwService.selectZhsqFwByLdids(ldids);
            Map<String, Map<String, List<ZhsqFw>>> zhsqFwMapList = zhsqFws.stream().collect(Collectors.groupingBy(ZhsqFw::getLdid, Collectors.groupingBy(ZhsqFw::getDy)));
            for (ZhsqLd zhsqLd1 : zhsqLds) {
                String ldid = zhsqLd1.getLdid();
                Map<String, List<ZhsqFw>> zhsqFwListMap = zhsqFwMapList.get(ldid);
                if (zhsqFwListMap != null) {
                    zhsqLd1.setZhsqFwListMap(zhsqFwListMap);
                }
            }
        }
        TableDataInfo tableDataInfo = getDataTable(zhsqLds);
        return tableDataInfo;
    }
}