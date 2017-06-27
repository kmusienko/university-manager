package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
//@Repository
public class FacultyDao extends ElementDaoImpl<Faculty> {

//    @Autowired
//    private SessionFactory sessionFactory;
    public FacultyDao() {
        super(Faculty.class);
    }

//    @Override
//    public List<Faculty> getAllElements() {
//        Session session = null;
//        List<Faculty> faculties;
//   //     try {
//            session =sessionFactory.getCurrentSession();
//            faculties = session.createQuery("from Faculty", Faculty.class)
//                    .getResultList();
//  //      }
////        finally {
////            session.close();
////        }
//        return faculties;
 //   }
//    @Override
//    public List<Faculty> getAllElements() {
//        List<Faculty> elements;
//        try {
//            elements = session.createQuery("from Faculty",
//                                           Faculty.class).getResultList();
//        } finally {
//            if ((session != null) && (session.isOpen())) {
//                session.close();
//            }
//        }
//        return elements;
//    }

}
