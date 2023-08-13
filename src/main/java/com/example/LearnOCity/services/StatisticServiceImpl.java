package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.StatisticDAO;
import com.example.LearnOCity.models.Statistic;
import com.example.LearnOCity.validations.StatisticValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    private final StatisticDAO statisticDAO;
    private final StatisticValidation statisticValidation;
    private final UserService userService;

    public StatisticServiceImpl(StatisticDAO statisticDAO, StatisticValidation statisticValidation, UserService userService) {
        //TODO , WHY
        this.statisticDAO = statisticDAO;
        this.statisticValidation = statisticValidation;
        this.userService = userService;
    }

    @Override
    public List<Statistic> getStatistic(int id) {
        Statistic statistic = new Statistic();
        statisticValidation.validate(statistic);
        if (userService.getById(id).getType() == 1) {
            return statisticDAO.getStatisticForTeacher(id);
        }else {
            return statisticDAO.getStatisticForStudent(id);
        }
    }
}
