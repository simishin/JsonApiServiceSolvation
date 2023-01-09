package org.top.jsonapiservicesolvation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.jsonapiservicesolvation.logic.ISolvator;
import org.top.jsonapiservicesolvation.logic.SolvatorImpl;


// класс-конфиг для DI
@Configuration
public class AppConfig {
    // бин для решателя
    @Bean
    ISolvator solvator() {
        return new SolvatorImpl();
    }
}
