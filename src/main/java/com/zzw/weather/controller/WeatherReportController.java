package com.zzw.weather.controller;

import com.zzw.weather.service.CityDataService;
import com.zzw.weather.service.WeatherDataService;
import com.zzw.weather.service.WeatherReportService;
import com.zzw.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Daydreamer
 * @date 2019/12/6 10:00
 */

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId")
    public ModelAndView getWeatherReportByCityId(@RequestParam("cityId") String cityId,
                                                 Model model) throws Exception {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}