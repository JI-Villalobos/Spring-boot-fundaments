package com.fundaments.boot.fundaments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Tested controller 2.1.1.2", HttpStatus.OK);
    }
}
