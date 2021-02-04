package com.feather.community.controller;

import java.util.List;

import com.feather.community.domain.ZhsqShrz;
import com.feather.community.service.IZhsqShrzService;
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
 * 手环日志Controller
 *
 * @author fancy
 * @date 2020-12-14
 */
@Controller
@RequestMapping("/community/SHRZ")
public class ZhsqShrzController extends BaseController
{
    private String prefix = "community/SHRZ";

    @Autowired
    private IZhsqShrzService zhsqShrzService;

    @RequiresPermissions("community:SHRZ:view")
    @GetMapping()
    public String SHRZ()
    {
        return prefix + "/SHRZ";
    }

    /**
     * 查询手环日志列表
     */
    @RequiresPermissions("community:SHRZ:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqShrz zhsqShrz)
    {
        startPage();
        List<ZhsqShrz> list = zhsqShrzService.selectZhsqShrzList(zhsqShrz);
        return getDataTable(list);
    }

    /**
     * 导出手环日志列表
     */
    @RequiresPermissions("community:SHRZ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqShrz zhsqShrz)
    {
        List<ZhsqShrz> list = zhsqShrzService.selectZhsqShrzList(zhsqShrz);
        ExcelUtil<ZhsqShrz> util = new ExcelUtil<ZhsqShrz>(ZhsqShrz.class);
        return util.exportExcel(list, "SHRZ");
    }

    /**
     * 新增手环日志
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqShrz SHRZ = new ZhsqShrz();
        mmap.put("SHRZ", SHRZ);
        return prefix + "/edit";
    }

    /**
     * 新增保存手环日志
     */
    @RequiresPermissions("community:SHRZ:add")
    @Log(title = "手环日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqShrz zhsqShrz)
    {
        return toAjax(zhsqShrzService.insertZhsqShrz(zhsqShrz), zhsqShrz);
    }

    /**
     * 修改手环日志
     */
    @GetMapping("/edit/{SHRZid}")
    public String edit(@PathVariable("SHRZid") String SHRZid, ModelMap mmap)
    {
        ZhsqShrz SHRZ = zhsqShrzService.selectZhsqShrzById(SHRZid);
        mmap.put("SHRZ", SHRZ);
        return prefix + "/edit";
    }

    /**
     * 修改保存手环日志
     */
    @RequiresPermissions("community:SHRZ:edit")
    @Log(title = "手环日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqShrz zhsqShrz)
    {
        return toAjax(zhsqShrzService.updateZhsqShrz(zhsqShrz));
    }

    /**
     * 删除手环日志
     */
    @RequiresPermissions("community:SHRZ:remove")
    @Log(title = "手环日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqShrzService.deleteZhsqShrzByIds(ids));
    }
}