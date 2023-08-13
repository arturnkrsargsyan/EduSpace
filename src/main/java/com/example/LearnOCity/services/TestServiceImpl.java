package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.TestDAO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.dto.TestAnswerCheckDTO;
import com.example.LearnOCity.models.Question;
import com.example.LearnOCity.models.Test;
import com.example.LearnOCity.validations.TestValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {
    private final TestDAO testDAO;
    private final TestValidation testValidation;

    public TestServiceImpl(TestDAO testDAO, TestValidation testValidation) {
        this.testDAO = testDAO;
        this.testValidation = testValidation;
    }

    @Override
    public List<Test> getAll() {
        return this.testDAO.getAll();
    }

    @Override
    public List<TestAnswerCheckDTO> check(int id, Map<Integer, Integer> list) {
        return null;
    }

    @Override
    public List<Question> getByCount(int id, int count) {
        List<Question> questionList = (this.testDAO.getById(id)).getQuestionList();

        return getRandomQuestions(count, questionList);
    }

    private List<Question> getRandomQuestions(int count, List<Question> questionList) { //TODO random patasxanner
        Random rand = new Random();
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(questionList.size());
            list.add(questionList.get(randomIndex));
            questionList.remove(randomIndex);
        }
        return list;
    }

    @Override
    public ResultDTO save(Test test) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setValidations(testValidation.validate(test));
        if (resultDTO.getValidations().isEmpty()) {
            test.setId(testDAO.save(test));
            resultDTO.setSuccess(true);
        }
        return resultDTO;
    }

}
