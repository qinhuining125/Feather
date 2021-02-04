package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqZj;
import com.feather.community.service.IZhsqZjService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 闸机Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/ZJ")
public class ZhsqZjController extends BaseController {
    private String prefix = "community/ZJ";

    @Autowired
    private IZhsqZjService zhsqZjService;

    @RequiresPermissions("community:ZJ:view")
    @GetMapping()
    public String ZJ() {
        return prefix + "/ZJ";
    }

    /**
     * 查询闸机列表
     */
    @RequiresPermissions("community:ZJ:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqZj zhsqZj) {
        startPage();
        List<ZhsqZj> list = zhsqZjService.selectZhsqZjList(zhsqZj);
        return getDataTable(list);
    }

    /**
     * 导出闸机列表
     */
    @RequiresPermissions("community:ZJ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqZj zhsqZj) {
        List<ZhsqZj> list = zhsqZjService.selectZhsqZjList(zhsqZj);
        ExcelUtil<ZhsqZj> util = new ExcelUtil<ZhsqZj>(ZhsqZj.class);
        return util.exportExcel(list, "ZJ");
    }

    /**
     * 新增闸机
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqZj ZJ = new ZhsqZj();
        mmap.put("ZJ", ZJ);
        return prefix + "/add";
    }

    /**
     * 新增保存闸机
     */
    @RequiresPermissions("community:ZJ:add")
    @Log(title = "闸机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqZj zhsqZj) {
        return toAjax(zhsqZjService.insertZhsqZj(zhsqZj), zhsqZj);
    }

    /**
     * 修改闸机
     */
    @GetMapping("/edit/{zjid}")
    public String edit(@PathVariable("zjid") String zjid, ModelMap mmap) {
        ZhsqZj ZJ = zhsqZjService.selectZhsqZjById(zjid);
        mmap.put("ZJ", ZJ);
        return prefix + "/edit";
    }

    /**
     * 修改保存闸机
     */
    @RequiresPermissions("community:ZJ:edit")
    @Log(title = "闸机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqZj zhsqZj) {
        return toAjax(zhsqZjService.updateZhsqZj(zhsqZj), zhsqZj);
    }

    /**
     * 删除闸机
     */
    @RequiresPermissions("community:ZJ:remove")
    @Log(title = "闸机", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqZjService.deleteZhsqZjByIds(ids));
    }
}