package com.softserve.edu.dao;

import com.softserve.edu.model.Speciality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kostya on 11.06.2017.
 */
@Repository
public class SpecialityDao extends ElementDaoImpl<Speciality> {

    private SessionFactory sessionFactory;

    @Autowired
    public SpecialityDao(SessionFactory sessionFactory) {
        super(Speciality.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public List<Speciality> getSpecialitiesByFacultyId(int facultyId) {
        Session session = null;
        session = sessionFactory.openSession();
        List<Speciality> specialities = session.createNativeQuery(
                "select * from specialities where " + "faculty_id=" +
                        facultyId, Speciality.class).getResultList();
        return specialities;
    }
}