package com.softserve.edu.dao;

import com.softserve.edu.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class StudentDao extends ElementDaoImpl<Student> {

    private SessionFactory sessionFactory;

    @Autowired
    public StudentDao(SessionFactory sessionFactory) {
        super(Student.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Student getStudentByLastName(String lastName) {
        Session session = null;
        Student student;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from Student student where student" +
                    ".lastName=:studentLastName";
            student = session.createQuery(hql, Student.class)
                    .setParameter("studentLastName", lastName)
                    .getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return student;
    }

    public List<Student> getStudentsByLastName(String lastName) {
        Session session = null;
        List<Student> students;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from Student student where student" +
                    ".lastName=:studentLastName";
            students = session.createQuery(hql, Student.class)
                    .setParameter("studentLastName", lastName)
                    .list();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return students;
    }
}
