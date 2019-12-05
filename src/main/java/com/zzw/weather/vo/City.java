package com.zzw.weather.vo;

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
// 声明该类为xml文件的根元素，写元素名称
@XmlRootElement(name = "d")
// 访问的类型：字段
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    // 声明对应xml文件的属性
    @XmlAttribute(name = "d1")
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "d4")
    private String province;
}
