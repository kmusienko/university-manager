package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Faculty;
import com.softserve.edu.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
@Service
public class FacultyServiceImpl implements FacultyService {
    public Faculty addFaculty(Faculty faculty) {
        return DaoFactory.getInstance().getFacultyDao().addElement(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return DaoFactory.getInstance().getFacultyDao().updateElement(faculty);
    }

    public Faculty getFacultyById(int facultyId) {
        return DaoFactory.getInstance().getFacultyDao()
                .getElementById(facultyId);
    }

    public List<Faculty> getAllFaculties() {
        return DaoFactory.getInstance().getFacultyDao().getAllElements();
    }

    public void deleteFaculty(Faculty faculty) {
        DaoFactory.getInstance().getFacultyDao().deleteElement(faculty);
    }
}
