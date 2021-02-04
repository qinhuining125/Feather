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
import com.feather.community.domain.ZhsqSbrz;
import com.feather.community.service.IZhsqSbrzService;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 水表日志Controller
 * 
 * @author qhn
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/community/sbrz")
public class ZhsqSbrzController extends BaseController
{
    private String prefix = "community/sbrz";

    @Autowired
    private IZhsqSbrzService zhsqSbrzService;

    @RequiresPermissions("community:sbrz:view")
    @GetMapping()
    public String sbrz()
    {
        return prefix + "/sbrz";
    }

    /**
     * 查询水表日志列表
     */
    @RequiresPermissions("community:sbrz:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqSbrz zhsqSbrz)
    {
        startPage();
        List<ZhsqSbrz> list = zhsqSbrzService.selectZhsqSbrzList(zhsqSbrz);
        return getDataTable(list);
    }

    /**
     * 查询水表日志列表
     */
//    @RequiresPermissions("community:sbrz:get5DayData")
    @GetMapping("/get5DayData")
    public List<ZhsqSbrz> get5DayData()
    {
        List<ZhsqSbrz> list = zhsqSbrzService.get5DayData();
        return list;
//        return getDataTable(list);
    }
    /**
     * 导出水表日志列表
     */
    @RequiresPermissions("community:sbrz:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqSbrz zhsqSbrz)
    {
        List<ZhsqSbrz> list = zhsqSbrzService.selectZhsqSbrzList(zhsqSbrz);
        ExcelUtil<ZhsqSbrz> util = new ExcelUtil<ZhsqSbrz>(ZhsqSbrz.class);
        return util.exportExcel(list, "sbrz");
    }

    /**
     * 新增水表日志
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqSbrz sbrz = new ZhsqSbrz();
        mmap.put("sbrz", sbrz);
        return prefix + "/edit";
    }

    /**
     * 新增保存水表日志
     */
    @RequiresPermissions("community:sbrz:add")
    @Log(title = "水表日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqSbrz zhsqSbrz)
    {
        System.out.println(zhsqSbrz);
        return toAjax(zhsqSbrzService.insertZhsqSbrz(zhsqSbrz), zhsqSbrz);
    }


    /**
     * 新增保存水表日志
     */
    @Log(title = "水表日志", businessType = BusinessType.INSERT)
    @PostMapping("/data")
    public AjaxResult dataSave(ZhsqSbrz zhsqSbrz)
    {
        System.out.println(zhsqSbrz);
        return toAjax(zhsqSbrzService.insertZhsqSbrz(zhsqSbrz), zhsqSbrz);
    }


    /**
     * 修改水表日志
     */
    @GetMapping("/edit/{sbrzid}")
    public String edit(@PathVariable("sbrzid") String sbrzid, ModelMap mmap)
    {
        ZhsqSbrz sbrz = zhsqSbrzService.selectZhsqSbrzById(sbrzid);
        mmap.put("sbrz", sbrz);
        return prefix + "/edit";
    }

    /**
     * 修改保存水表日志
     */
    @RequiresPermissions("community:sbrz:edit")
    @Log(title = "水表日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqSbrz zhsqSbrz)
    {
        return toAjax(zhsqSbrzService.updateZhsqSbrz(zhsqSbrz));
    }

    /**
     * 删除水表日志
     */
    @RequiresPermissions("community:sbrz:remove")
    @Log(title = "水表日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqSbrzService.deleteZhsqSbrzByIds(ids));
    }
}
