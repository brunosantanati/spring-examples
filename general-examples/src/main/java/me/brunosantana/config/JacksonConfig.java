package me.brunosantana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/*
https://github.com/spring-projects/spring-framework/issues/19575

We deliberately changed Jackson default configuration to DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES = false
as of Spring Framework 4.1 as detailed on #16510. See also the related discussion on this jackson issue.
 */

@Configuration
public class JacksonConfig {

    //You can easily bring back the old behavior using Jackson2ObjectMapperBuilder, for example if you are using Spring Boot add this bean in your @Configuration:
    @Bean
    public Jackson2ObjectMapperBuilder mapperBuilder() {
        return new Jackson2ObjectMapperBuilder().failOnUnknownProperties(true);
    }

}
