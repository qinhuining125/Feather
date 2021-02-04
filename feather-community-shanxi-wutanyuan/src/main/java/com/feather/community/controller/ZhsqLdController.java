package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.config.UidWorker;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqLd;
import com.feather.community.service.IZhsqLdService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 楼栋Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/LD")
public class ZhsqLdController extends BaseController {
    private String prefix = "community/LD";

    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private IZhsqLdService zhsqLdService;

    @RequiresPermissions("community:LD:view")
    @GetMapping()
    public String LD() {
        return prefix + "/LD";
    }

    /**
     * 查询楼栋列表
     */
    @RequiresPermissions("community:LD:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqLd zhsqLd) {
        startPage();
        List<ZhsqLd> list = zhsqLdService.selectZhsqLdList(zhsqLd);
        return getDataTable(list);
    }

    /**
     * 导出楼栋列表
     */
    @RequiresPermissions("community:LD:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqLd zhsqLd) {
        List<ZhsqLd> list = zhsqLdService.selectZhsqLdList(zhsqLd);
        ExcelUtil<ZhsqLd> util = new ExcelUtil<ZhsqLd>(ZhsqLd.class);
        return util.exportExcel(list, "LD");
    }

    /**
     * 新增楼栋
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqLd LD = new ZhsqLd();
        mmap.put("LD", LD);
        return prefix + "/edit";
    }

    /**
     * 新增保存楼栋
     */
    @RequiresPermissions("community:LD:add")
    @Log(title = "楼栋", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqLd zhsqLd) {
        String ldid = "LD" + uidWorker.getNextId();
        zhsqLd.setLdid(ldid);
        return toAjax(zhsqLdService.insertZhsqLd(zhsqLd), zhsqLd);
    }

    /**
     * 修改楼栋
     */
    @GetMapping("/edit/{ldid}")
    public String edit(@PathVariable("ldid") String ldid, ModelMap mmap) {
        ZhsqLd LD = zhsqLdService.selectZhsqLdById(ldid);
        mmap.put("LD", LD);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼栋
     */
    @RequiresPermissions("community:LD:edit")
    @Log(title = "楼栋", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqLd zhsqLd) {
        return toAjax(zhsqLdService.updateZhsqLd(zhsqLd), zhsqLd);
    }

    /**
     * 删除楼栋
     */
    @RequiresPermissions("community:LD:remove")
    @Log(title = "楼栋", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqLdService.deleteZhsqLdByIds(ids));
    }

    // @GetMapping( "/rzl")
    // @ResponseBody
    // public AjaxResult queryRzlCount(@Param("xqid") String xqid,@Param("sqid")
    // String sqid){
    // Map<String,Object> maps = new HashMap<>();
    // maps.put("xqid",xqid);
    // maps.put("sqid",sqid);
    // return AjaxResult.success(zhsqFwService.selectRzlCount(maps));
    // }
    //
    // @GetMapping( "/tj")
    // @ResponseBody
    // public AjaxResult queryTjCount(@Param("xqid") String xqid,@Param("sqid")
    // String sqid){
    // Map<String,Object> maps = new HashMap<>();
    // maps.put("xqid",xqid);
    // maps.put("sqid",sqid);
    // return AjaxResult.success(zhsqFwService.selectTjCount(maps));
    // }
}