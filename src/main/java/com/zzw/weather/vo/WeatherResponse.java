package com.zzw.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Daydreamer
 * @date 2019/12/4 16:05
 */

@Getter
@Setter
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;
}
