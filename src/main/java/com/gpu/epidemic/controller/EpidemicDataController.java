package com.gpu.epidemic.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpu.epidemic.dto.ProvinceDTO;
import com.gpu.epidemic.entity.CityEntity;
import com.gpu.epidemic.entity.EpidemicDataEntity;
import com.gpu.epidemic.entity.ProvinceEntity;
import com.gpu.epidemic.entity.ProvinceLogEntity;
import com.gpu.epidemic.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@Api
@Slf4j
@RestController
@RequestMapping("/epidemic")
public class EpidemicDataController {

    private ProvinceService provinceService;

    private ProvinceLogService provinceLogService;

    private CityLogService cityLogService;

    private CityService cityService;

    public EpidemicDataController(ProvinceService provinceService,
                              ProvinceLogService provinceLogService,
                              CityLogService cityLogService,
                              CityService cityService) {
        this.provinceService = provinceService;
        this.provinceLogService = provinceLogService;
        this.cityLogService = cityLogService;
        this.cityService = cityService;
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ProvinceDTO provinceDTO){
        ProvinceEntity provinceEntity = provinceDTO.toProvince();
        ProvinceLogEntity provinceLogEntity = provinceDTO.toProvinceLog();
        if(provinceService.update(provinceEntity, Wrappers.<ProvinceEntity>lambdaQuery()
                .eq(ProvinceEntity::getProvinceName,provinceEntity.getProvinceName()))){
            provinceDTO.getCities().forEach(cityDTO -> {
                cityService.update(cityDTO.toCity(provinceEntity.getId()),
                        Wrappers.<CityEntity>lambdaQuery()
                                .eq(CityEntity::getCityName, cityDTO.getCityName()));
            });
        }

        if(provinceLogService.save(provinceLogEntity)){
            provinceDTO.getCities().forEach(cityDTO -> {
                cityLogService.save(cityDTO.toCityLog(provinceLogEntity.getId()));
            });
        }

        return ResponseEntity.ok().build();
    }


}

