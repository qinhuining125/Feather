package com.feather.community.controller;

import java.util.List;

import com.feather.community.domain.ZhsqSh;
import com.feather.community.service.IZhsqShService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.enums.BusinessType;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 手环Controller
 *
 * @author fancy
 * @date 2020-12-14
 */
@Controller
@RequestMapping("/community/SH")
public class ZhsqShController extends BaseController
{
    private String prefix = "community/SH";

    @Autowired
    private IZhsqShService zhsqShService;

    @RequiresPermissions("community:SH:view")
    @GetMapping()
    public String sh()
    {
        return prefix + "/SH";
    }

    /**
     * 查询手环列表
     */
    @RequiresPermissions("community:SH:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqSh zhsqSh)
    {
        startPage();
        List<ZhsqSh> list = zhsqShService.selectZhsqShList(zhsqSh);
        return getDataTable(list);
    }

    /**
     * 导出手环列表
     */
    @RequiresPermissions("community:SH:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqSh zhsqSh)
    {
        List<ZhsqSh> list = zhsqShService.selectZhsqShList(zhsqSh);
        ExcelUtil<ZhsqSh> util = new ExcelUtil<ZhsqSh>(ZhsqSh.class);
        return util.exportExcel(list, "SH");
    }

    /**
     * 新增手环
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqSh SH = new ZhsqSh();
        mmap.put("SH", SH);
        return prefix + "/edit";
    }

    /**
     * 新增保存手环
     */
    @RequiresPermissions("community:SH:add")
    @Log(title = "手环", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqSh zhsqSh)
    {
        return toAjax(zhsqShService.insertZhsqSh(zhsqSh), zhsqSh);
    }

    /**
     * 修改手环
     */
    @GetMapping("/edit/{shid}")
    public String edit(@PathVariable("shid") String shid, ModelMap mmap)
    {
        ZhsqSh SH = zhsqShService.selectZhsqShById(shid);
        mmap.put("SH", SH);
        return prefix + "/edit";
    }

    /**
     * 修改保存手环
     */
    @RequiresPermissions("community:SH:edit")
    @Log(title = "手环", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqSh zhsqSh)
    {
        return toAjax(zhsqShService.updateZhsqSh(zhsqSh));
    }

    /**
     * 删除手环
     */
    @RequiresPermissions("community:SH:remove")
    @Log(title = "手环", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqShService.deleteZhsqShByIds(ids));
    }
}