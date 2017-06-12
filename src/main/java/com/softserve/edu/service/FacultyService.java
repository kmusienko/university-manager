package com.softserve.edu.service;

import com.softserve.edu.model.Faculty;

import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty updateFaculty(Faculty faculty);
    Faculty getFacultyById(int facultyId);
    List<Faculty> getAllFaculties();
    void deleteFaculty(Faculty faculty);
}
