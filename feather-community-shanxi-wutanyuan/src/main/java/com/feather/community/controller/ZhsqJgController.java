package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqJg;
import com.feather.community.service.IZhsqJgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 井盖Controller
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Controller
@RequestMapping("/community/JG")
public class ZhsqJgController extends BaseController
{
    private String prefix = "community/JG";

    @Autowired
    private IZhsqJgService zhsqJgService;

    @RequiresPermissions("community:JG:view")
    @GetMapping()
    public String JG()
    {
        return prefix + "/JG";
    }

    /**
     * 查询井盖列表
     */
    @RequiresPermissions("community:JG:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqJg zhsqJg)
    {
        startPage();
        List<ZhsqJg> list = zhsqJgService.selectZhsqJgList(zhsqJg);
        return getDataTable(list);
    }

    /**
     * 导出井盖列表
     */
    @RequiresPermissions("community:JG:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqJg zhsqJg)
    {
        List<ZhsqJg> list = zhsqJgService.selectZhsqJgList(zhsqJg);
        ExcelUtil<ZhsqJg> util = new ExcelUtil<ZhsqJg>(ZhsqJg.class);
        return util.exportExcel(list, "JG");
    }

    /**
     * 新增井盖
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqJg JG = new ZhsqJg();
        mmap.put("JG", JG);
        return prefix + "/edit";
    }

    /**
     * 新增保存井盖
     */
    @RequiresPermissions("community:JG:add")
    @Log(title = "井盖", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqJg zhsqJg)
    {
        zhsqJg.setJgid(zhsqJg.getJgid().replace(",",""));
        return toAjax(zhsqJgService.insertZhsqJg(zhsqJg), zhsqJg);
    }

    /**
     * 修改井盖
     */
    @GetMapping("/edit/{jgid}")
    public String edit(@PathVariable("jgid") String jgid, ModelMap mmap)
    {
        ZhsqJg JG = zhsqJgService.selectZhsqJgById(jgid);
        mmap.put("JG", JG);
        return prefix + "/edit";
    }

    /**
     * 修改保存井盖
     */
    @RequiresPermissions("community:JG:edit")
    @Log(title = "井盖", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqJg zhsqJg)
    {
        System.out.println(zhsqJg.toString());

        zhsqJg.setJgid(zhsqJg.getJgid().split(",")[0]);
        return toAjax(zhsqJgService.updateZhsqJg(zhsqJg));
    }

    /**
     * 删除井盖
     */
    @RequiresPermissions("community:JG:remove")
    @Log(title = "井盖", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqJgService.deleteZhsqJgByIds(ids));
    }
}
