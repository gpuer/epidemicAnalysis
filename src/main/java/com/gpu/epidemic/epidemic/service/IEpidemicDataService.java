package com.gpu.epidemic.epidemic.service;

import com.gpu.epidemic.epidemic.entity.EpidemicData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjc
 * @since 2020-01-30
 */
public interface IEpidemicDataService extends IService<EpidemicData> {
    List<String> getAreas();
    List<String> getCitys(String area);
}
