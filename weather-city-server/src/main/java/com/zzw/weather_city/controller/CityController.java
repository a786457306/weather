package com.zzw.weather_city.controller;


import com.zzw.weather_city.service.CityDataService;
import com.zzw.weather_city.vo.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("/listcity")
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
