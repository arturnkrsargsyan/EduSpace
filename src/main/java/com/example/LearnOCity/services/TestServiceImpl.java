package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.TestDAO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.dto.TestAnswerCheckDTO;
import com.example.LearnOCity.models.Question;
import com.example.LearnOCity.models.Test;
import com.example.LearnOCity.validations.TestValidation;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public double check(int testId, Map<Integer, Integer> map) {
        double overallMark = 0;
        double mark = 0;
        List<Question> questionList = testDAO.getQuestionsByTestId(testId);
        Map<Integer, Question> rightAnswers = new HashMap<>();

        for (Question question : questionList) {
            if (map.containsKey(question.getId())) {
                rightAnswers.put(question.getId(), question);
            }
        }
        for (Question question : rightAnswers.values()) {
            overallMark += question.getMark();

            if (Objects.equals(question.getRightAnswersNumber(), map.get(question.getId()))) {
                mark += question.getMark();
            }
        }

        return mark / overallMark * 100;
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
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> keys = new ArrayList<>(list.get(i).getAnswers().keySet());
            Collections.shuffle(keys);
            for (int j = 0; j < keys.size(); j++) {
                map.put(keys.get(j), map.get(keys.get(j)));
            }
            list.get(i).setAnswers(map);
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
