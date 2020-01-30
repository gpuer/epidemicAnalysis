package com.gpu.epidemic.config;

import com.alibaba.fastjson.JSONObject;
import com.gpu.epidemic.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JSONObject defaultExceptionHandler(Exception ex) {
        logger.error(ex.getMessage());
        return JsonResult.fail(ex.getMessage(),JsonResult.ERROR_CODE);
    }
}
