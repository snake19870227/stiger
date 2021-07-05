package com.snake19870227.stiger.exception;

/**
 * @author BuHuaYang
 * 6/25 025
 */
public abstract class BaseStarTigerException extends RuntimeException {

    private static final long serialVersionUID = 7160024882316484235L;

    public BaseStarTigerException(String message) {
        super(message);
    }

    public BaseStarTigerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseStarTigerException(Throwable cause) {
        super(cause);
    }
}
