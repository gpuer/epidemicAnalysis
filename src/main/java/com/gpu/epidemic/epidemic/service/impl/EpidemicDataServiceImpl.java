package com.gpu.epidemic.epidemic.service.impl;

import com.gpu.epidemic.epidemic.entity.EpidemicData;
import com.gpu.epidemic.epidemic.repository.EpidemicDataMapper;
import com.gpu.epidemic.epidemic.service.IEpidemicDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjc
 * @since 2020-01-30
 */
@Service
public class EpidemicDataServiceImpl extends ServiceImpl<EpidemicDataMapper, EpidemicData> implements IEpidemicDataService {
    @Autowired
    private EpidemicDataMapper epidemicDataMapper;
    @Override
    public List<String> getAreas() {
        return epidemicDataMapper.getAreas();
    }

    @Override
    public List<String> getCitys(String area) {
        return epidemicDataMapper.getCitys(area);
    }
}
