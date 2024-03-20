package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Student;

import java.io.*;
import java.util.*;

public class DaoFileImpl implements Dao {

    private Map<String, Student> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";


    @Override
    public Student addStudent(String studentId, Student student)  throws PersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }


    @Override
    public List<Student> getAllStudents()
            throws PersistenceException {
        loadRoster();
        return new ArrayList(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws PersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
            throws PersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    private void loadRoster() throws PersistenceException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        Student currentStudent;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = Student.parseStudent(currentLine);

            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }

    private void writeRoster() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new PersistenceException(
                    "Could not save student data.", e);
        }

        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            studentAsText = currentStudent.toString();
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }

}
