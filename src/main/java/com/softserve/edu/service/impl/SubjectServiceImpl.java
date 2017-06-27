package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Subject;
import com.softserve.edu.service.SubjectService;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public class SubjectServiceImpl implements SubjectService {
    @Override
    public void addSubject(Subject subject) {
        DaoFactory.getInstance().getSubjectDao().addElement(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        DaoFactory.getInstance().getSubjectDao().updateElement(subject);
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        return  DaoFactory.getInstance().getSubjectDao().getElementById(subjectId);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return  DaoFactory.getInstance().getSubjectDao().getAllElements();
    }

    @Override
    public void deleteSubject(Subject subject) {
        DaoFactory.getInstance().getSubjectDao().deleteElement(subject);
    }
}
