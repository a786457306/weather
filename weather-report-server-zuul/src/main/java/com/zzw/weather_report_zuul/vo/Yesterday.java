package com.zzw.weather_report_zuul.vo;

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
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}