package com.softserve.edu.dao;

import com.softserve.edu.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class TeacherDao extends ElementDaoImpl<Teacher> {

    private SessionFactory sessionFactory;

    @Autowired
    public TeacherDao(SessionFactory sessionFactory) {
        super(Teacher.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Teacher getTeacherByName(String name) {
        Session session = null;
        Teacher teacher;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //todo: Why do I get NullPointerException?!
            Query query = session.createQuery(
                    "from Teacher teacher where teacher.name=:teacherName",
                    Teacher.class);
                    query.setParameter("teacherName", name);
//            List<Teacher> teacherList = query.getResultList();
//            if (teacherList.size()!=0) {
//                teacher = teacherList.get(0);
//                return teacher;
//            }
            teacher = (Teacher) query.getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return teacher;
    }
}
