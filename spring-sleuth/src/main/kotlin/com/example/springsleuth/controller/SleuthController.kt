package com.example.springsleuth.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SleuthController {

    private val logger = LoggerFactory.getLogger(javaClass);

    @GetMapping("/")
    public fun helloSleuth(): String {
        logger.info("Hello Sleuth");
        return "success!";
    }

}

