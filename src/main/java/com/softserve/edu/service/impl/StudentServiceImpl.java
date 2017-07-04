package com.softserve.edu.service.impl;

import com.softserve.edu.dao.StudentDao;
import com.softserve.edu.model.Student;
import com.softserve.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addElement(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateElement(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.getElementById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllElements();
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteElement(student);
    }

    @Override
    public Student getStudentByLastName(String lastName) {
        return studentDao.getStudentByLastName(lastName);
    }
}
