package com.example.app2.exception;

import java.net.HttpURLConnection;

public class TxException extends RuntimeException {

    private static final int STATUS_CODE = HttpURLConnection.HTTP_INTERNAL_ERROR;

    public TxException() {
        super();
    }

    public TxException(String message) {
        super(message);
    }

    public TxException(String message, Throwable cause) {
        super(message, cause);
    }

    public TxException(Throwable cause) {
        super(cause);
    }

    protected TxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatusCode() {
        return STATUS_CODE;
    }
}
