package me.brunosantana.config;

import me.brunosantana.utils.NameGenerator;
import me.brunosantana.utils.RandomNameGenerator;
import me.brunosantana.utils.TestNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class NameConfig {

    //Use the VM argument: -Dspring.profiles.active=test
    //https://www.baeldung.com/spring-profiles

    @Bean
    //@Primary
    @Profile("!test")
    public NameGenerator nameGenerator(){
        return new RandomNameGenerator();
    }

    @Bean
    @Profile("test")
    public NameGenerator nameGeneratorTest(){
        return new TestNameGenerator();
    }


}
