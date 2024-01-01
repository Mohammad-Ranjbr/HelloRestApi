package com.mycompany.api.controller;

import com.mycompany.api.payload.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ApiController {

//    @GetMapping("/api/hello")
//    public String hello(){
//        return "Hello World REST API , The current time is : " + new Date();
//    }

    @GetMapping("/api/hello")
    public ApiResponse hello(){
        return new ApiResponse("Hello World REST API",String.valueOf(new Date()));
    }

}
