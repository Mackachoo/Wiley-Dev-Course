package com.sg.vendingmachine.dto;

public class Student {
    private String firstName;
    private String lastName;
    private final String studentId;
    // Programming Language + cohort month/year
    private String cohort;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    @Override
    public String toString() {
        String studentAsText = getStudentId() + "::";

        studentAsText += getFirstName() + "::";
        studentAsText += getLastName() + "::";
        studentAsText += getCohort();

        return studentAsText;

    }

    public static Student parseStudent(String s) {
        String[] studentTokens = s.split("::");

        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);

        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);

        return studentFromFile;

    }

}
