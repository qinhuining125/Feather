package com.feather.system.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feather.common.annotation.Excel;
import com.feather.common.annotation.Excel.ColumnType;
import com.feather.common.annotation.Excel.Type;
import com.feather.common.annotation.Excels;
import com.feather.common.core.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象 sys_user
 * 
 * @author feather
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private static Set<Long> ADMIN_IDS = new HashSet<>();

    /** 用户ID */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long deptId;

    /** 部门父ID */
    private Long parentId;

    /** 角色ID */
    private Long roleId;

    /** 登录名称 */
    @Excel(name = "登录名称")
    @NotBlank(message = "登录账号不能为空")
    @Size(min = 0, max = 30, message = "登录账号长度不能超过30个字符")
    private String loginName;

    /** 用户名称 */
    @Excel(name = "用户名称")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    private String userName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    private String phonenumber;

    @Excel(name = "身份证号")
    private String idcard;
    @Excel(name = "openid")
    private String openid;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女")
    private Byte sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    @JsonIgnore
    private String password;

    /** 盐加密 */
    @JsonIgnore
    private String salt;

    /** 最后登陆IP */
    @Excel(name = "最后登陆IP", type = Type.EXPORT)
    private String loginIp;

    /** 最后登陆时间 */
    @Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /** 部门对象 */
    @Excels({ @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT) })
    private SysDept dept;

    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public String getAvatar() {
        return avatar != null ? avatar : "";
    }

    public static boolean isAdmin(Long userId) {
        return (userId != null && 1L == userId) || ADMIN_IDS.contains(userId);
    }

    public static boolean addAdminId(Long userId) {
        return ADMIN_IDS.add(userId);
    }
}
