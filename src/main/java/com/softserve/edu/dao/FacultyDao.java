package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
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

    public Faculty getFacultyByName(String facultyName) {
        Session session = null;
        Faculty faculty;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
         //   session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //todo: why do I get NullPointerException?!
            String hql = "from Faculty faculty where faculty.name=:facultyName";
            faculty = session.createQuery(hql, Faculty.class)
                    .setParameter("facultyName", facultyName).getSingleResult();
            //                        faculty = session.createNativeQuery(
            //                                "select * from faculties " + "WHERE " +
            // "name=fsdfas",
            //                                Faculty.class).getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return faculty;
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
