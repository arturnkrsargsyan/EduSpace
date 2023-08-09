package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.StatisticDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @GetMapping("/{id}")
    public List<StatisticDTO> getStatistic(@PathVariable("id") int id){
        return null;
    }
}
