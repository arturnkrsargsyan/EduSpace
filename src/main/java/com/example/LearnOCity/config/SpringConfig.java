package com.example.LearnOCity.config;

import com.example.LearnOCity.dao.UserDAO;
import com.example.LearnOCity.dao.UserDAOImpl;
import com.example.LearnOCity.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
@SpringBootConfiguration
public class SpringConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
}
