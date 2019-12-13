package com.zzw.weather_eureka_client_feign.controller;

import com.zzw.weather_eureka_client_feign.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    /**
     * 远程调用某服务，返回的数据在这里显示
     * 客户端调用服务端
     * 通过Feign客户端调用
     *
     * @return
     */
    @GetMapping("/cities")
    String listCities(){
        return cityClient.listCities();
    }
}
