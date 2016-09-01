package com.ztw.exception;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = -1;

    private Integer code;
    private String msg;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
