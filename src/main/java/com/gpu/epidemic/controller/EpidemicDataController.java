package com.gpu.epidemic.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpu.epidemic.entity.EpidemicDataEntity;
import com.gpu.epidemic.service.EpidemicDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuYd
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/epidemic")
public class EpidemicDataController {

    private EpidemicDataService epidemicDataService;

    public EpidemicDataController(EpidemicDataService epidemicDataService) {
        this.epidemicDataService = epidemicDataService;
    }

    /**
     * 数据统计
     * @return 条数
     */
    @GetMapping("count")
    @ApiOperation("数据统计")
    public ResponseEntity getCount(){
        return ResponseEntity.ok(epidemicDataService.count());
    }

    /**
     * 根据城市和时间获取数据
     * @param city 城市
     * @param date 时间
     * @return 当天的情况
     */
    @ApiOperation("根据城市和时间获取数据")
    @GetMapping("epidemicBy/{city}/{date}")
    public ResponseEntity getEpidemicByCityAndDate(@PathVariable("city")String city,
                                                   @PathVariable("date") LocalDate date){
        return ResponseEntity.ok(epidemicDataService.getOne(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getCity, city)
                        .eq(EpidemicDataEntity::getCreatedAt,date)
        ));
    }

}

