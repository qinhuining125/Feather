package com.feather.system.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.constant.FeatherConstants;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.framework.shiro.service.SysPasswordService;
import com.feather.framework.util.ShiroUtils;
import com.feather.system.domain.SysUser;
import com.feather.system.service.ISysPostService;
import com.feather.system.service.ISysRoleService;
import com.feather.system.service.ISysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息
 * 
 * @author feather
 */
@Api(tags = "用户管理")
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    private String prefix = "system/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String loginName = ShiroUtils.getLoginName();
        Long operUserId = ShiroUtils.getUserId();
        String message = userService.importUser(userList, updateSupport, loginName, operUserId);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SysUser user = new SysUser();
        user.setStatus(FeatherConstants.TRUE_SUCCESS_ENABLED_PRIMARY);
        mmap.put("user", user);
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/edit";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysUser user) {
        AjaxResult checkResult = checkEditUser(user);
        if (checkResult != null) {
            return checkResult;
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(userService.insertUser(user), user);
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        SysUser user = userService.selectUserById(userId);
        mmap.put("user", user);
        mmap.put("roles", roleService.flagAllByUserId(userId));
        mmap.put("posts", postService.flagAllByUserId(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysUser user) {
        AjaxResult checkResult = checkEditUser(user);
        if (checkResult != null) {
            return checkResult;
        }
        return toAjax(userService.updateUser(user));
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @GetMapping("/resetAllPwd")
    public String resetAllPwdView() {
        SysUser currentUser = ShiroUtils.getSysUser();
        if (currentUser == null || currentUser.isAdmin() == false) {
            return prefix + "/resetUnPromise";
        }
        return prefix + "/resetAllPwd";
    }

    @PostMapping("/resetAllPwd")
    @ResponseBody
    public AjaxResult resetAllPwd(@RequestParam("password") String password) {
        SysUser currentUser = ShiroUtils.getSysUser();
        if (currentUser == null || currentUser.isAdmin() == false) {
            return AjaxResult.error("没有权限");
        }
        if (StringUtils.isEmpty(password)) {
            return AjaxResult.error("密码不能为空");
        }
        SysUser user = new SysUser();
        List<SysUser> list = userService.selectUserList(user);
        for (SysUser entity : list) {
            if (!entity.getLoginName().equals("admin")) {
                entity.setPassword(password);
                resetPwdSave(entity);
            }
        }
        return AjaxResult.success();
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user) {
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        if (userService.resetUserPwd(user) > 0) {
            if (ShiroUtils.getUserId() == user.getUserId()) {
                ShiroUtils.setSysUser(userService.selectUserById(user.getUserId()));
            }
            return AjaxResult.success();
        }
        throw new RuntimeException("没有找到需要修改的信息");
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) throws Exception {
        return toAjax(userService.deleteUserByIds(ids));
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public boolean checkLoginNameUnique(SysUser user) {
        return userService.checkLoginNameUnique(user);
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public boolean checkPhoneUnique(SysUser user) {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验身份证号
     */
    @PostMapping("/checkIdcardUnique")
    @ResponseBody
    public boolean checkIdcardUnique(SysUser user) {
        return userService.checkIdcardUnique(user);
    }

    /**
     * 校验openid
     */
    @PostMapping("/checkOpenidUnique")
    @ResponseBody
    public boolean checkOpenidUnique(SysUser user) {
        return userService.checkOpenidUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public boolean checkEmailUnique(SysUser user) {
        return userService.checkEmailUnique(user);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysUser user) {
        return toAjax(userService.changeStatus(user));
    }

    @Log(title = "修改密码", businessType = BusinessType.API)
    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "password", value = "密码", required = true) //
    })
    @PostMapping("/api/resetPwd")
    @ResponseBody
    public AjaxResult restResetPwd(String password) {
        SysUser user = ShiroUtils.getSysUser();
        if (user == null) {
            throw new RuntimeException("修改失败，未登录！");
        }
        String loginName = user.getLoginName();
        String salt = ShiroUtils.randomSalt();
        String passwordMd5 = passwordService.encryptPassword(loginName, password, salt);
        user.setSalt(salt);
        user.setPassword(passwordMd5);
        userService.updateUserInfo(user);
        return AjaxResult.success();
    }

    private AjaxResult checkEditUser(SysUser user) {
        if (user != null && user.isAdmin()) {
            return AjaxResult.error("不允许修改超级管理员用户");
        }

        if (!userService.checkLoginNameUnique(user)) {
            return AjaxResult.error("保存用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (!userService.checkPhoneUnique(user)) {
            return AjaxResult.error("保存用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (!userService.checkEmailUnique(user)) {
            return AjaxResult.error("保存用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        } else if (!userService.checkIdcardUnique(user)) {
            return AjaxResult.error("保存用户'" + user.getLoginName() + "'失败，身份证号已存在");
        } else if (!userService.checkOpenidUnique(user)) {
            return AjaxResult.error("保存用户'" + user.getLoginName() + "'失败，openid已存在");
        }
        return null;
    }
}