package com.zzw.weather_collection.vo;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("weather-city-server")
public interface CityClient {

    List<City> listCity() throws Exception;
}
