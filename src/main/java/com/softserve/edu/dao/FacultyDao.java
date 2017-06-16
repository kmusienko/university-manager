package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
@Repository
public class FacultyDao extends ElementDaoImpl<Faculty> {

    public FacultyDao() {
        super(Faculty.class);
    }

//    @Override
//    public List<Faculty> getAllElements() {
//        Session session = null;
//        List<Faculty> faculties;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            faculties = session.createQuery("from Faculty", Faculty.class)
//                    .getResultList();
//        } finally {
//            session.close();
//        }
//        return faculties;
//    }
}
