package com.feather.community.controller;

import java.util.List;
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
import com.feather.community.domain.ZhsqYgrz;
import com.feather.community.service.IZhsqYgrzService;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 烟感日志Controller
 * 
 * @author qhn
 * @date 2021-01-08
 */
@Controller
@RequestMapping("/community/ygrz")
public class ZhsqYgrzController extends BaseController
{
    private String prefix = "community/ygrz";

    @Autowired
    private IZhsqYgrzService zhsqYgrzService;

    @RequiresPermissions("community:ygrz:view")
    @GetMapping()
    public String ygrz()
    {
        return prefix + "/ygrz";
    }

    /**
     * 查询烟感日志列表
     */
    @RequiresPermissions("community:ygrz:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqYgrz zhsqYgrz)
    {
        startPage();
        List<ZhsqYgrz> list = zhsqYgrzService.selectZhsqYgrzList(zhsqYgrz);
        return getDataTable(list);
    }

    /**
     * 导出烟感日志列表
     */
    @RequiresPermissions("community:ygrz:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqYgrz zhsqYgrz)
    {
        List<ZhsqYgrz> list = zhsqYgrzService.selectZhsqYgrzList(zhsqYgrz);
        ExcelUtil<ZhsqYgrz> util = new ExcelUtil<ZhsqYgrz>(ZhsqYgrz.class);
        return util.exportExcel(list, "ygrz");
    }

    /**
     * 新增烟感日志
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqYgrz ygrz = new ZhsqYgrz();
        mmap.put("ygrz", ygrz);
        return prefix + "/edit";
    }

    /**
     * 新增保存烟感日志
     */
    @RequiresPermissions("community:ygrz:add")
    @Log(title = "烟感日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqYgrz zhsqYgrz)
    {
        return toAjax(zhsqYgrzService.insertZhsqYgrz(zhsqYgrz), zhsqYgrz);
    }

    /**
     * 修改烟感日志
     */
    @GetMapping("/edit/{sbrzid}")
    public String edit(@PathVariable("sbrzid") String sbrzid, ModelMap mmap)
    {
        ZhsqYgrz ygrz = zhsqYgrzService.selectZhsqYgrzById(sbrzid);
        mmap.put("ygrz", ygrz);
        return prefix + "/edit";
    }

    /**
     * 修改保存烟感日志
     */
    @RequiresPermissions("community:ygrz:edit")
    @Log(title = "烟感日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqYgrz zhsqYgrz)
    {
        return toAjax(zhsqYgrzService.updateZhsqYgrz(zhsqYgrz));
    }

    /**
     * 删除烟感日志
     */
    @RequiresPermissions("community:ygrz:remove")
    @Log(title = "烟感日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqYgrzService.deleteZhsqYgrzByIds(ids));
    }
}
