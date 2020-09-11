package com.baeldung;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringHypermediaApiApplication.class)
@WebAppConfiguration
public class SpringHypermediaApiApplicationTests {

    @Test
    public void contextLoads() {
    }

}
