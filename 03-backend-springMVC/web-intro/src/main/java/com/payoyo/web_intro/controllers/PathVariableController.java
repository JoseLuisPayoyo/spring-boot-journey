package com.payoyo.web_intro.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.web_intro.models.User;
import com.payoyo.web_intro.models.dto.ParamDTO;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private List<String> usernamwe;

    @Value("#{'${config.username}'.toUpperCase()}")
    private List<String> username;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;
    
    @GetMapping("/baz/{message}/{code}")
    public ParamDTO baz(@PathVariable String message, @PathVariable Integer code) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        param.setCode(code);

        return param;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        //hacer un save en la db
        return user;
    }

    @GetMapping("/pp") 
    public List<String> str(){
        return username;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){
        return valuesMap;
    }

    @GetMapping("/product")
    public String product(){
        return product;
    }
}
