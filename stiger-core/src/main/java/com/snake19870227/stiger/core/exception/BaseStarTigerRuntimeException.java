package com.snake19870227.stiger.core.exception;

/**
 * @author BuHuaYang
 * 6/25 025
 */
public abstract class BaseStarTigerRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 7160024882316484234L;

    public BaseStarTigerRuntimeException(String message) {
        super(message);
    }

    public BaseStarTigerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseStarTigerRuntimeException(Throwable cause) {
        super(cause);
    }
}
