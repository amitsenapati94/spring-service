package com.springservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import javax.json.*;

@RestController
@RequestMapping("/audit")
public class AuditController {


    @PostMapping(value="data", produces = "application/json")
    public String createAudit( @RequestBody String auditRequest) {

        System.out.println("inside call");
        System.out.println("request: "+auditRequest);

        return "success";

    }


}
