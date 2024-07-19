package com.example.app2.exception;

import java.net.HttpURLConnection;

public class BadParametersException extends TxException {
    public BadParametersException() {
    }

    public BadParametersException(String message) {
        super(message);
    }

    public BadParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadParametersException(Throwable cause) {
        super(cause);
    }

    public BadParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public int getStatusCode() {
        return HttpURLConnection.HTTP_BAD_REQUEST;
    }

}
