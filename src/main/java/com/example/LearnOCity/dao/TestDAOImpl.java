package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Question;
import com.example.LearnOCity.models.Test;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDAOImpl implements TestDAO {
    private final String INSERT_TEST_QUERY = "insert into test(image,description,userId,categoryId) values (?,?,?,?) returning id";
    private final String INSERT_QUESTIONS_QUERY = "insert into questions(testId,question,answers,rightAnswersNumber,mark,createdAt) values (?,?,?,?,?,?)";
    private final String GET_TEST = "select * from test ";
    private final String GET_BY_ID = "select * from test where id=?";
    private final String GET_QUESTION_BY_TEST_ID = "select * from question where test_id=?;";

    public TestDAOImpl() {
    }

    @Override
    public int save(Test test) {
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(INSERT_TEST_QUERY)) {
            this.enrichStatement(test, statement);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            enrichTest(resultSet, test);
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void saveQuestions(Test test, Question question) {
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(INSERT_QUESTIONS_QUERY)) {
            this.enrichStatement(test, statement);
            this.enrichStatementByQuestions(question, test, statement);
            test.getQuestionList().add(question);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Test> getAll() {
        List<Test> testList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(GET_TEST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                testList.add((Test) resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return testList;
    }

    @Override
    public Test getById(int id) {
        ResultSet resultSet;
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(GET_BY_ID)) {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return (Test) resultSet;
    }

    @Override
    public List<Question> getQuestionsByTestId(int id) {
        Question question = new Question();
        List<Question> questions = new ArrayList<>();
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(GET_QUESTION_BY_TEST_ID)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                enrichQuestion(resultSet, question);
                questions.add(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return questions;
    }

    private void enrichStatementByQuestions(Question question, Test test, PreparedStatement statement) {
        try {
            statement.setInt(1, save(test));
            statement.setString(2, question.getQuestion());
            statement.setString(3, question.getAnswers().toString());
            statement.setInt(4, question.getRightAnswersNumber());
            statement.setDouble(5, question.getMark());
            statement.setLong(6, question.getCreatedAt());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void enrichStatement(Test test, PreparedStatement statement) {
        try {
            statement.setBytes(1, test.getImage());
            statement.setString(2, test.getDescription());
            statement.setInt(3, test.getOwnerID());
            statement.setInt(4, test.getCategoryId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void enrichTest(ResultSet resultSet, Test test) {
        try {
            resultSet.next();
            test.setId(resultSet.getInt("id"));
            test.setImage(resultSet.getBytes("image"));
            test.setDescription(resultSet.getString("description"));
            test.setOwnerID(resultSet.getInt("userId"));
            test.setCategoryId(resultSet.getInt("categoryId"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void enrichQuestion(ResultSet resultSet, Question question) {
        try {
            Map<Integer, String> map = new HashMap<>();
            String[] answers = (String[]) (resultSet.getArray("answers").getArray());

            for (int i = 0, j = 1; i < answers.length; i++, j++) {
                map.put(j, answers[i]);
            }

            resultSet.getArray("answers");
            resultSet.next();
            question.setTestId(resultSet.getInt("testId"));
            question.setQuestion(resultSet.getString("question"));
            question.setAnswers(map);
            question.setMark(resultSet.getDouble("mark"));
            question.setRightAnswersNumber(resultSet.getInt("rightAnswersNumber"));
            question.setCreatedAt(resultSet.getLong("createdAt"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

