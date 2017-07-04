package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDao extends ElementDaoImpl<Faculty> {

    private SessionFactory sessionFactory;

    @Autowired
    public FacultyDao(SessionFactory sessionFactory) {
        super(Faculty.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Faculty getFacultyByName(String facultyName) {
        Session session = null;
        Faculty faculty;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //todo: why do I get NullPointerException?!
            String hql = "from Faculty faculty where faculty.name=:facultyName";
            faculty = session.createQuery(hql, Faculty.class)
                    .setParameter("facultyName", facultyName).getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return faculty;
    }
}
