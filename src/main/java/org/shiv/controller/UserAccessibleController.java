package org.shiv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccessibleController {
    @GetMapping("/user")
    String helloUser()
    {
        return  "<h1>Hello to the user !!</h1>";
    }
}
