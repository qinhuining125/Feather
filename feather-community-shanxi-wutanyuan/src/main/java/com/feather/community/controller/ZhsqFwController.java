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
import com.feather.community.domain.ZhsqFw;
import com.feather.community.service.IZhsqFwService;

/**
 * 房屋Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/FW")
public class ZhsqFwController extends BaseController {
    private String prefix = "community/FW";
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private IZhsqFwService zhsqFwService;

    @RequiresPermissions("community:FW:view")
    @GetMapping()
    public String FW() {
        return prefix + "/FW";
    }

    /**
     * 查询房屋列表
     */
    @RequiresPermissions("community:FW:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqFw zhsqFw) {
        startPage();
        List<ZhsqFw> list = zhsqFwService.selectZhsqFwList(zhsqFw);
        return getDataTable(list);
    }

    /**
     * 导出房屋列表
     */
    @RequiresPermissions("community:FW:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqFw zhsqFw) {
        List<ZhsqFw> list = zhsqFwService.selectZhsqFwList(zhsqFw);
        ExcelUtil<ZhsqFw> util = new ExcelUtil<ZhsqFw>(ZhsqFw.class);
        return util.exportExcel(list, "FW");
    }

    /**
     * 新增房屋
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqFw FW = new ZhsqFw();
        mmap.put("FW", FW);
        return prefix + "/edit";
    }

    /**
     * 新增保存房屋
     */
    @RequiresPermissions("community:FW:add")
    @Log(title = "房屋", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqFw zhsqFw) {
        String fwid = "FW" + uidWorker.getNextId();
        zhsqFw.setFwid(fwid);
        return toAjax(zhsqFwService.insertZhsqFw(zhsqFw), zhsqFw);
    }

    /**
     * 修改房屋
     */
    @GetMapping("/edit/{fwid}")
    public String edit(@PathVariable("fwid") String fwid, ModelMap mmap) {
        ZhsqFw FW = zhsqFwService.selectZhsqFwById(fwid);
        mmap.put("FW", FW);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋
     */
    @RequiresPermissions("community:FW:edit")
    @Log(title = "房屋", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqFw zhsqFw) {
        return toAjax(zhsqFwService.updateZhsqFw(zhsqFw), zhsqFw);
    }

    /**
     * 删除房屋
     */
    @RequiresPermissions("community:FW:remove")
    @Log(title = "房屋", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqFwService.deleteZhsqFwByIds(ids));
    }

    // @GetMapping( "/rzl")
    // @ResponseBody
    // public AjaxResult queryRzlCount(@Param("xqid") String xqid,@Param("sqid")
    // String sqid){
    // Map<String,Object> maps = new HashMap<>();
    // maps.put("xqid",xqid);
    // maps.put("sqid",sqid);
    // return AjaxResult.success(zhsqFwService.selectRzlCount(maps));
    // }
    //
    // @GetMapping( "/tj")
    // @ResponseBody
    // public AjaxResult queryTjCount(@Param("xqid") String xqid,@Param("sqid")
    // String sqid){
    // Map<String,Object> maps = new HashMap<>();
    // maps.put("xqid",xqid);
    // maps.put("sqid",sqid);
    // return AjaxResult.success(zhsqFwService.selectTjCount(maps));
    // }
}