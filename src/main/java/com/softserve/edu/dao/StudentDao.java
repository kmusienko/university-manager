package com.softserve.edu.dao;

import com.softserve.edu.model.Student;

/**
 * Created by Kostya on 27.06.2017.
 */
public class StudentDao extends ElementDaoImpl<Student> {
    public StudentDao() {
        super(Student.class);
    }
}
