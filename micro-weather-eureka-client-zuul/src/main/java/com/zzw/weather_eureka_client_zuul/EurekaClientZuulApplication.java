package com.zzw.weather_eureka_client_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
// 启用zuul的代理功能
@EnableZuulProxy
public class EurekaClientZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientZuulApplication.class, args);
    }
}
