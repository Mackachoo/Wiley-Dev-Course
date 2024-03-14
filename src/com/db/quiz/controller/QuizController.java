package com.db.quiz.controller;

import com.db.quiz.dao.QuizDao;
import com.db.quiz.dao.QuizDaoImpl;
import com.db.quiz.io.QuizView;

import java.util.ArrayList;
import java.util.List;

public class QuizController {
    QuizView view = new QuizView();
    QuizDao dao = new QuizDaoImpl();

    public void run() {
        view.welcome();
        boolean exited = false;

        while (!exited) {
            int choice = view.menu();
            switch (choice) {
                case 1:
                    viewAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewQuizScores();
                    break;
                case 5:
                    calcAvgQuizScores();
                    break;
                case 6:
                    exited = true;
                    break;
                default:
                    view.invalid();

            }
        }
        view.exit();
    }

    private void viewAllStudents() {
        List<String> ids = dao.getAllStudents();
        view.displayStudents(ids);
    }

    private void addStudent() {
        String id = view.getId();
        dao.addStudent(id);
        for (int score : view.getScores()) {
            dao.addScore(id, score);
        }
    }

    private void removeStudent() {
        String id = view.getId();
        dao.removeStudent(id);
        view.removed();
    }

    private void viewQuizScores() {
        String id = view.getId();
        List<Integer> scores = dao.getScores(id);
        view.displayScores(id, scores);
    }

    private void calcAvgQuizScores() {
        String id = view.getId();
        List<Integer> scores = dao.getScores(id);
        double average = (double) scores.stream().reduce(0, Integer::sum) / scores.size();
        view.displayAvg(id, average);

    }

}
