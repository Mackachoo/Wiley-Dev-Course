package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Student;
import com.sg.vendingmachine.service.DataValidationException;
import com.sg.vendingmachine.service.DuplicateIdException;
import com.sg.vendingmachine.service.ServiceLayer;
import com.sg.vendingmachine.ui.View;

import java.util.List;

public class Controller {

    private final View view;
    private ServiceLayer service;

    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                // Why would you make a stepper function that has zero extra logic or organisation?
                menuSelection = view.printMenuAndGetSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            }
            view.displayExitBanner();
        } catch (PersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createStudent() throws PersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DuplicateIdException | DataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listStudents() throws PersistenceException {
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws PersistenceException {
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId) ;
        view.displayStudent(student);
    }

    private void removeStudent() throws PersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }


}
