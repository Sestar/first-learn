package com.sestar.web.handler;

import com.sestar.web.controller.WebController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

/**
 * @description WebController专属异常处理类
 * @author zhangxinxin
 * @date 2019/1/29 14:35
 **/
@RestControllerAdvice(assignableTypes = WebController.class)
public class WebHandler {

    /**
     * @description 处理超时异常
     * @author zhangxinxin
     * @date 2019/1/29 14:37
     * @param throwable 异常
     * @return java.lang.String
     **/
    @ExceptionHandler(TimeoutException.class)
    public String handleTimeoutException(Throwable throwable) {
        return throwable.getMessage();
    }

}
