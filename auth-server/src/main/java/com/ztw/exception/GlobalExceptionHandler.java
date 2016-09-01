package com.ztw.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zsl-pc on 2016/9/1.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, MyException exc) {
        ErrorInfo<String> ei = new ErrorInfo<String>();
        ei.setMsg(exc.getMessage());
        ei.setCode(ErrorInfo.ERROR);
        ei.setUrl(req.getRequestURL().toString()+"?"+req.getQueryString());
        ei.setData("操作出错了，统一错误提示！");

        return ei;
    }
}
