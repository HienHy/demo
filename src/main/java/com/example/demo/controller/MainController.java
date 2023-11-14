package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {


    @GetMapping(value = "/")
    public ModelMap showHomePage(){
        return new ModelMap();
    }
}
