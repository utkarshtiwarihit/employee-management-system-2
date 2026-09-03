package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UserRepository userRepo) {
        return args -> {
            if (userRepo.findByEmail("admin@innereye.com").isEmpty()) {
                User hr = new User();
                hr.setName("Corporate HR");
                hr.setDesignation("People Lead");
                hr.setEmail("admin@innereye.com");
                hr.setPassword("admin123");
                hr.setRole("HR");
                hr.setLeavesTaken(0.0);
                userRepo.save(hr);

                User emp = new User();
                emp.setName("Harsh");
                emp.setDesignation("Backend Engineer");
                emp.setEmail("harsh@innereye.com");
                emp.setPassword("harsh123");
                emp.setRole("EMPLOYEE");
                emp.setLeavesTaken(0.0);
                userRepo.save(emp);
            }
        };
    }
}