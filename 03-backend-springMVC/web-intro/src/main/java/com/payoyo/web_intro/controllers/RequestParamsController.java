package com.payoyo.web_intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.web_intro.models.dto.ParamDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false) String message){
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamDTO bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDTO params = new ParamDTO();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamDTO request(HttpServletRequest request){

        ParamDTO params = new ParamDTO();

        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        }catch (NumberFormatException e){}
        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }
    
}
