package com.zzw.weather_collection.service;

import com.zzw.weather_collection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city")
public interface CityClient {

    @GetMapping("/cities/listcity")
    List<City> listCity() throws Exception;
}
