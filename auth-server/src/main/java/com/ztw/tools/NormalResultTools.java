package com.ztw.tools;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public class NormalResultTools {
    private NormalResultTools() {}

    private static NormalResultTools instance;

    public static NormalResultTools getInstance() {
        if(instance==null) {instance = new NormalResultTools();}
        return instance;
    }

    public NormalResult okResult(String message) {
        return new NormalResult(NormalResult.OK, message);
    }

    public NormalResult errorResult(String message) {
        return new NormalResult(NormalResult.ERROR, message);
    }

    public NormalResult okResult(String message, Object datas) {
        return new NormalResult(NormalResult.OK, message, datas);
    }
}
