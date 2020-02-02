package com.gpu.epidemic.dto;

import com.gpu.epidemic.entity.ProvinceEntity;
import com.gpu.epidemic.entity.ProvinceLogEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProvinceDTO implements Serializable {

    private String provinceName;

    private String provinceShortName;

    private Integer confirmedCount;

    private Integer suspectedCount;

    private Integer curedCount;

    private Integer deadCount;

    private String comment;

    private Integer locationId;

    private List<CityDTO> cities;

    public ProvinceLogEntity toProvinceLog(){
        return new ProvinceLogEntity(
                this.provinceName,
                this.provinceShortName,
                this.confirmedCount,
                this.suspectedCount,
                this.curedCount,
                this.deadCount,
                this.comment,
                this.locationId,
                LocalDateTime.now()
        );
    }


    public ProvinceEntity toProvince(){
        return new ProvinceEntity(
                this.provinceName,
                this.provinceShortName,
                this.confirmedCount,
                this.suspectedCount,
                this.curedCount,
                this.deadCount,
                this.comment,
                this.locationId
        );
    }
}
