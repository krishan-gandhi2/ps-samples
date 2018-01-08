package com.pupilsky.tutorials.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Krishan.Gandhi on 08/01/2018.
 */
@SpringBootApplication
public class SampleApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(SampleApplication.class);
    }

}
