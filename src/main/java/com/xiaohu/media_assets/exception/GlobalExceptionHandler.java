package com.xiaohu.media_assets.exception;

import com.xiaohu.media_assets.model.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaohu
 * @date 2023/03/04/ 23:17
 * @description 全局异常处理器
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail("系统异常,请联系管理员");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e) {
        e.printStackTrace();
        return Result.fail(e.getDescription());
    }
}