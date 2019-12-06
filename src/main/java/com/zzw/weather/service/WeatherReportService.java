package com.zzw.weather.service;

import com.zzw.weather.vo.Weather;

/**
 * @author Daydreamer
 * @date 2019/12/6 9:58
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
