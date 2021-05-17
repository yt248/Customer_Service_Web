package com.eugene.spring.boot.web.customer_service_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("/")
    public String helloCustomer(Model model){
        model.addAttribute("hello", "Hello Customer!");
        return "hello-page";
    }

}
