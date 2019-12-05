package com.zzw.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestTemplate
 * 自定义注入后，才能够在项目中自动注入restTemplate，但所有的配置项都需要我们自己配置
 * 由于在Controller中注入了RestTemplate，启动时需要实例化一个RestTemplate的实例
 * 自动注入的时候注入的是Bean实例
 *
 * @author Daydreamer
 * @date 2019/12/4 16:26
 */

@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder builder;

    /**
     * 实例化对象，告诉方法，要生成一个bean，并交给spring容器管理
     * @Autowired直接用这个bean注入
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
