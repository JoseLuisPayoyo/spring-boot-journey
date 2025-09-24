package com.payoyo.web_intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({"", "/", "/home"})
    public String home (){
        return "redirect:/details";
    }

}
