package com.zzw.weather_report.controller;

import com.zzw.weather_report.service.WeatherReportService;
import com.zzw.weather_report.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/6 10:00
 */

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId")
    public ModelAndView getWeatherReportByCityId(@RequestParam("cityId") String cityId,
                                                 Model model) throws Exception {
        // TODO:由城市数据微服务来提供城市数据
        List<City> cityList = null;
        cityList = new ArrayList<City>();
        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}