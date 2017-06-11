package com.softserve.edu.dao;

import com.softserve.edu.model.Speciality;

/**
 * Created by Kostya on 10.06.2017.
 */
public class DaoFactory {
    private FacultyDao facultyDao;
    private SpecialityDao specialityDao;

    private static DaoFactory instance;

    private DaoFactory() {
        facultyDao = new FacultyDao();
        specialityDao = new SpecialityDao();
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    public FacultyDao getFacultyDao() {
        return facultyDao;
    }
    public SpecialityDao getSpecialityDao() {
        return specialityDao;
    }
}
