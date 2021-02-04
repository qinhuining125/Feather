package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqDy;
import com.feather.community.service.IZhsqDyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 党员Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/DY")
public class ZhsqDyController extends BaseController {
    private String prefix = "community/DY";

    @Autowired
    private IZhsqDyService zhsqDyService;

    @RequiresPermissions("community:DY:view")
    @GetMapping()
    public String DY() {
        return prefix + "/DY";
    }

    /**
     * 查询党员列表
     */
    @RequiresPermissions("community:DY:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqDy zhsqDy) {
        startPage();
        List<ZhsqDy> list = zhsqDyService.selectZhsqDyList(zhsqDy);
        return getDataTable(list);
    }

    /**
     * 导出党员列表
     */
    @RequiresPermissions("community:DY:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqDy zhsqDy) {
        List<ZhsqDy> list = zhsqDyService.selectZhsqDyList(zhsqDy);
        ExcelUtil<ZhsqDy> util = new ExcelUtil<ZhsqDy>(ZhsqDy.class);
        return util.exportExcel(list, "DY");
    }

    /**
     * 新增党员
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqDy DY = new ZhsqDy();
        mmap.put("DY", DY);
        return prefix + "/add";
    }

    /**
     * 新增保存党员
     */
    @RequiresPermissions("community:DY:add")
    @Log(title = "党员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqDy zhsqDy) {
        return toAjax(zhsqDyService.insertZhsqDy(zhsqDy), zhsqDy);
    }

    /**
     * 修改党员
     */
    @GetMapping("/edit/{dzzid}")
    public String edit(@PathVariable("dzzid") String dzzid, ModelMap mmap) {
        ZhsqDy DY = zhsqDyService.selectZhsqDyById(dzzid);
        mmap.put("DY", DY);
        return prefix + "/edit";
    }

    /**
     * 修改保存党员
     */
    @RequiresPermissions("community:DY:edit")
    @Log(title = "党员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqDy zhsqDy) {
        return toAjax(zhsqDyService.updateZhsqDy(zhsqDy), zhsqDy);
    }

    /**
     * 删除党员
     */
    @RequiresPermissions("community:DY:remove")
    @Log(title = "党员", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqDyService.deleteZhsqDyByIds(ids));
    }
}