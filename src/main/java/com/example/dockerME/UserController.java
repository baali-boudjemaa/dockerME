package com.example.dockerME;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class UserController {
    @GetMapping("/")
    public String get(){
        System.out.println("did");
        return "ddsd";
    }
}
