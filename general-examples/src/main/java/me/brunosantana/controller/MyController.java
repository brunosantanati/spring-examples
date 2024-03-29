package me.brunosantana.controller;

import me.brunosantana.model.Person;
import me.brunosantana.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //How to use Log4j2 in Spring Boot -> https://www.youtube.com/watch?v=S9USRSEyWU0
    //log4j2.xml example -> https://mkyong.com/logging/log4j2-xml-example/
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @PostMapping("ignore-unknown")
    public void ignoreUnknown(@RequestBody Person person){

        System.out.println(person);
        logger.debug("Logging a person: " + person);
        logger.debug("Spring version: " + SpringVersion.getVersion());

    }

    @GetMapping("throw-exception")
    public String throwException() throws Exception {
        return myService.throwException();
    }

}
