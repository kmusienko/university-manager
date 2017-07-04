package com.softserve.edu.dao;

import com.softserve.edu.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class SubjectDao extends ElementDaoImpl<Subject> {

    private SessionFactory sessionFactory;

    @Autowired
    public SubjectDao(SessionFactory sessionFactory) {
        super(Subject.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Subject getSubjectByName(String name) {
        Session session = null;
        Subject subject;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //todo: Why do I get NullPointerException?!
            Query query = session.createQuery(
                    "from Subject subject where subject.name=:subjectName",
                    Subject.class);
            query.setParameter("subjectName", name);
            //            List<Teacher> teacherList = query.getResultList();
            //            if (teacherList.size()!=0) {
            //                teacher = teacherList.get(0);
            //                return teacher;
            //            }
            subject = (Subject) query.getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return subject;
    }
}
