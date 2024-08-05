package com.elice.Spring_Practice.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/greeting")
    public String getIndexPage(){
        return "index";
    }

}