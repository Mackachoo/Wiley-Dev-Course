package com.db.quiz.dao;

import java.util.List;

public interface QuizDao {

    public List<String> getAllStudents();
    public void addStudent(String id);
    public  void removeStudent(String id);
    public void addScore(String id, Integer score);
    public List<Integer> getScores(String id);

}
