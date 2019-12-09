package com.zzw.weather_report.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 城市列表xml文件对应实体类
 *
 * @author Daydreamer
 * @date 2019/12/5 16:25
 */

@Getter
@Setter
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}
