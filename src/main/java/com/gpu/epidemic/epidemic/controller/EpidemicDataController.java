package com.gpu.epidemic.epidemic.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpu.epidemic.common.JsonResult;
import com.gpu.epidemic.epidemic.entity.EpidemicData;
import com.gpu.epidemic.epidemic.service.IEpidemicDataService;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yjc
 * @since 2020-01-30
 */
@RestController
@RequestMapping("epic")
public class EpidemicDataController {
    @Autowired
    private IEpidemicDataService epidService;


    @GetMapping("getAreas")
    JSONObject getAreas(){
        return JsonResult.success(epidService.getAreas());
    }

    @GetMapping("getCitys")
    JSONObject getCitys(String area){
        return JsonResult.success(epidService.getCitys(area));
    }
    
}
