package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Student;

import java.util.List;

public interface ServiceLayer {

    void createStudent(Student student) throws
            DuplicateIdException,
            DataValidationException,
            PersistenceException;

    List<Student> getAllStudents() throws
            PersistenceException;

    Student getStudent(String studentId) throws
            PersistenceException;

    Student removeStudent(String studentId) throws
            PersistenceException;

}
