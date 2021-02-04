package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqYg;
import com.feather.community.service.IZhsqYgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 烟感Controller
 *
 * @author fancy
 * @date 2020-12-10
 */
@Controller
@RequestMapping("/community/YG")
public class ZhsqYgController extends BaseController
{
    private String prefix = "community/YG";

    @Autowired
    private IZhsqYgService zhsqYgService;

    @RequiresPermissions("community:YG:view")
    @GetMapping()
    public String YG()
    {
        return prefix + "/YG";
    }

    /**
     * 查询烟感列表
     */
    @RequiresPermissions("community:YG:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqYg zhsqYg)
    {
        startPage();
        List<ZhsqYg> list = zhsqYgService.selectZhsqYgList(zhsqYg);
        return getDataTable(list);
    }

    /**
     * 导出烟感列表
     */
    @RequiresPermissions("community:YG:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqYg zhsqYg)
    {
        List<ZhsqYg> list = zhsqYgService.selectZhsqYgList(zhsqYg);
        ExcelUtil<ZhsqYg> util = new ExcelUtil<ZhsqYg>(ZhsqYg.class);
        return util.exportExcel(list, "YG");
    }

    /**
     * 新增烟感
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqYg YG = new ZhsqYg();
        mmap.put("YG", YG);
        return prefix + "/edit";
    }

    /**
     * 新增保存烟感
     */
    @RequiresPermissions("community:YG:add")
    @Log(title = "烟感", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqYg zhsqYg)
    {
        zhsqYg.setYgid(zhsqYg.getYgid().replace(",",""));
        return toAjax(zhsqYgService.insertZhsqYg(zhsqYg), zhsqYg);
    }

    /**
     * 修改烟感
     */
    @GetMapping("/edit/{ygid}")
    public String edit(@PathVariable("ygid") String ygid, ModelMap mmap)
    {
        ZhsqYg YG = zhsqYgService.selectZhsqYgById(ygid);
        mmap.put("YG", YG);
        return prefix + "/edit";
    }

    /**
     * 修改保存烟感
     */
    @RequiresPermissions("community:YG:edit")
    @Log(title = "烟感", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqYg zhsqYg)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+zhsqYg.toString());
        zhsqYg.setYgid(zhsqYg.getYgid().split(",")[0]);
        return toAjax(zhsqYgService.updateZhsqYg(zhsqYg));
    }

    /**
     * 删除烟感
     */
    @RequiresPermissions("community:YG:remove")
    @Log(title = "烟感", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqYgService.deleteZhsqYgByIds(ids));
    }
}