package com.ztw.tools;

import java.util.Collection;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public class NormalResult<T> {
    //成功标识
    public static final Integer OK = 0;

    //失败标识
    public static final Integer ERROR = -1;

    private Integer code;

    private String message;

    private Integer size;

    private T datas;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NormalResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public NormalResult(Integer code, String message, T datas) {
        this.code = code; this.message = message;
        this.datas = datas;
        if(datas!=null && datas instanceof Collection) {
            Integer size = ((Collection) datas).size();
            this.size = size;
        }
    }
    public NormalResult() {}

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
