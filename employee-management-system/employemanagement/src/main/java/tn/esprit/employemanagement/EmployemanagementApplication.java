package tn.esprit.employemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmployemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployemanagementApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Allow all endpoints
                    .allowedOrigins("http://localhost:3000")  // Your React frontend URL
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                    .allowedHeaders("*")  // All headers
                    .allowCredentials(true)  // Allow cookies if needed
                    .maxAge(3600);  // Cache preflight requests for 1 hour
            }
        };
    }
}