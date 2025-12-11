package com.example.spring_tests.controllers;

import com.example.spring_tests.clients.CatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {
    @Autowired
    CatClient catClient;

    @GetMapping("/get-fact")
    public String getFact() {
        return catClient.getCatFact();
    }
}
