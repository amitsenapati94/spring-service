package com.springservice.controller;

import com.springservice.service.ServiceCallWithHysterix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordering")
public class HysterixServiceController {

    @Autowired
    private ServiceCallWithHysterix serviceCallWithHysterix;


    @GetMapping("dataFromHysterixEnabledService")
    public String getDataFromHysterixEnabledService(){

        return serviceCallWithHysterix.getData();

    }

}
