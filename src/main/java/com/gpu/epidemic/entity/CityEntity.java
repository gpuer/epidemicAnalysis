package com.gpu.epidemic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("city")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="CityEntity对象", description="")
public class CityEntity extends Model<CityEntity> {

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

    public CityEntity(Integer provinceId,
                      String cityName,
                      Integer confirmedCount,
                      Integer suspectedCount,
                      Integer curedCount,
                      Integer deadCount,
                      Integer locationId) {
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.locationId = locationId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
