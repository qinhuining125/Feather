package com.feather.common.exception;

/**
 * @author feather
 */
public class NoRoleException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoRoleException(String role) {
        super(role);
    }
}
