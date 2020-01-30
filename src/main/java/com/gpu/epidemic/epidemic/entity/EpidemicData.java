package com.gpu.epidemic.epidemic.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.gpu.epidemic.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjc
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EpidemicData extends BaseEntity {


    private String city;

    private String area;

    private Integer confirm;

    private Integer suspect;

    private Integer dead;

    private Integer heal;



}
