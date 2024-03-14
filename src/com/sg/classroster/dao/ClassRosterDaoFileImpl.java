package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.io.*;
import java.util.*;

public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<String, Student> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";


    @Override
    public Student addStudent(String studentId, Student student)  throws ClassRosterDaoException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }


    @Override
    public List<Student> getAllStudents()
            throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterDaoException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException(
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

    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException(
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
