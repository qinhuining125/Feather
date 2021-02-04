package com.feather.community.controller;

import java.util.List;

import com.feather.common.config.UidWorker;
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
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.service.IZhsqJmService;

/**
 * 居民Controller
 * 
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/JM")
public class ZhsqJmController extends BaseController {
    private String prefix = "community/JM";

    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private IZhsqJmService zhsqJmService;

    @RequiresPermissions("community:JM:view")
    @GetMapping()
    public String JM() {
        return prefix + "/JM";
    }

    /**
     * 查询居民列表
     */
    @RequiresPermissions("community:JM:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqJm zhsqJm) {
        startPage();
        List<ZhsqJm> list = zhsqJmService.selectZhsqJmList(zhsqJm);
        return getDataTable(list);
    }

    /**
     * 导出居民列表
     */
    @RequiresPermissions("community:JM:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqJm zhsqJm) {
        List<ZhsqJm> list = zhsqJmService.selectZhsqJmList(zhsqJm);
        ExcelUtil<ZhsqJm> util = new ExcelUtil<ZhsqJm>(ZhsqJm.class);
        return util.exportExcel(list, "JM");
    }

    /**
     * 新增居民
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqJm JM = new ZhsqJm();
        mmap.put("JM", JM);
        return prefix + "/edit";
    }

    /**
     * 新增保存居民
     */
    @RequiresPermissions("community:JM:add")
    @Log(title = "居民", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqJm zhsqJm) {
        String jmid = "JM" + uidWorker.getNextId();
        zhsqJm.setJmid(jmid);
        return toAjax(zhsqJmService.insertZhsqJm(zhsqJm), zhsqJm);
    }

    /**
     * 修改居民
     */
    @GetMapping("/edit/{jmid}")
    public String edit(@PathVariable("jmid") String jmid, ModelMap mmap) {
        ZhsqJm JM = zhsqJmService.selectZhsqJmById(jmid);
        mmap.put("JM", JM);
        return prefix + "/edit";
    }

    /**
     * 修改保存居民
     */
    @RequiresPermissions("community:JM:edit")
    @Log(title = "居民", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqJm zhsqJm) {
        return toAjax(zhsqJmService.updateZhsqJm(zhsqJm));
    }

    /**
     * 删除居民
     */
    @RequiresPermissions("community:JM:remove")
    @Log(title = "居民", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqJmService.deleteZhsqJmByIds(ids));
    }

}
