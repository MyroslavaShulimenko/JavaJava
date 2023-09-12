package com.example.annotation1209.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/{text}")
    public String get(@PathVariable String text){
        return " ++++++   "+text;
    }
}
