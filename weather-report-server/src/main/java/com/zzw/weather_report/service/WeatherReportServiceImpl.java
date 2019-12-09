package com.zzw.weather_report.service;

import com.zzw.weather_report.vo.Forecast;
import com.zzw.weather_report.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/6 9:59
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO：由天气数据微服务来提供数据
        Weather data = new Weather();
        data.setCity("深圳");
        data.setGanmao("容易感冒，多穿衣");
        data.setWendu("22");

        List<Forecast> forecastList = new ArrayList<>();

        Forecast forecast1 = new Forecast();
        forecast1.setDate("29日星期天");
        forecast1.setFengxiang("无风");
        forecast1.setLow("低温1度");
        forecast1.setHigh("高温11度");
        forecast1.setType("晴");
        forecastList.add(forecast1);

        data.setForecast(forecastList);

        return data;
    }
}
