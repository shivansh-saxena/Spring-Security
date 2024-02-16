package org.shiv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String defaultEndpoint()
    {
        return "<h1>Hello from the default page !!</h1>";
    }
}
