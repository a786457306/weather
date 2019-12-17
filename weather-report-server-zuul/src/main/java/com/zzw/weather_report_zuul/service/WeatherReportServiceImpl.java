package com.zzw.weather_report_zuul.service;

import com.zzw.weather_report_zuul.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Daydreamer
 * @date 2019/12/6 9:59
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // 由天气数据微服务来提供数据
        Weather data = dataClient.getDataByCityId(cityId).getData();
        return data;
    }
}
