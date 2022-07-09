package com.commons;

public class Result<T>{

    private Message message;
    private int code;
    private T context;

    public Result(Message message, int code, T context) {
        this.message = message;
        this.code = code;
        this.context = context;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContext() {
        return context;
    }

    public void setContext(T context) {
        this.context = context;
    }
}
