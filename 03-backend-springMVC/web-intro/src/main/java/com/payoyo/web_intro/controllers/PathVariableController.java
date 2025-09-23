package com.payoyo.web_intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.web_intro.models.dto.ParamDTO;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    
    @GetMapping("/baz/{message}/{code}")
    public ParamDTO baz(@PathVariable String message, @PathVariable Integer code) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        param.setCode(code);

        return param;
    }
}
