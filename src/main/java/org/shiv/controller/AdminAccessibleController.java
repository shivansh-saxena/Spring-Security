package org.shiv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAccessibleController {
    @GetMapping("/admin")
    String helloAdmin()
    {
        return  "<h1>Hello to the admin !!</h1>";
    }
}
