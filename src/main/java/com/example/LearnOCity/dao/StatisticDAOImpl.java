package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Statistic;
import com.example.LearnOCity.models.Test;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticDAOImpl implements StatisticDAO {

    private final String GET_STAT_QUERY_FOR_TEACHER = "select  * from \"user\" " +
            "join test t on \"user\".category_id = t.category_id " +
            "join statistic s on t.id = s.test_id where \"user\".id = 2";
    private final String GET_STAT_QUERY="SELECT * from statistic where user_id=?";
    private final String GET_BY_ID = "select  * from statistic where user_id=?";

    @Override
    public List<Statistic> getStatisticForTeacher(Integer id) {
        List<Statistic> statistics = new ArrayList<>();
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(GET_STAT_QUERY)) {
            Statistic statistic;
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            while (resultSet.next()) {
                statistic = new Statistic();
                enrichStatistic(resultSet, statistic);
                statistics.add(statistic);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return statistics;
    }

    @Override
    public List<Statistic> getStatisticForStudent(int id) {
        List<Statistic> statistics = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(GET_BY_ID)) {
            Statistic statistic = new Statistic();
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            while (resultSet.next()) {
                statistic = new Statistic();
                enrichStatistic(resultSet, statistic);
                statistics.add(statistic);
            }
            enrichStatistic(resultSet, statistic);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statistics;
    }

    private Test enrichTest(ResultSet resultSet, Test test) {
        try {
            test.setId(resultSet.getInt("t.id"));
            test.setName(resultSet.getString("t.name"));
            test.setImage(null);
            test.setDescription(resultSet.getString("description"));
            test.setCategoryId(resultSet.getInt("t.category_id"));
            test.setOwnerID(resultSet.getInt("t.user_id"));
            test.setQuestionList(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return test;
    }

    private void enrichStatistic(ResultSet resultSet, Statistic statistic) {
        try {
            statistic.setTest(enrichTest(resultSet,new Test()));
            statistic.setId(resultSet.getInt("id"));
            statistic.setStudentId(resultSet.getInt("user_id"));
            statistic.setAverageMark(resultSet.getDouble("average_mark"));
            statistic.setDate(resultSet.getLong("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
