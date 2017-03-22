package io.khasang.enterprise.config.application;

import io.khasang.enterprise.service.NewsService;
import org.springframework.context.annotation.Bean;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
}
