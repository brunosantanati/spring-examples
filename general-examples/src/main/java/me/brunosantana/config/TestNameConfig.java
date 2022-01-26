package me.brunosantana.config;

import me.brunosantana.utils.NameGenerator;
import me.brunosantana.utils.RandomNameGenerator;
import me.brunosantana.utils.TestNameGenerator;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class TestNameConfig {

    //@TestConfiguration and @Import:
    //https://mkyong.com/spring-boot/spring-boot-how-to-init-a-bean-for-testing/

    //Use this VM argument when running the unit tests: -Dspring.profiles.active=test
    //If you use @ActiveProfiles("test") in your test class, you don't need to provide the VM argument above.
    //You don't need to inform a profile when running the Application
    //https://www.baeldung.com/spring-profiles

    @Bean
    @Profile("test")
    public NameGenerator nameGeneratorTest(){
        return new TestNameGenerator();
    }


}
