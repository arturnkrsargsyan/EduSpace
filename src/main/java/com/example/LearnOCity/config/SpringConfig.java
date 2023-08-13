package com.example.LearnOCity.config;

import com.example.LearnOCity.dao.*;
import com.example.LearnOCity.validations.StatisticValidation;
import com.example.LearnOCity.validations.TestValidation;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SpringConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public CategoryDAO categoryDAO() {
        return new CategoryDAOImpl();
    }

    @Bean
    public StatisticDAO statisticDAO() {
        return new StatisticDAOImpl();
    }

    @Bean
    public StatisticValidation statisticValidation() {
        return new StatisticValidation();
    }

    @Bean
    public TestDAO testDAO() {
        return new TestDAOImpl();
    }

    @Bean
    public TestValidation testValidation() {
        return new TestValidation();
    }
}
