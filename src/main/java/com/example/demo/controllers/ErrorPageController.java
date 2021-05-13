package com.example.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "forward:/something-bad";
    }
    @GetMapping("/something-bad")
    public String registration(){
        return "error";
    }
    @Override
    public String getErrorPath() {
        return PATH;
    }
}