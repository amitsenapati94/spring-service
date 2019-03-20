package com.springservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetryServiceDelegate implements RetryService {


    @Autowired
    RestTemplate restTemplate;

    @Override
    public String retryService() {
        String url = "http://localhost:40043/database/data";
        System.out.println("how many times will this be printed");

        String response = (String) restTemplate.getForObject(url,String.class);

        return response;
    }

    @Override
    public String getBackendResponseFallback(Throwable e) {

        System.out.println("All retries Completed, so Fallback method called!!");


        return "fallback";
    }
}
