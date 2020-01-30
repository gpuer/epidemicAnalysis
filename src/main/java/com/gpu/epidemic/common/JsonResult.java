package com.gpu.epidemic.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


public class JsonResult {
    // 成功状态
    public static final Integer SUCCESS_CODE = 200;
    // 参数错误
    public static final Integer PARAMETER_ERROR = 501;
    // 校验不通过
    public static final Integer UNPASS_CODE = 402;
    // 其他错误
    public static final Integer ERROR_CODE = 500;

    public static final <T> JSONObject success(Object data, Page page) {
        Map<String, Object> result = new HashMap<>();

        result.put("data", data == null ? new ArrayList<>() : data);
        result.put("code", SUCCESS_CODE);

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("current", page.getCurrent());
        pageInfo.put("total", page.getTotal());
        pageInfo.put("pages", page.getPages());
        pageInfo.put("size", page.getSize());
        pageInfo.put("hasNext", page.hasNext());
        pageInfo.put("hasPrevious", page.hasPrevious());

        result.put("page", pageInfo);

        return JSON.parseObject(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }

    public static final <T> JSONObject success(Object data) {
        Map<String, Object> result = new HashMap<>();

        result.put("data", data == null ? new ArrayList<>() : data);
        result.put("code", SUCCESS_CODE);

        return JSON.parseObject(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }

    public static final JSONObject fail(String message, Integer code) {
        Map<String, Object> result = new HashMap<>();

        result.put("message", message);
        result.put("code", code);

        return JSON.parseObject(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }
}

