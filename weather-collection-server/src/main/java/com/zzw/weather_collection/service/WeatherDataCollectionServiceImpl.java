package com.zzw.weather_collection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    // 获取天气信息地址
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据城市Id获取天气数据
     *
     * @param cityId
     */
    @Override
    public void syncWeatherDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherDataToRedis(uri);
    }

    /**
     * 把天气信息缓存到redis
     *
     * @param uri
     */
    private void saveWeatherDataToRedis(String uri) {
        String key = uri;
        String result = "";
        ValueOperations<String, String> valueOperation = redisTemplate.opsForValue();

        // 不管缓存中有没有都要写入
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if (response.getStatusCodeValue() == 200) {
            result = response.getBody();
        }
        // 数据写入缓存，超时时间为30分钟
        valueOperation.set(key, result, 1800, TimeUnit.SECONDS);
        logger.info("save data to redis, the result is " + result);
    }
}
