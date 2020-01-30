package com.gpu.epidemic.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gpu.epidemic.entity.EpidemicDataEntity;
import com.gpu.epidemic.service.EpidemicDataService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuYd
 * @since 2020-01-30
 */
@Slf4j
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
                                                   @PathVariable("date") Long date){
        LocalDate localDate = Instant.ofEpochMilli(date).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        return ResponseEntity.ok(epidemicDataService.getOne(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getCity, city)
                        .ge(EpidemicDataEntity::getCreatedAt, localDate)
                        .le(EpidemicDataEntity::getCreatedAt, localDate.minusDays(-1))
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
    public ResponseEntity getEpidemicByAreaAndDate(@PathVariable("area")String area,
                                                    @PathVariable("date") Long date){
        LocalDate localDate = Instant.ofEpochMilli(date).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        return ResponseEntity.ok(epidemicDataService.list(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getArea, area)
                        .ge(EpidemicDataEntity::getCreatedAt, localDate)
                        .le(EpidemicDataEntity::getCreatedAt, localDate.minusDays(-1))
        ));
    }

    /**
     * 根据省份和时间获取数据
     * @param area 省份
     * @return 当天的情况
     */
    @ApiOperation("根据城市和时间获取数据")
    @GetMapping("epidemicBy/area/{area}")
    public ResponseEntity getEpidemicByArea(@PathVariable("area")String area){
        return ResponseEntity.ok(epidemicDataService.list(
                Wrappers.<EpidemicDataEntity>lambdaQuery()
                        .eq(EpidemicDataEntity::getArea, area)
                ));
    }

    /**
     * 获取All 获取速度不快，慎用，待改造
     * @return 总数
     */
    @ApiOperation("获取All")
    @GetMapping("epidemicNum")
    public ResponseEntity<List<EpidemicDataEntity>> epidemicNum(){
        List<EpidemicDataEntity> list = new ArrayList<>(16);
        epidemicDataService.list(Wrappers.<EpidemicDataEntity>lambdaQuery()
                .select(EpidemicDataEntity::getArea)
                .groupBy(EpidemicDataEntity::getArea)
        ).forEach(area ->{
            list.add(getArea(area.getArea()));
        });
        return ResponseEntity.ok(list);
    }

    /**
     * 获取省内个数
     * @param area 省份
     * @return 总数
     */
    @ApiOperation("获取省内个数")
    @GetMapping("epidemicNumBy/area/{area}")
    public ResponseEntity<EpidemicDataEntity> epidemicNumByArea(@PathVariable("area")String area){
        return ResponseEntity.ok(getArea(area));
    }


    private EpidemicDataEntity getArea(String area){
        EpidemicDataEntity dataEntity = new EpidemicDataEntity(0,0,0,0);
        dataEntity.setArea(area);
        epidemicDataService.list(  Wrappers.<EpidemicDataEntity>lambdaQuery()
                .eq(EpidemicDataEntity::getArea,area)
                .select(EpidemicDataEntity::getCity)
                .groupBy(EpidemicDataEntity::getCity)).forEach(city->{
            EpidemicDataEntity epidemicDataEntity = epidemicDataService.getOne(
                    Wrappers.<EpidemicDataEntity>lambdaQuery()
                            .eq(EpidemicDataEntity::getCity, city.getCity())
                            .orderByDesc(EpidemicDataEntity::getCreatedAt)
                            .last("limit 1"));
            if(epidemicDataEntity != null){
                dataEntity.setDead(dataEntity.getDead() + epidemicDataEntity.getDead());
                dataEntity.setConfirm(dataEntity.getConfirm() + epidemicDataEntity.getConfirm());
                dataEntity.setHeal(dataEntity.getHeal() + epidemicDataEntity.getHeal());
                dataEntity.setSuspect(dataEntity.getSuspect() + epidemicDataEntity.getSuspect());
            }

        });
        return dataEntity;
    }
}

