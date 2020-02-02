package com.gpu.epidemic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuYd
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("city_log")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="CityLogEntity对象", description="")
public class CityLogEntity extends Model<CityLogEntity> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("provinceId")
    private Integer provinceId;

    @TableField("cityName")
    private String cityName;

    @TableField("confirmedCount")
    private Integer confirmedCount;

    @TableField("suspectedCount")
    private Integer suspectedCount;

    @TableField("curedCount")
    private Integer curedCount;

    @TableField("deadCount")
    private Integer deadCount;

    @TableField("locationId")
    private Integer locationId;

    @TableField("dateTime")
    private LocalDateTime dateTime;

    public CityLogEntity(Integer provinceId,
                      String cityName,
                      Integer confirmedCount,
                      Integer suspectedCount,
                      Integer curedCount,
                      Integer deadCount,
                      Integer locationId,
                      LocalDateTime dateTime) {
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.locationId = locationId;
        this.dateTime = dateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
