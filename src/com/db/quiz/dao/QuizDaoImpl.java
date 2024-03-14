package com.db.quiz.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizDaoImpl implements QuizDao{
    Map<String, List<Integer>> studentscores = new HashMap<>();

    @Override
    public List<String> getAllStudents() {
        return new ArrayList<>(studentscores.keySet());
    }

    @Override
    public void addStudent(String id) {
        studentscores.put(id, new ArrayList<>());
    }

    @Override
    public  void removeStudent(String id) {
        studentscores.remove(id);
    }

    @Override
    public void addScore(String id, Integer score) {
        studentscores.get(id).add(score);
    }

    @Override
    public List<Integer> getScores(String id) {
        return studentscores.get(id);
    }
}
