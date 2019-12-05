package com.zzw.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 昨日天气
 *
 * @author Daydreamer
 * @date 2019/12/4 16:01
 */

@Getter
@Setter
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String highTemperature;
    private String windDirection;
    private String lowTemperature;
    private String windPower;
    private String type;
}