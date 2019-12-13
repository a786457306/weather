package com.zzw.weather_collection.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
