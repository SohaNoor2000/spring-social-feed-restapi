package com.springboot.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiVersioningController {

    @GetMapping(path = "/Uri/v1")
    public String ApiVersionURI(){
        return "Hello-World-v1";
    }

    @GetMapping(path = "/Uri/v2")
    public String ApiVersionURI2(){
        return "Hello-World-v2";
    }

    @GetMapping(path = "/RequestParam", params="Version=1")
    public String ApiVersionRequestParam1(){
        return "Hello-World-RequestParam-v1";
    }

    @GetMapping(path = "/RequestParam", params="Version=2")
    public String ApiVersionRequestParam2(){
        return "Hello-World-RequestParam-v2";
    }

    @GetMapping(path = "/RequestHeader", headers = "API_VERSION=1")
    public String ApiVersionHeader1(){
        return "Hello-World-RequestHeader-v1";
    }

    @GetMapping(path = "/RequestHeader", headers = "API_VERSION=2")
    public String ApiVersionHeader2(){
        return "Hello-World-RequestHeader-v2";
    }

    @GetMapping(path = "/MediaType", produces = "application/v1+json")
    public String ApiVersionMediaType1(){
        return "Hello-World-MediaType-v1";
    }

    @GetMapping(path = "/MediaType", produces = "application/app-v2+json")
    public String ApiVersionMediaType2(){
        return "Hello-World-MediaType-v2";
    }







}
