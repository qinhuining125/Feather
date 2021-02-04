package com.feather.common.exception;

/**
 * @author feather
 */
public class NoPermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoPermissionException(String permission) {
        super(permission);
    }
}
