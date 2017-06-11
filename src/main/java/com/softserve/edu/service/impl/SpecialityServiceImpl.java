package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kostya on 11.06.2017.
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {
    public void addSpeciality(Speciality speciality) {
        DaoFactory.getInstance().getSpecialityDao().addElement(speciality);
    }

    public void updateSpeciality(Speciality speciality) {
        DaoFactory.getInstance().getSpecialityDao().updateElement(speciality);
    }

    public Speciality getSpecialityById(int specialityId) {
        return DaoFactory.getInstance().getSpecialityDao()
                .getElementById(specialityId);
    }

    public List<Speciality> getAllSpecialities() {
        return DaoFactory.getInstance().getSpecialityDao().getAllElements();
    }

    public void deleteSpeciality(Speciality speciality) {
        DaoFactory.getInstance().getSpecialityDao().deleteElement(speciality);
    }

    public List<Speciality> getSpecialitiesByFacultyId(int facultyId) {
        return DaoFactory.getInstance().getSpecialityDao()
                .getSpecialitiesByFacultyId(facultyId);
    }
}
