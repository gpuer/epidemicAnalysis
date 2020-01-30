package com.gpu.epidemic.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpu.epidemic.entity.EpidemicDataEntity;
import com.gpu.epidemic.service.EpidemicDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("epidemicBy/city/{city}/date/{date}")
    public ResponseEntity getEpidemicByCityAndDate(@PathVariable("city")String city,
                                                   @PathVariable("date") LocalDate date){
        return ResponseEntity.ok(epidemicDataService.getOne(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getCity, city)
                        .eq(EpidemicDataEntity::getCreatedAt,date)
        ));
    }

    /**
     * 根据城市和时间获取数据
     * @param city 城市
     * @return 当天的情况
     */
    @ApiOperation("根据城市和时间获取数据")
    @GetMapping("epidemicBy/city/{city}")
    public ResponseEntity getEpidemicByCity(@PathVariable("city")String city){
        return ResponseEntity.ok(epidemicDataService.list(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getCity, city))
        );
    }

    /**
     * 根据省份和时间获取数据
     * @param area 城市
     * @param date 时间
     * @return 当天的情况
     */
    @ApiOperation("根据城市和时间获取数据")
    @GetMapping("epidemicBy/area/{area}/date/{date}")
    public ResponseEntity getEpidemicByaAreaAndDate(@PathVariable("area")String area,
                                                   @PathVariable("date") LocalDate date){
        return ResponseEntity.ok(epidemicDataService.getOne(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getArea, area)
                        .eq(EpidemicDataEntity::getCreatedAt,date)
        ));
    }

    /**
     * 根据省份和时间获取数据
     * @param area 省份
     * @return 当天的情况
     */
    @ApiOperation("根据城市和时间获取数据")
    @GetMapping("epidemicBy/area/{area}")
    public ResponseEntity getEpidemicByaArea(@PathVariable("area")String area){
        return ResponseEntity.ok(epidemicDataService.list(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getArea, area)
                ));
    }

}

