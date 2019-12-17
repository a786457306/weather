package com.zzw.weather_report_zuul.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/4 15:56
 */

@Getter
@Setter
@ToString
public class Weather {

    private static final long serialVersionUID = 1L;

    private String city;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
