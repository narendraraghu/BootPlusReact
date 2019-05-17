package com.narendra.java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @GetMapping("/requestParams")
    public String requestParams(@RequestParam String color, @RequestParam String weight) {
        return "The color is " + color + ", the weight is " + weight;
    }

    @GetMapping("/{first}/{second}")
    public String pathVariables(@PathVariable String first, @PathVariable String second) {
        return "The first is " + first + ", the second is " + second;
    }

}
