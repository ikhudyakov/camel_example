package com.example.camel_example.controller;

import com.example.camel_example.service.CamelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private CamelService camelService;

    @PostMapping("/order")
    public void addOrder(@RequestBody String order, HttpServletResponse response) {
        boolean status;
        status = camelService.SendToKafka(order);
        if (status) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
