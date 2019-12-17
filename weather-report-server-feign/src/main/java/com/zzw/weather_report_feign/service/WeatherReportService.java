package com.zzw.weather_report_feign.service;

import com.zzw.weather_report_feign.vo.Weather;

/**
 * @author Daydreamer
 * @date 2019/12/6 9:58
 */
public interface WeatherReportService {

    /**
     * 根据城市id查询天气信息
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
