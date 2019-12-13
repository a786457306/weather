package com.zzw.weather_collection.service;

public interface WeatherDataCollectionService {

    /**
     * 根据城市Id获取天气数据
     *
     * @param cityId
     */
    void syncWeatherDataByCityId(String cityId);
}
