package com.example.annotationdel.controller;

import com.example.annotationdel.validation.ann.ParameterChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("")
public class Controller {

    @GetMapping("/{text}")
    public String get(@ParameterChecker @PathVariable("text") String text) {

        return "name_surname" + text;
    }
}