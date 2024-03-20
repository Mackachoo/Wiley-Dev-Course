package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Item;

import java.util.List;

public interface ServiceLayer {

    void createStudent(Item item) throws
            DuplicateIdException,
            DataValidationException,
            PersistenceException;

    List<Item> getAllStudents() throws
            PersistenceException;

    Item getStudent(String studentId) throws
            PersistenceException;

    Item removeStudent(String studentId) throws
            PersistenceException;

}
