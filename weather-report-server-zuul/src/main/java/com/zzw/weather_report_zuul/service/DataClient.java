package com.zzw.weather_report_zuul.service;

import com.zzw.weather_report_zuul.vo.City;
import com.zzw.weather_report_zuul.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("micro-weather-eureka-client-zuul")
public interface DataClient {

    /**
     * 获取城市列表
     * city：找到city微服务
     * cities/listcity：找到city微服务下面对应的接口
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities/listcity")
    List<City> listCity() throws Exception;

    /**
     * 根据城市Id获取天气数据
     * data：找到weather-data微服务
     * weather/cityId：微服务下方法对应的路径
     *
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId")
    WeatherResponse getDataByCityId(String cityId);
}
