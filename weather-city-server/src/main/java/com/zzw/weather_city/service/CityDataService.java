package com.zzw.weather_city.service;

import com.zzw.weather_city.vo.City;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/5 18:13
 */
public interface CityDataService {

    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
