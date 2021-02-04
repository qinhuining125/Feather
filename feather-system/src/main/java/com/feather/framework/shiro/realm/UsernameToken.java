package com.feather.framework.shiro.realm;

/**
 * 免密登录，使用用户名处理登录
 * 
 * @author feather
 */
public class UsernameToken extends org.apache.shiro.authc.UsernamePasswordToken {

    private static final long serialVersionUID = 1L;

    public UsernameToken() {
        super();
    }

    public UsernameToken(String username) {
        super(username, "", false, null);
    }

    public UsernameToken(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
}
