package com.springservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCallWithHysterix {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getData_fallback")
    public String getData(){

        String url = "http://localhost:40043/database/data";

        String response = (String) restTemplate.getForObject(url,String.class);

        return response;
    }

    private String getData_fallback(){
        System.out.println("servie is down!! fallback route invoked..");
        System.out.println("Circuit breaker enabled:: no response from calling service");
        return "hysterix fall back method response";
    }
}
