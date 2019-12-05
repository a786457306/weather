package com.zzw.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 未来天气
 *
 * @author Daydreamer
 * @date 2019/12/4 16:02
 */

@Getter
@Setter
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1L;
    private String date;
    private String highTemperature;
    private String windPower;
    private String lowTemperature;
    private String windDirection;
    private String type;
}
