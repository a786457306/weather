package com.zzw.weather.config;

import com.zzw.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Daydreamer
 * @date 2019/12/5 15:30
 */

@Configuration
public class QuartzConfiguration {

    // 定时器刷新时间
    private static final Integer TIME = 1800;

    /**
     * Job的实现细节
     * JobDetail是Job实例，是对象，包含实例的执行计划和所需要的数据
     *
     * @return
     */
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                // 可以自定义，便于检索
                .withIdentity("weatherDataSyncJob")
                // 即使没有Trigger关联，也不删除这个JobDetail
                .storeDurably()
                .build();
    }

    /**
     * trigger 定时器，决定何时触发任务
     *
     * @return
     */
    @Bean
    public Trigger weatherDataSyncTrigger() {
        // 调度器，每小时执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();

        // 新建触发器
        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
