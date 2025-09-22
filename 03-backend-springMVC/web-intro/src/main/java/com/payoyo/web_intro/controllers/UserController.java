package com.payoyo.web_intro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.payoyo.web_intro.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Jose Luis", "Rodriguez");

        model.addAttribute("tittle", "Hola Spring");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users = new ArrayList<>();

        model.addAttribute("users", users);
        model.addAttribute("tittle", "Listado de usuarios");

        return "list";
    }
    
}
