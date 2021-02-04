package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqDzz;
import com.feather.community.service.IZhsqDzzService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 党组织Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/DZZ")
public class ZhsqDzzController extends BaseController {
    private String prefix = "community/DZZ";

    @Autowired
    private IZhsqDzzService zhsqDzzService;

    @RequiresPermissions("community:DZZ:view")
    @GetMapping()
    public String DZZ() {
        return prefix + "/DZZ";
    }

    /**
     * 查询党组织列表
     */
    @RequiresPermissions("community:DZZ:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqDzz zhsqDzz) {
        startPage();
        List<ZhsqDzz> list = zhsqDzzService.selectZhsqDzzList(zhsqDzz);
        return getDataTable(list);
    }

    /**
     * 导出党组织列表
     */
    @RequiresPermissions("community:DZZ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqDzz zhsqDzz) {
        List<ZhsqDzz> list = zhsqDzzService.selectZhsqDzzList(zhsqDzz);
        ExcelUtil<ZhsqDzz> util = new ExcelUtil<ZhsqDzz>(ZhsqDzz.class);
        return util.exportExcel(list, "DZZ");
    }

    /**
     * 新增党组织
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqDzz DZZ = new ZhsqDzz();
        mmap.put("DZZ", DZZ);
        return prefix + "/add";
    }

    /**
     * 新增保存党组织
     */
    @RequiresPermissions("community:DZZ:add")
    @Log(title = "党组织", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqDzz zhsqDzz) {
        return toAjax(zhsqDzzService.insertZhsqDzz(zhsqDzz), zhsqDzz);
    }

    /**
     * 修改党组织
     */
    @GetMapping("/edit/{dzzid}")
    public String edit(@PathVariable("dzzid") String dzzid, ModelMap mmap) {
        ZhsqDzz DZZ = zhsqDzzService.selectZhsqDzzById(dzzid);
        mmap.put("DZZ", DZZ);
        return prefix + "/edit";
    }

    /**
     * 修改保存党组织
     */
    @RequiresPermissions("community:DZZ:edit")
    @Log(title = "党组织", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqDzz zhsqDzz) {
        return toAjax(zhsqDzzService.updateZhsqDzz(zhsqDzz), zhsqDzz);
    }

    /**
     * 删除党组织
     */
    @RequiresPermissions("community:DZZ:remove")
    @Log(title = "党组织", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqDzzService.deleteZhsqDzzByIds(ids));
    }
}