package com.softserve.edu.service;

import com.softserve.edu.model.Subject;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface SubjectService {
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    Subject getSubjectById(int subjectId);
    List<Subject> getAllSubjects();
    void deleteSubject(Subject subject);
    Subject getSubjectByName(String subjectName);
}
