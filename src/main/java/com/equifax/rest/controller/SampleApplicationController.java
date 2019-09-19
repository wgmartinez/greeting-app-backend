package com.equifax.rest.controller;

import com.equifax.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/1.0")
public class SampleApplicationController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/{country}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addIdentity(@PathVariable(name = "country") String country, @PathVariable(name = "name") String name) {
        return greetingService.greet(country, name);
    }
}
