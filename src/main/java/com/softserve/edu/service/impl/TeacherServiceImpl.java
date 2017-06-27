package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.service.TeacherService;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public class TeacherServiceImpl implements TeacherService {
    public void addTeacher(Teacher teacher) {
        DaoFactory.getInstance().getTeacherDao().addElement(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        DaoFactory.getInstance().getTeacherDao().updateElement(teacher);
    }

    public Teacher getTeacherById(int teacherId) {
        return DaoFactory.getInstance().getTeacherDao().getElementById(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return DaoFactory.getInstance().getTeacherDao().getAllElements();
    }

    public void deleteTeacher(Teacher teacher) {
        DaoFactory.getInstance().getTeacherDao().deleteElement(teacher);
    }
}
