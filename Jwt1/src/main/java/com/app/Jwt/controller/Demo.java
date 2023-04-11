package com.app.Jwt.controller;


import com.app.Jwt.model.AppData;
import com.app.Jwt.model.AppDataResponse;
import com.app.Jwt.model.User;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class Demo {

    @PostMapping("/generate")
    public ResponseEntity<String> generate(@RequestBody AppData appData) throws ParseException {
        String url = "http://10.65.0.81:8443/apis/v1/admin/api-keys";
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.add("accept", "application/json");
        header.add("X-API-KEY", "20c84287-cb7b-4892-9dc6-2c66b676d0fc");
        header.add("X-APP-ID", "ADMIN");
        header.add("Content-Type", "application/json");


        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("appName", appData.getAppName());
        body.add("appId", appData.getAppId());
        body.add("validTill", appData.getValidTill().toString());
        body.add("ownerEmails", appData.getOwnerEmails().toString());

        System.out.println("Request body is" + body);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, header);

        response = restTemplate.postForEntity(url , entity , String.class);

        System.out.println(response);
//        AppDataResponse appDataResponse = new AppDataResponse();
//        appDataResponse.setKey(re);
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
