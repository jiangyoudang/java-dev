package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World";
    }

    @RequestMapping("/about")
    @ResponseBody
    String about() {
        return "About";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
