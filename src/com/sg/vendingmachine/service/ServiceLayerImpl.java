package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Student;

import java.util.List;

public class ServiceLayerImpl implements
        ServiceLayer {

    Dao dao;
    private AuditDao auditDao;


    public ServiceLayerImpl(Dao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws
            DuplicateIdException,
            DataValidationException,
            PersistenceException {

        // First check to see if there is already a student
        // associated with the given student's id
        // If so, we're all done here -
        // throw a ClassRosterDuplicateIdException
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new DuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + student.getStudentId()
                            + " already exists");
        }

        // Now validate all the fields on the given Student object.
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(student);

        // We passed all our business rules checks so go ahead
        // and persist the Student object
        dao.addStudent(student.getStudentId(), student);

        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry(
                "Student " + student.getStudentId() + " CREATED.");

    }

    @Override
    public List<Student> getAllStudents() throws
            PersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws
            PersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws PersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        // Write to audit log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }

    private void validateStudentData(Student student) throws
            DataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().isEmpty()
                || student.getLastName() == null
                || student.getLastName().trim().isEmpty()
                || student.getCohort() == null
                || student.getCohort().trim().isEmpty()) {

            throw new DataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

}

