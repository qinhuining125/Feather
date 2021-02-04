package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqSxt;
import com.feather.community.service.IZhsqSxtService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 摄像头Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/SXT")
public class ZhsqSxtController extends BaseController {
    private String prefix = "community/SXT";

    @Autowired
    private IZhsqSxtService zhsqSxtService;

    @RequiresPermissions("community:SXT:view")
    @GetMapping()
    public String SXT() {
        return prefix + "/SXT";
    }

    /**
     * 查询摄像头列表
     */
    @RequiresPermissions("community:SXT:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqSxt zhsqSxt) {
        startPage();
        List<ZhsqSxt> list = zhsqSxtService.selectZhsqSxtList(zhsqSxt);
        return getDataTable(list);
    }

    /**
     * 导出摄像头列表
     */
    @RequiresPermissions("community:SXT:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqSxt zhsqSxt) {
        List<ZhsqSxt> list = zhsqSxtService.selectZhsqSxtList(zhsqSxt);
        ExcelUtil<ZhsqSxt> util = new ExcelUtil<ZhsqSxt>(ZhsqSxt.class);
        return util.exportExcel(list, "SXT");
    }

    /**
     * 新增摄像头
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqSxt SXT = new ZhsqSxt();
        mmap.put("SXT", SXT);
        return prefix + "/add";
    }

    /**
     * 新增保存摄像头
     */
    @RequiresPermissions("community:SXT:add")
    @Log(title = "摄像头", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqSxt zhsqSxt) {
        return toAjax(zhsqSxtService.insertZhsqSxt(zhsqSxt), zhsqSxt);
    }

    /**
     * 修改摄像头
     */
    @GetMapping("/edit/{sxtid}")
    public String edit(@PathVariable("sxtid") String sxtid, ModelMap mmap) {
        ZhsqSxt SXT = zhsqSxtService.selectZhsqSxtById(sxtid);
        mmap.put("SXT", SXT);
        return prefix + "/edit";
    }

    /**
     * 修改保存摄像头
     */
    @RequiresPermissions("community:SXT:edit")
    @Log(title = "摄像头", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqSxt zhsqSxt) {
        return toAjax(zhsqSxtService.updateZhsqSxt(zhsqSxt), zhsqSxt);
    }

    /**
     * 删除摄像头
     */
    @RequiresPermissions("community:SXT:remove")
    @Log(title = "摄像头", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqSxtService.deleteZhsqSxtByIds(ids));
    }
}