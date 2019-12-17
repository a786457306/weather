package com.zzw.weather_collection.job;

import com.zzw.weather_collection.service.WeatherDataCollectionService;
import com.zzw.weather_collection.vo.City;
import com.zzw.weather_collection.service.CityClient;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 定时器，定时同步天气信息
 *
 * @author Daydreamer
 * @date 2019/12/5 15:25
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataService;

    @Autowired
    private CityClient cityClient;

    /**
     * 定时器执行逻辑
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job Start!");

        // 获取城市ID列表，城市API服务
        List<City> cityList = null;
        try {
            // 在远程服务调用过程中获取城市列表
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // 遍历城市ID，获取每个城市的天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId: " + cityId);
            weatherDataService.syncWeatherDataByCityId(cityId);
        }
    }
}
