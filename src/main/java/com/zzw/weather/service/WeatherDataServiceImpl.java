package com.zzw.weather.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzw.weather.vo.Weather;
import com.zzw.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Daydreamer
 * @date 2019/12/4 16:08
 */

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    // 获取天气信息地址
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据城市ID查询天气数据
     * 深圳：101280601
     *
     * @param cityId
     * @return
     */
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return getWeather(uri);
    }

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return getWeather(uri);
    }

    /**
     * 获取天气信息
     *
     * @param uri：信息获取地址
     * @return
     */
    private WeatherResponse getWeather(String uri) {

        String key = uri;
        String result = "";

        WeatherResponse weatherResponse = new WeatherResponse();
        ValueOperations<String, String> valueOperation = redisTemplate.opsForValue();

        // 先查缓存，缓存中有直接取
        if (redisTemplate.hasKey(key)) {
            result = valueOperation.get(key);
            logger.info("Redis has data " + result);
        } else {
            // 缓存中没有，再调用服务接口来获取
            // 对获取的返回结果进行类型转换
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            if (response.getStatusCodeValue() == 200) {
                result = response.getBody();
            }
            // 数据写入缓存，超时时间为30分钟
            valueOperation.set(key, result, 1800, TimeUnit.SECONDS);
            logger.info("Redis doesn't have data, the result is " + result);
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(result);
            result = jsonObject.getString("data");
            Weather weather = JSON.parseObject(result, Weather.class);
            weatherResponse.setData(weather);
        } catch (Exception e) {
            logger.error("Error!!!", e);
        }
        return weatherResponse;
    }


    /**
     * 根据cityId缓存数据
     *
     * @param cityId
     */
    @Override
    public void syncDataByCityId(String cityId) {
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
