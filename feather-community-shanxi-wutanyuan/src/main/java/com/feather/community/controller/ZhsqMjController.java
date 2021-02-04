package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqMj;
import com.feather.community.service.IZhsqMjService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门禁Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/MJ")
public class ZhsqMjController extends BaseController {
    private String prefix = "community/MJ";

    @Autowired
    private IZhsqMjService zhsqMjService;

    @RequiresPermissions("community:MJ:view")
    @GetMapping()
    public String MJ() {
        return prefix + "/MJ";
    }

    /**
     * 查询门禁列表
     */
    @RequiresPermissions("community:MJ:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqMj zhsqMj) {
        startPage();
        List<ZhsqMj> list = zhsqMjService.selectZhsqMjList(zhsqMj);
        return getDataTable(list);
    }

    /**
     * 导出门禁列表
     */
    @RequiresPermissions("community:MJ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqMj zhsqMj) {
        List<ZhsqMj> list = zhsqMjService.selectZhsqMjList(zhsqMj);
        ExcelUtil<ZhsqMj> util = new ExcelUtil<ZhsqMj>(ZhsqMj.class);
        return util.exportExcel(list, "MJ");
    }

    /**
     * 新增门禁
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqMj MJ = new ZhsqMj();
        mmap.put("MJ", MJ);
        return prefix + "/add";
    }

    /**
     * 新增保存门禁
     */
    @RequiresPermissions("community:MJ:add")
    @Log(title = "门禁", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqMj zhsqMj) {
        return toAjax(zhsqMjService.insertZhsqMj(zhsqMj), zhsqMj);
    }

    /**
     * 修改门禁
     */
    @GetMapping("/edit/{mjid}")
    public String edit(@PathVariable("mjid") String mjid, ModelMap mmap) {
        ZhsqMj MJ = zhsqMjService.selectZhsqMjById(mjid);
        mmap.put("MJ", MJ);
        return prefix + "/edit";
    }

    /**
     * 修改保存门禁
     */
    @RequiresPermissions("community:MJ:edit")
    @Log(title = "门禁", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqMj zhsqMj) {
        return toAjax(zhsqMjService.updateZhsqMj(zhsqMj), zhsqMj);
    }

    /**
     * 删除门禁
     */
    @RequiresPermissions("community:MJ:remove")
    @Log(title = "门禁", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqMjService.deleteZhsqMjByIds(ids));
    }
}