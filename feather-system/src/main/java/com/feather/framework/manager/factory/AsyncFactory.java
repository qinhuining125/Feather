package com.feather.framework.manager.factory;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feather.common.constant.FeatherConstants;
import com.feather.common.utils.AddressUtils;
import com.feather.common.utils.ServletUtils;
import com.feather.common.utils.spring.SpringUtils;
import com.feather.framework.shiro.session.OnlineSession;
import com.feather.framework.util.LogUtils;
import com.feather.framework.util.ShiroUtils;
import com.feather.system.domain.SysLogininfor;
import com.feather.system.domain.SysOperLog;
import com.feather.system.domain.SysUserOnline;
import com.feather.system.service.ISysOperLogService;
import com.feather.system.service.ISysUserOnlineService;
import com.feather.system.service.impl.SysLogininforServiceImpl;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * 异步工厂（产生任务用）
 * 
 * @author liuhulu
 *
 */
public class AsyncFactory {
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 同步session到数据库
     * 
     * @param session
     *            在线用户会话
     * @return 任务task
     */
    public static TimerTask syncSessionToDb(final OnlineSession session) {
        return new TimerTask() {
            @Override
            public void run() {
                SysUserOnline online = new SysUserOnline();
                online.setSessionId(String.valueOf(session.getId()));
                online.setDeptName(session.getDeptName());
                online.setLoginName(session.getLoginName());
                online.setStartTimestamp(session.getStartTimestamp());
                online.setLastAccessTime(session.getLastAccessTime());
                online.setExpireTime(session.getTimeout());
                online.setIpaddr(session.getHost());
                online.setLoginLocation(AddressUtils.getRealAddressByIP(session.getHost()));
                online.setBrowser(session.getBrowser());
                online.setOs(session.getOs());
                online.setStatus(session.getStatus());
                SpringUtils.getBean(ISysUserOnlineService.class).saveOnline(online);

            }
        };
    }

    /**
     * 操作日志记录
     * 
     * @param operLog
     *            操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                String params = operLog.getOperParam();
                if (params != null) {
                    String pwdMark = "\"password\" : [ \"";
                    int begin = params.indexOf(pwdMark);
                    if (begin > 0) {
                        int end = params.indexOf("\" ],", begin);
                        if (end > 0) {
                            String part1 = params.substring(0, begin + pwdMark.length());
                            String part2 = params.substring(end);
                            operLog.setOperParam(part1 + "******" + part2);
                        }
                    }
                }
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }

    /**
     * 记录登陆信息
     * 
     * @param username
     *            用户名
     * @param status
     *            状态
     * @param message
     *            消息
     * @param args
     *            列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message,
            final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = ShiroUtils.getIp();
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setLoginName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                if (FeatherConstants.LOGIN_SUCCESS.equals(status) || FeatherConstants.LOGOUT.equals(status)) {
                    logininfor.setStatus(FeatherConstants.TRUE_SUCCESS_ENABLED_PRIMARY);
                } else if (FeatherConstants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(FeatherConstants.FALSE_FAIL_DISABLED_SUBORDINATE);
                }
                // 插入数据
                SpringUtils.getBean(SysLogininforServiceImpl.class).insertLogininfor(logininfor);
            }
        };
    }
}
