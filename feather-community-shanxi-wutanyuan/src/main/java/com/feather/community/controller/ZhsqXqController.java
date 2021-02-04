package com.feather.community.controller;

import com.feather.common.annotation.Log;
import com.feather.common.config.UidWorker;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqXq;
import com.feather.community.service.IZhsqXqService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小区Controller
 *
 * @author fancy
 * @date 2020-05-15
 */
@Controller
@RequestMapping("/community/XQ")
public class ZhsqXqController extends BaseController {
    private String prefix = "community/XQ";

    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private IZhsqXqService zhsqXqService;

    @RequiresPermissions("community:XQ:view")
    @GetMapping()
    public String XQ() {
        return prefix + "/XQ";
    }

    /**
     * 查询小区列表
     */
    @RequiresPermissions("community:XQ:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZhsqXq zhsqXq) {
        startPage();
        List<ZhsqXq> list = zhsqXqService.selectZhsqXqList(zhsqXq);
        return getDataTable(list);
    }

    /**
     * 导出小区列表
     */
    @RequiresPermissions("community:XQ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqXq zhsqXq) {
        List<ZhsqXq> list = zhsqXqService.selectZhsqXqList(zhsqXq);
        ExcelUtil<ZhsqXq> util = new ExcelUtil<ZhsqXq>(ZhsqXq.class);
        return util.exportExcel(list, "XQ");
    }

    /**
     * 新增小区
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqXq XQ = new ZhsqXq();
        mmap.put("XQ", XQ);
        return prefix + "/edit";
    }

    /**
     * 新增保存小区
     */
    @RequiresPermissions("community:XQ:add")
    @Log(title = "小区", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqXq zhsqXq) {
        String xqid = "XQ" + uidWorker.getNextId();
        zhsqXq.setXqid(xqid);
        return toAjax(zhsqXqService.insertZhsqXq(zhsqXq), zhsqXq);
    }

    /**
     * 修改小区
     */
    @GetMapping("/edit/{clid}")
    public String edit(@PathVariable("clid") String clid, ModelMap mmap) {
        ZhsqXq XQ = zhsqXqService.selectZhsqXqById(clid);
        mmap.put("XQ", XQ);
        return prefix + "/edit";
    }

    /**
     * 修改保存小区
     */
    @RequiresPermissions("community:XQ:edit")
    @Log(title = "小区", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqXq zhsqXq) {
        return toAjax(zhsqXqService.updateZhsqXq(zhsqXq));
    }

    /**
     * 删除小区
     */
    @RequiresPermissions("community:XQ:remove")
    @Log(title = "小区", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqXqService.deleteZhsqXqByIds(ids));
    }
}
