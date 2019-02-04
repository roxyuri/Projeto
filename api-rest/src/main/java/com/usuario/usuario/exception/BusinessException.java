package com.usuario.usuario.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -1184135550185000826L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Exception e) {
        super(e);
    }

}
