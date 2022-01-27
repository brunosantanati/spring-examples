package me.brunosantana.service;

import me.brunosantana.utils.NameGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest3 {

    @InjectMocks
    MyService service;
    
    @Mock
    NameGenerator nameGenerator;

    @Test
    public void should_printNameSuccessfully(){
        when(nameGenerator.getName()).thenReturn("Neo");
        
        String generatedName = service.getGeneratedName();
        System.out.println(generatedName);

        Assert.assertEquals("Neo", generatedName);
    }
}
