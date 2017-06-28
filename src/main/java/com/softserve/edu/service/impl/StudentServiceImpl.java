package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Student;
import com.softserve.edu.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void addStudent(Student student) {
        DaoFactory.getInstance().getStudentDao().addElement(student);
    }

    @Override
    public void updateStudent(Student student) {
        DaoFactory.getInstance().getStudentDao().updateElement(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        return DaoFactory.getInstance().getStudentDao().getElementById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return DaoFactory.getInstance().getStudentDao().getAllElements();
    }

    @Override
    public void deleteStudent(Student student) {
        DaoFactory.getInstance().getStudentDao().deleteElement(student);
    }
}
