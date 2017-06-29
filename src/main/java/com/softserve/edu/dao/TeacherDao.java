package com.softserve.edu.dao;

import com.softserve.edu.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public class TeacherDao extends ElementDaoImpl<Teacher> {

    public TeacherDao() {
        super(Teacher.class);
    }

    public Teacher getTeacherByName(String name) {
        Session session = null;
        Teacher teacher;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //todo: Why do I get NullPointerException?!
            Query query = session.createQuery(
                    "from Teacher where Teacher.name=:teacherName",
                    Teacher.class).setParameter("teacherName", name);
            List<Teacher> teacherList = query.getResultList();
            if (teacherList.size()!=0) {
                teacher = teacherList.get(0);
                return teacher;
            }
           // teacher = (Teacher) query.getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return new Teacher();
    }
}
