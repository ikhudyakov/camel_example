package com.example.camel_example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@RequestMapping("/*")
public class DefaultController {

    @PostMapping
    public void defaultPost() {
    }

    @GetMapping
    public void defaultGet() {
    }

    @PutMapping
    public void defaultPut() {
    }

    @DeleteMapping
    public void defaultDelete() {
    }
}
