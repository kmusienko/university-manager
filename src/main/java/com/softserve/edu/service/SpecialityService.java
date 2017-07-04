package com.softserve.edu.service;

import com.softserve.edu.model.Speciality;

import java.util.List;

/**
 * Created by Kostya on 11.06.2017.
 */
public interface SpecialityService {
    void addSpeciality(Speciality speciality);
    void updateSpeciality(Speciality speciality);
    Speciality getSpecialityById(int specialityId);
    List<Speciality> getAllSpecialities();
    void deleteSpeciality(Speciality speciality);
    List<Speciality> getSpecialitiesByFacultyId(int facultyId);
    Speciality getSpecialityByLetter(String letter);
}
