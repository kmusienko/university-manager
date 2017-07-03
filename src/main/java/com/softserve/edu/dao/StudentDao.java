package com.softserve.edu.dao;

import com.softserve.edu.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Kostya on 27.06.2017.
 */
public class StudentDao extends ElementDaoImpl<Student> {
    public StudentDao() {
        super(Student.class);
    }

    public Student getStudentByLastName(String lastName) {
        Session session = null;
        Student student;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //todo: why do I get NullPointerException?!
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
}
