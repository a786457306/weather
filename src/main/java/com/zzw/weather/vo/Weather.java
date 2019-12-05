package com.zzw.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/4 15:56
 */

@Getter
@Setter
public class Weather {

    private static final long serialVersionUID = 1L;

    private String city;

    private String aqi;

    // 感冒
    private String catchCold;

    // 温度
    private String temperature;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
