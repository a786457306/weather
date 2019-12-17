package com.zzw.weather_eureka_client_feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 指明要访问的服务地址，某服务的某接口
@FeignClient("weather-city")
public interface CityClient {

    /**
     * 到指定接口地址下获取城市列表
     *
     * @return
     */
    @GetMapping("/cities/listcity")
    String listCities();
}
