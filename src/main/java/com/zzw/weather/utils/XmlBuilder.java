package com.zzw.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * 解析xml文件
 *
 * @author Daydreamer
 * @date 2019/12/5 16:34
 */
public class XmlBuilder {

    /**
     * 将xml转换为指定的POJO对象
     *
     * @param clazz
     * @param xml
     * @return
     * @throws Exception
     */
    public static Object xmlToObject(Class<?> clazz, String xml) throws Exception {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // xml转为对象
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xml);
        xmlObject = unmarshaller.unmarshal(reader);

        // 关闭输入流
        if (null != reader) {
            reader.close();
        }

        return xmlObject;
    }
}
