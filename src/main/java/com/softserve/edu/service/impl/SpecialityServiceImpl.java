package com.softserve.edu.service.impl;

import com.softserve.edu.dao.SpecialityDao;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityDao specialityDao;

    @Autowired
    public SpecialityServiceImpl(SpecialityDao specialityDao) {
        this.specialityDao = specialityDao;
    }

    @Override
    public void addSpeciality(Speciality speciality) {
        specialityDao.addElement(speciality);
    }

    @Override
    public void updateSpeciality(Speciality speciality) {
        specialityDao.updateElement(speciality);
    }

    @Override
    public Speciality getSpecialityById(int specialityId) {
        return specialityDao.getElementById(specialityId);
    }

    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityDao.getAllElements();
    }

    @Override
    public void deleteSpeciality(Speciality speciality) {
        specialityDao.deleteElement(speciality);
    }

    @Override
    public List<Speciality> getSpecialitiesByFacultyId(int facultyId) {
        return specialityDao.getSpecialitiesByFacultyId(facultyId);
    }

    @Override
    public Speciality getSpecialityByLetter(String letter) {
        return null;
    }
}
