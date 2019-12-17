package com.zzw.weather_report_feign.service;

import com.zzw.weather_report_feign.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Daydreamer
 * @date 2019/12/6 9:59
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // 由天气数据微服务来提供数据
        Weather data = weatherDataClient.getDataByCityId(cityId).getData();
        return data;
    }
}
