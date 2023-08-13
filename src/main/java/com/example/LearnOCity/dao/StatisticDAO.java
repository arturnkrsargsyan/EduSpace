package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Statistic;

import java.util.List;

public interface StatisticDAO {
    List<Statistic> getStatisticForTeacher(Integer id);

    List<Statistic> getStatisticForStudent(int id);
}
