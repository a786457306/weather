package com.zzw.weather_report_zuul.controller;

import com.zzw.weather_report_zuul.service.DataClient;
import com.zzw.weather_report_zuul.service.WeatherReportService;
import com.zzw.weather_report_zuul.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/6 10:00
 */

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId")
    public ModelAndView getWeatherReportByCityId(@RequestParam("cityId") String cityId,
                                                 Model model) throws Exception {
        // 由城市数据微服务来提供城市数据
        List<City> cityList = null;
        try {
            cityList = dataClient.listCity();
        } catch (Exception e) {
            logger.error("Exception! ", e);
        }

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}