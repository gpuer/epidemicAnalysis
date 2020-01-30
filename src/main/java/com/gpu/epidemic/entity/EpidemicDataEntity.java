package com.gpu.epidemic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuYd
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("epidemic_data")
@ApiModel(value="EpidemicDataEntity对象", description="")
public class EpidemicDataEntity extends Model<EpidemicDataEntity> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("city")
    private String city;

    @TableField("area")
    private String area;

    @TableField("confirm")
    private Integer confirm;

    @TableField("suspect")
    private Integer suspect;

    @TableField("dead")
    private Integer dead;

    @TableField("heal")
    private Integer heal;

    @TableField("created_at")
    private LocalDateTime createdAt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
