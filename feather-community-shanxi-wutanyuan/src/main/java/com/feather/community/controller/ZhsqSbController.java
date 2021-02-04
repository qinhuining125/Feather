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
import com.feather.community.domain.ZhsqSb;
import com.feather.community.service.IZhsqSbService;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 水表Controller
 *
 * @author qhn
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/community/sb")
public class ZhsqSbController extends BaseController
{
    private String prefix = "community/sb";

    @Autowired
    private IZhsqSbService zhsqSbService;

    @RequiresPermissions("community:sb:view")
    @GetMapping()
    public String sb()
    {
        return prefix + "/sb";
    }

    /**
     * 查询水表列表
     */
    @RequiresPermissions("community:sb:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqSb zhsqSb)
    {
        startPage();
        List<ZhsqSb> list = zhsqSbService.selectZhsqSbList(zhsqSb);
        return getDataTable(list);
    }

    /**
     * 导出水表列表
     */
    @RequiresPermissions("community:sb:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqSb zhsqSb)
    {
        List<ZhsqSb> list = zhsqSbService.selectZhsqSbList(zhsqSb);
        ExcelUtil<ZhsqSb> util = new ExcelUtil<ZhsqSb>(ZhsqSb.class);
        return util.exportExcel(list, "sb");
    }

    /**
     * 新增水表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqSb sb = new ZhsqSb();
        mmap.put("sb", sb);
        return prefix + "/edit";
    }

    /**
     * 新增保存水表
     */
    @RequiresPermissions("community:sb:add")
    @Log(title = "水表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqSb zhsqSb)
    {
        return toAjax(zhsqSbService.insertZhsqSb(zhsqSb), zhsqSb);
    }

    /**
     * 修改水表
     */
    @GetMapping("/edit/{deviceCode}")
    public String edit(@PathVariable("deviceCode") String deviceCode, ModelMap mmap)
    {
        ZhsqSb sb = zhsqSbService.selectZhsqSbById(deviceCode);
        mmap.put("sb", sb);
        return prefix + "/edit";
    }

    /**
     * 修改保存水表
     */
    @RequiresPermissions("community:sb:edit")
    @Log(title = "水表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqSb zhsqSb)
    {
        return toAjax(zhsqSbService.updateZhsqSb(zhsqSb));
    }

    /**
     * 删除水表
     */
    @RequiresPermissions("community:sb:remove")
    @Log(title = "水表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqSbService.deleteZhsqSbByIds(ids));
    }
}