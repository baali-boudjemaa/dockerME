package com.example.dockerME.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String get(){
        System.out.println("did");
        return "ddsd";
    }
}
