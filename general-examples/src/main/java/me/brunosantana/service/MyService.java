package me.brunosantana.service;

import me.brunosantana.utils.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    NameGenerator nameGenerator;

    public String getGeneratedName(){
        return nameGenerator.getName();
    }

}
