package com.feather.common.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.ui.ModelMap;

import com.feather.common.core.domain.AjaxResult;

/**
 * @author feather
 */
public interface CustomLogin {

    public static final String DEFAULT_LOGIN_TEMPLATE = "login";
    public static final String DEFAULT_CONSOLE_TEMPLATE = "my-console";

    default String getLoginTemplate(HttpServletRequest request) {
        return DEFAULT_LOGIN_TEMPLATE;
    }

    default String getConsoleTemplate(ModelMap mmap) {
        return DEFAULT_CONSOLE_TEMPLATE;
    }

    default void preLogin(HttpServletRequest request) {

    }

    default boolean getUser(Object object) {
        return false;
    }

    default boolean getAuthorizationInfo(AuthorizationInfo authorizationInfo) {
        return false;
    }

    default void afterLogin(HttpServletRequest request, AjaxResult result) {

    }

    default boolean existsSessionId(ServletRequest request) {
        return false;
    }

    default String getSessionId(ServletRequest request, ServletResponse response) {
        return null;
    }

    default void getCaptcha(HttpServletRequest request, HttpServletResponse response) {

    }
}
