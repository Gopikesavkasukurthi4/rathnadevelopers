package com.realestate.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // This maps any URL starting with /images/ to the physical 'uploads' directory
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:uploads/");
    }
}