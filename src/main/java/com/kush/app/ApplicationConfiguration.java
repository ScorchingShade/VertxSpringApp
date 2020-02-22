package com.kush.app;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Ankush @ ScorchingShade
 *
 * The class acts as a configuration helper for the spring boot application
 */
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    public Vertx vertx=Vertx.vertx();

    public String applicationName() {
        return environment.getProperty("spring.application.name");
    }

    public int httpPort() {
        return environment.getProperty("server.port", Integer.class);
    }

}
