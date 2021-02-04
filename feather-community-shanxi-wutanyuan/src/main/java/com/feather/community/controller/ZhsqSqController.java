package com.feather.community.controller;

import com.feather.common.annotation.Log;
import com.feather.common.config.UidWorker;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqSq;
import com.feather.community.service.IZhsqSqService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 社区Controller
 *
 * @author fancy
 * @date 2020-05-15
 */
@Controller
@RequestMapping("/community/SQ")
public class ZhsqSqController extends BaseController {
    private String prefix = "community/SQ";

    @Autowired
    UidWorker uidWorker;
    @Autowired
    private IZhsqSqService zhsqSqService;

    @RequiresPermissions("community:SQ:view")
    @GetMapping()
    public String SQ() {
        return prefix + "/SQ";
    }

    /**
     * 查询社区列表
     */
    @RequiresPermissions("community:SQ:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZhsqSq zhsqSq) {
        startPage();
        List<ZhsqSq> list = zhsqSqService.selectZhsqSqList(zhsqSq);
        return getDataTable(list);
    }

    /**
     * 导出社区列表
     */
    @RequiresPermissions("community:SQ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqSq zhsqSq) {
        List<ZhsqSq> list = zhsqSqService.selectZhsqSqList(zhsqSq);
        ExcelUtil<ZhsqSq> util = new ExcelUtil<ZhsqSq>(ZhsqSq.class);
        return util.exportExcel(list, "SQ");
    }

    /**
     * 新增社区
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqSq SQ = new ZhsqSq();
        mmap.put("SQ", SQ);
        return prefix + "/edit";
    }

    /**
     * 新增保存社区
     */
    @RequiresPermissions("community:SQ:add")
    @Log(title = "社区", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqSq zhsqSq) {
        String sqid = "SQ" + uidWorker.getNextId();
        zhsqSq.setSqid(sqid);
        return toAjax(zhsqSqService.insertZhsqSq(zhsqSq), zhsqSq);
    }

    /**
     * 修改社区
     */
    @GetMapping("/edit/{sqid}")
    public String edit(@PathVariable("sqid") String sqid, ModelMap mmap) {
        ZhsqSq SQ = zhsqSqService.selectZhsqSqById(sqid);
        mmap.put("SQ", SQ);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区
     */
    @RequiresPermissions("community:SQ:edit")
    @Log(title = "社区", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqSq zhsqSq) {
        return toAjax(zhsqSqService.updateZhsqSq(zhsqSq));
    }

    /**
     * 删除社区
     */
    @RequiresPermissions("community:SQ:remove")
    @Log(title = "社区", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqSqService.deleteZhsqSqByIds(ids));
    }
}
