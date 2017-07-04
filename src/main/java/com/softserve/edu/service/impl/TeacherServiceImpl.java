package com.softserve.edu.service.impl;

import com.softserve.edu.dao.TeacherDao;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addElement(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateElement(teacher);
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getElementById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllElements();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteElement(teacher);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        return teacherDao.getTeacherByName(name);
    }
}
