package com.feather.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feather.common.annotation.ClearPage;
import com.feather.community.domain.*;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.*;
import com.feather.community.util.MyTableDataInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;

import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/screen")
public class ScreenIndexController extends BaseController {

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
    IZhsqFwService zhsqFwService;
    @Autowired
    IZhsqCwService zhsqCwService;
    @Autowired
    IZhsqSxtService zhsqSxtService;
    @Autowired
    IScreenIndexService screenIndexServie;

    @GetMapping()
    public String index() {
        return "redirect:/bus/community/index.html";
    }

    @RequestMapping("/api/getPersonInfo")
    @ResponseBody
    public AjaxResult getPersonInfo(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqJmService.getPersonInfo(maps));
    }

    @RequestMapping("/api/getSuggestionList")
    @ResponseBody
    public AjaxResult getSuggestionList(String sqid, String xqid) {
        return AjaxResult.success(zhsqTsjyService.getSuggestionList(sqid, xqid));
    }

    @RequestMapping("/api/getSourceCount")
    @ResponseBody
    public AjaxResult getSourceCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqYcService.getSourceCount(sqid, xqid));
    }

    @RequestMapping("/api/getStatusCount")
    @ResponseBody
    public AjaxResult getStatusCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqYcService.getStatusCount(sqid, xqid));
    }

    // 通知公告
    @RequestMapping("/api/getAdviceList")
    @ResponseBody
    public TableDataInfo getAdviceList(String sqid, String xqid) {
        startPage();
        List<ZhsqGg> list = zhsqGgService.getZhsqGgList(sqid, xqid);
        return getDataTable(list);
    }

    // 查询设备
    @RequestMapping("/api/getSbJc")
    @ResponseBody
    public AjaxResult getSbJc(String type, String id) {
        if (type.equals("YC")) {
            ZhsqYc zhsqYc = zhsqYcService.selectZhsqYcById(id);
            return AjaxResult.success(zhsqYc);
        }
        List<Map> map = zhsqZcService.getSbJc(type, id);
        return AjaxResult.success(map);
    }

    // 查询房屋
    @RequestMapping("/api/getRyXx")
    @ResponseBody
    public AjaxResult getJmXx(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        Map<String, Object> map = zhsqFwService.getFwXx(maps);
        return AjaxResult.success(map);
    }

    // 查询人员
    @RequestMapping("/api/getFwRy")
    @ResponseBody
    public AjaxResult getFwRy(@Param("fwid") String fwid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("fwid", fwid);
        List<Map<String, Object>> map = zhsqJmService.getFwRy(maps);
        return AjaxResult.success(map);
    }

    /**
     * 查询重点人员信息
     */
    @RequestMapping("/api/getZdryTjByJm")
    @ResponseBody
    public AjaxResult getZdryTjByJm(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        AjaxResult result = zhsqJmService.getZdryTj(maps);
        return result;
    }

    @RequestMapping("/api/getSqgkTj")
    @ResponseBody
    public AjaxResult getSqkgTj(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        AjaxResult result = zhsqJmService.getSqgkTj(maps);
        return result;
    }

    /**
     * 查询重点人员楼栋信息
     */
    @RequestMapping("/api/getZdRyLd")
    @ResponseBody
    public AjaxResult getZdRyLd() {
        List<Map<String, Object>> map = zhsqJmService.getZdRyLd();
        return AjaxResult.success(map);
    }

    // 查询设备在线统计
    @RequestMapping("/api/getSbxxCount")
    @ResponseBody
    public AjaxResult getSbxxCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqZcService.getSbxxCount(sqid, xqid));
    }

    // 查询重点人员楼栋信息
    @RequestMapping("/api/getSqCwXx")
    @ResponseBody
    public AjaxResult getSqCwXx(@Param("name") String name, ZhsqCw zhsqCw) {
        if (name != null) {
            zhsqCw.setTccmc(name);
        }
        if (name.equals("七宝社区")) {
            zhsqCw.setSqid(zhsqCw.getXqid());
            zhsqCw.setXqid("");
        }
        Map<String, Object> map = zhsqCwService.getSqCwXx(zhsqCw);
        return AjaxResult.success(map);
    }

    // 查询房屋入住率
    @GetMapping("/api/rzl")
    @ResponseBody
    public AjaxResult queryRzlCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqFwService.selectRzlCount(maps));
    }

    // 房屋统计
    @GetMapping("/api/tj")
    @ResponseBody
    public AjaxResult queryTjCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqFwService.selectTjCount(maps));
    }

    @RequestMapping("/api/getSxtTj")
    @ResponseBody
    public AjaxResult getSxtTj() {
        Map<String, Object> maps = new HashMap<>(8);
        AjaxResult result = zhsqSxtService.getSxtTj(maps);
        return result;
    }

    /**
     * 是否常驻人口统计
     */
    @RequestMapping("/api/getSfczTjByJm")
    @ResponseBody
    public AjaxResult getSfczTjByJm() {
        Map<String, Object> maps = new HashMap<>(8);
        AjaxResult result = screenIndexServie.getSfczTj(maps);
        return result;
    }

    /**
     * 获取摄像头分页信息
     *
     * @param zhsqSxt
     * @return
     */
    @RequestMapping("/api/getSxtList")
    @ClearPage
    @ResponseBody
    public TableDataInfo getSxtList(ZhsqSxt zhsqSxt) {
        startPage();
        List<ZhsqSxt> list = zhsqSxtService.selectZhsqSxtList(zhsqSxt);
        return getDataTable(list);
    }

    /**
     * 获取居民详情
     *
     * @param jmid
     * @return
     */
    @RequestMapping("/api/getJmById")
    @ResponseBody
    public AjaxResult getJmById(@Param("jmid") String jmid) {
        return zhsqJmService.getZhsqJmById(jmid);
    }

    @RequestMapping("/api/sqglJmTj")
    @ResponseBody
    public AjaxResult sqglJmTj() {
        Map<String, Object> params = new HashMap<>(8);
        return screenIndexServie.sqglJmTj(params);
    }

    /**
     * 智慧党建统计
     *
     * @return
     */
    @RequestMapping("/api/zhdjTj")
    @ResponseBody
    public AjaxResult zhdjTj() {
        Map<String, Object> params = new HashMap<>(8);
        return screenIndexServie.zhdjTj(params);
    }

    /**
     * 社区管理（设备统计）
     *
     * @return
     */
    @RequestMapping("/api/sqglSbTj")
    @ResponseBody
    public AjaxResult sqglSbTj() {
        return screenIndexServie.sqglSbTj();
    }


    /**
     * 社区管理（房屋统计）
     *
     * @return
     */
    @RequestMapping("/api/sqglFwTj")
    @ResponseBody
    public AjaxResult sqglFwTj() {
        return screenIndexServie.sqglFwTj();
    }

    /**
     * 综合治理重点人员统计
     *
     * @return
     */
    @RequestMapping("/api/zhzlZdryTj")
    @ResponseBody
    public AjaxResult zhzlZdryTj() {
        Map<String, Object> params = new HashMap<>(8);
        params.put("sfdj", "是");
        params.put("sfkc", "是");
        params.put("sfxmsf", "是");
        params.put("sftyjr", "是");
        params.put("sfdb", "是");
        params.put("sfcj", "是");
        return screenIndexServie.zhzlZdryTj(params);
    }

    /**
     * 获取居民列表
     *
     * @param zhsqJm
     * @return
     */
    @RequestMapping("/api/getJmList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo getJmList(ZhsqJm zhsqJm) {
        startPage();
        List<ZhsqJm> list = zhsqJmService.selectZhsqJmList(zhsqJm);
        TableDataInfo tableDataInfo = getDataTable(list);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    /**
     * 获取房屋列表
     *
     * @param zhsqFw
     * @return
     */
    @RequestMapping("/api/getFwList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo getFwList(ZhsqFw zhsqFw) {
        startPage();
        List<ZhsqFw> list = zhsqFwService.selectZhsqFwList(zhsqFw);
        TableDataInfo tableDataInfo = getDataTable(list);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    @RequestMapping("/api/searchJmList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searchJmList(SearchEntity searchEntity) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searZhsqListByType(searchEntity);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    /**
     * 首页查询汇总，type=3表示为对居民信息的查询，数据库现在数据一共为：652条
     * 1.3号楼假居民数据为66条。
     * 2.'JM000646','JM000647'有两条数据为流动人员，测试数据，假造的3号楼的数据。
     *
     *
     * */
    @RequestMapping("/api/searZhsqListByType")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searZhsqListByType(SearchEntity searchEntity) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searZhsqListByType(searchEntity);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    @RequestMapping("/api/searchLdList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searchLdList(ZhsqLd zhsqLd) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searchLdList(zhsqLd);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }
}
