package com.softserve.edu.service.impl;

import com.softserve.edu.dao.SubjectDao;
import com.softserve.edu.model.Subject;
import com.softserve.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subjectDao;

    @Autowired
    public SubjectServiceImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public void addSubject(Subject subject) {
        subjectDao.addElement(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDao.updateElement(subject);
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        return subjectDao.getElementById(subjectId);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllElements();
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectDao.deleteElement(subject);
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        return subjectDao.getSubjectByName(subjectName);
    }
}
