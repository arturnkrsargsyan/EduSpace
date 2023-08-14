package com.example.LearnOCity.services;

import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.dto.TestAnswerCheckDTO;
import com.example.LearnOCity.models.Question;
import com.example.LearnOCity.models.Test;

import java.util.List;
import java.util.Map;

public interface TestService {

    List<Test> getAll();

    double check(int testId, Map<Integer, Integer> map);

    List<Question> getByCount(int id, int count);

    ResultDTO save(Test test);
}
