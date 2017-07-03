package com.softserve.edu.service;

import com.softserve.edu.model.Student;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface StudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
    void deleteStudent(Student student);
    Student getStudentByLastName(String lastName);
}
