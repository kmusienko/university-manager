package com.softserve.edu.dao;

import com.softserve.edu.model.Speciality;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kostya on 11.06.2017.
 */
@Repository
public class SpecialityDao extends ElementDaoImpl<Speciality> {

    public SpecialityDao() {
        super(Speciality.class);
    }

    public List<Speciality> getSpecialitiesByFacultyId(int facultyId) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        List<Speciality> specialities = session.createNativeQuery(
                "select * from specialities where " + "faculty_id=" +
                        facultyId, Speciality.class).getResultList();
        return specialities;
    }
}