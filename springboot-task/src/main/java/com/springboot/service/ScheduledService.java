package com.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 15:40 2020/12/27
 * @ Description：
 */
@Service
public class ScheduledService {

    /**
     * second, minute, hour, day of month, month, and day of week.
     * 秒，分，时，日，月，周
     */
//    @Scheduled(cron = "0 * * * * MON-SUN")//周一到周五每个0秒执行一次
//    @Scheduled(cron = "1,2,3,4 * * * * MON-SUN")//周一到周五每个1,2,3,4秒执行一次
//    @Scheduled(cron = "0-4 * * * * MON-SUN")//周一到周五每个0,1,2,3,4秒执行一次
    @Scheduled(cron = "0/4 * * * * MON-SUN")//周一到周五每4秒执行一次
    public void hello(){
        System.out.println("hello...");
    }
}
