package me.brunosantana.service;

import me.brunosantana.config.TestNameConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestNameConfig.class)
public class MyServiceTest {

    @Autowired
    MyService service;

    @Test
    public void should_printNameSuccessfully(){
        String generatedName = service.getGeneratedName();

        Assert.assertEquals("TestName", generatedName);
    }
}
