package com.softserve.edu.service;

import com.softserve.edu.model.Teacher;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface TeacherService {
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    Teacher getTeacherById(int teacherId);
    List<Teacher> getAllTeachers();
    void deleteTeacher(Teacher teacher);
}
