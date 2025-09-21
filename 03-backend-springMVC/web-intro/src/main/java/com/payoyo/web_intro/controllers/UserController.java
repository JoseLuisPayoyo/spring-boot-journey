package com.payoyo.web_intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("tittle", "Hola Spring");
        model.addAttribute("name", "Jose Luis");
        model.addAttribute("lastname", "Rodriguez");

        return "details";
    }
    
}
