package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.util.List;

public class ClassRosterDaoFileImpl implements ClassRosterDao {
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will
     * return null.
     *
     * @param studentId id with which student is to be associated
     * @param student   student to be added to the roster
     * @return the Student object previously associated with the given
     * student id if it exists, null otherwise
     */
    @Override
    public Student addStudent(String studentId, Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a List of all students in the roster.
     *
     * @return List containing all students in the roster.
     */
    @Override
    public List<Student> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id,
     * null if no such student exists
     */
    @Override
    public Student getStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Removes from the roster the student associated with the given id.
     * Returns the student object that is being removed or null if
     * there is no student associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student
     * was associated with the given student id
     */
    @Override
    public Student removeStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
