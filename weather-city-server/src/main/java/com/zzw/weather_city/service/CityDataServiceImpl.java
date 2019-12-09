package com.zzw.weather_city.service;

import com.zzw.weather_city.utils.XmlBuilder;
import com.zzw.weather_city.vo.City;
import com.zzw.weather_city.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/5 18:14
 */

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {

        // 读取xml文件
        // 通过文件名寻找xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        // 读取文件
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        reader.close();

        // xml文件解析成java对象
        CityList cityList = (CityList) XmlBuilder.xmlToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
