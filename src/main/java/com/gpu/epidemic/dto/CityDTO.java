package com.gpu.epidemic.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.gpu.epidemic.entity.CityEntity;
import com.gpu.epidemic.entity.CityLogEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuYd
 * @since 2020-02-02
 */
@Data
public class CityDTO implements Serializable{

    private String cityName;

    private Integer confirmedCount;

    private Integer suspectedCount;

    private Integer curedCount;

    private Integer deadCount;

    private Integer locationId;

    public CityEntity toCity(Integer provinceId){
        return new CityEntity(
                provinceId,
                this.cityName,
                this.confirmedCount,
                this.suspectedCount,
                this.curedCount,
                this.deadCount,
                this.locationId
        );
    }

    public CityLogEntity toCityLog(Integer provinceId){
        return new CityLogEntity(
                provinceId,
                this.cityName,
                this.confirmedCount,
                this.suspectedCount,
                this.curedCount,
                this.deadCount,
                this.locationId,
                LocalDateTime.now()
        );
    }

}
