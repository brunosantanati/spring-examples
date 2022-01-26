package me.brunosantana.service;

import me.brunosantana.config.TestNameConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(TestNameConfig.class)
//@ActiveProfiles("test") //Do not activate test profile, use default profile
public class MyServiceTest2 {

    @Autowired
    MyService service;

    @Test
    public void should_printNameSuccessfully(){
        String generatedName = service.getGeneratedName();
        System.out.println(generatedName);

        List<String> names = Arrays.asList("Bruno", "Paulo", "Marcelo", "Lucas");

        Assert.assertTrue(names.contains(generatedName));
    }
}
