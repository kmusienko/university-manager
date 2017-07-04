package com.softserve.edu.service.impl;

import com.softserve.edu.dao.FacultyDao;
import com.softserve.edu.model.Faculty;
import com.softserve.edu.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyDao facultyDao;

    @Autowired
    public FacultyServiceImpl(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyDao.addElement(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        facultyDao.updateElement(faculty);
    }

    @Override
    public Faculty getFacultyById(int facultyId) {
        return facultyDao.getElementById(facultyId);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyDao.getAllElements();
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyDao.deleteElement(faculty);
    }

    @Override
    public Faculty getFacultyByName(String facultyName) {
        return facultyDao.getFacultyByName(facultyName);
    }
}
