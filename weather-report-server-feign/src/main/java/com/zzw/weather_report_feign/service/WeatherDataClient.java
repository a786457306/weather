package com.zzw.weather_report_feign.service;

import com.zzw.weather_report_feign.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("weather-data")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId")
    WeatherResponse getDataByCityId(String cityId);
}
