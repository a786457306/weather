package com.zzw.weather_report.vo;

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
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
