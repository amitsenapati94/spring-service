package com.springservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SchduledTasksService {

    public static final Logger log = LoggerFactory.getLogger(SchduledTasksService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /*@Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        log.info("The time is now : "+ dateFormat.format(new Date()));

    }*/

}
