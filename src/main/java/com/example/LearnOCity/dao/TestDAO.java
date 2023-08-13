package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Test;

import java.util.List;

public interface TestDAO {

    int save(Test test);

    List<Test> getAll();
    Test getById(int id);
}
