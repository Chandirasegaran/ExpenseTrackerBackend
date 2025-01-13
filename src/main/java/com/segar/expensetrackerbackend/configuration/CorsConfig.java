package com.segar.expensetrackerbackend.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS requests from the frontend (localhost:5173) and allow specific methods
        registry.addMapping("/**")  // Allow CORS for all endpoints
                .allowedOrigins("http://localhost:5173",
                       "https://expensetracker-segar.vercel.app")  // Frontend origin
                .allowedMethods("GET", "POST", "DELETE" , "PUT")  // Allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow cookies/credentials if needed
    }
}
