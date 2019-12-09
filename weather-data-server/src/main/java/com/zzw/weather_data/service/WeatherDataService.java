package com.zzw.weather_data.service;

import com.zzw.weather_data.vo.WeatherResponse;

/**
 * @author Daydreamer
 * @date 2019/12/4 16:07
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     * 深圳：101280601
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}
