package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.StatisticDTO;
import com.example.LearnOCity.models.Statistic;
import com.example.LearnOCity.services.StatisticService;
import com.example.LearnOCity.services.StatisticServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private final StatisticService statisticService;
    private final ModelMapper modelMapper;

    public StatisticController(StatisticServiceImpl statisticServiceImpl, ModelMapper modelMapper) {
        this.statisticService = statisticServiceImpl;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public List<StatisticDTO> getStatistic(@PathVariable("id") int id) {//TODO teacher statistic and student statistics are different
        return statisticService.getStatistic(id).stream()
                .map(this::convertToStatisticDTO)
                .collect(Collectors.toList());
    }

    private StatisticDTO convertToStatisticDTO(Statistic statistic) {
        return modelMapper.map(statistic,StatisticDTO.class);
    }

}
