package com.bangle.weather.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("application.properties")
public class ProjectProperties {
    @Autowired
    private Environment env;

    public String getProperty(String name) {
        return env.getProperty(name);
    }
}