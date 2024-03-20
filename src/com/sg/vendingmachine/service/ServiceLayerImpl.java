package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

public class ServiceLayerImpl implements
        ServiceLayer {

    private Dao dao;


    public ServiceLayerImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void createStudent(Item item) throws
            DuplicateIdException,
            DataValidationException,
            PersistenceException {

        // First check to see if there is already a student
        // associated with the given student's id
        // If so, we're all done here -
        // throw a ClassRosterDuplicateIdException
        if (dao.getStudent(item.getStudentId()) != null) {
            throw new DuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + item.getStudentId()
                            + " already exists");
        }

        // Now validate all the fields on the given Student object.
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(item);

        // We passed all our business rules checks so go ahead
        // and persist the Student object
        dao.addStudent(item.getStudentId(), item);

        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry(
                "Student " + item.getStudentId() + " CREATED.");

    }

    @Override
    public List<Item> getAllStudents() throws
            PersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Item getStudent(String studentId) throws
            PersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Item removeStudent(String studentId) throws PersistenceException {
        Item removedItem = dao.removeStudent(studentId);
        // Write to audit log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedItem;
    }

    private void validateStudentData(Item item) throws
            DataValidationException {

        if (item.getFirstName() == null
                || item.getFirstName().trim().isEmpty()
                || item.getLastName() == null
                || item.getLastName().trim().isEmpty()
                || item.getCohort() == null
                || item.getCohort().trim().isEmpty()) {

            throw new DataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

}

