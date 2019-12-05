package com.zzw.weather.controller;

import com.zzw.weather.service.WeatherDataService;
import com.zzw.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daydreamer
 * @date 2019/12/4 15:30
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId")
    public WeatherResponse getWeatherByCityId(@RequestParam("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName")
    public WeatherResponse getWeatherByCityName(@RequestParam("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}