package io.khasang.enterprise.config;

import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.ExampleMySqlDump;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean
    public Client client(){
        return new Client();
    }

    @Bean
    public ExampleMySqlDump exampleMySqlDump(){
        return new ExampleMySqlDump();
    }
}
