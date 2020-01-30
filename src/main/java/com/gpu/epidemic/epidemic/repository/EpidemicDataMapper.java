package com.gpu.epidemic.epidemic.repository;

import com.gpu.epidemic.epidemic.entity.EpidemicData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjc
 * @since 2020-01-30
 */
public interface EpidemicDataMapper extends BaseMapper<EpidemicData> {

    @Select("SELECT area FROM epidemic_data GROUP BY area")
    List<String> getAreas();

    @Select("SELECT city FROM epidemic_data WHERE area=#{area} GROUP BY city")
    List<String> getCitys(String area);
}
