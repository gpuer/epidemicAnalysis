package com.gpu.epidemic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("province")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="ProvinceEntity对象", description="")
public class ProvinceEntity extends Model<ProvinceEntity> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = " ")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("provinceName")
    private String provinceName;

    @TableField("provinceShortName")
    private String provinceShortName;

    @TableField("confirmedCount")
    private Integer confirmedCount;

    @TableField("suspectedCount")
    private Integer suspectedCount;

    @TableField("curedCount")
    private Integer curedCount;

    @TableField("deadCount")
    private Integer deadCount;

    @TableField("comment")
    private String comment;

    @TableField("locationId")
    private Integer locationId;

    public ProvinceEntity(String provinceName,
                          String provinceShortName,
                          Integer confirmedCount,
                          Integer suspectedCount,
                          Integer curedCount,
                          Integer deadCount,
                          String comment,
                          Integer locationId) {
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.comment = comment;
        this.locationId = locationId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
