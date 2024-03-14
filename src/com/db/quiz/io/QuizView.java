package com.db.quiz.io;

import java.util.ArrayList;
import java.util.List;

public class QuizView {
    UserIO io = new UserIOImpl();

    public void welcome() {
        io.print(" ======= Student Quiz Scores ======= \n");
    }

    public int menu() {
        io.print("\n");
        io.print("1) View a list of students in the system");
        io.print("2) Add a student to the system");
        io.print("3) Remove a student from the system");
        io.print("4) View a list of quiz scores for a given student");
        io.print("5) View the average quiz score for a given student");
        io.print("6) Exit");

        return io.readInt("Choose action from menu:", 1, 6);
    }

    public void displayStudents(List<String> ids) {
        for (String id : ids) {
            io.print(id);
        }
        io.print("");
    }

    public String getId() {
        return io.readString("Enter student id: ");
    }

    public List<Integer> getScores() {
        List<Integer> output = new ArrayList<>();
        String[] scores = io.readString("Enter scores delimetered by a space:").split(" +");
        for (String score : scores) {
            try {
                output.add(Integer.parseInt(score));
            } catch (NumberFormatException ignored) {

            }
        }
        return output;
    }

    public void invalid() {
        io.print("Invalid Entry");
    }

    public void exit() {
        io.print("Exiting program...");
    }

    public void removed() {
        io.print("Student removed...");
    }

    public void displayScores(String id, List<Integer> scores) {
        io.print("Student " + id + ":");
        io.print(scores.toString());
    }

    public void displayAvg(String id, double average) {
        io.print("Student " + id + " : " + average);
    }
}
