package com.gpu.epidemic.exception;

import com.gpu.epidemic.common.JsonResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JSONObject handleValidationException(ConstraintViolationException e) {
        StringBuffer message = new StringBuffer();

        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            message.append(s.getMessage());
            message.append(",");
        }

        Map<String, Object> result = new HashMap<>();

        result.put("message", message.toString().substring(0, message.length() - 1));
        result.put("code", JsonResult.PARAMETER_ERROR);

        return JSON.parseObject(JSON.toJSONString(result));
    }
}
