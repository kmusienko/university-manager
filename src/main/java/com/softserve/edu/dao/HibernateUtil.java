package com.softserve.edu.dao;

import com.softserve.edu.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Kostya on 10.06.2017.
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final Configuration configuration = new Configuration();

    static {
        try {
            //Creates the session factory from hibernate.cfg.xml
            configuration.configure();

            //            sessionFactory = configuration.buildSessionFactory(
            //                    new StandardServiceRegistryBuilder().applySetting(configuration.getProperties()).build());
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties());
            sessionFactory = configuration
                    .addAnnotatedClass(Faculty.class)
                    .addAnnotatedClass(Speciality.class)
                    .addAnnotatedClass(Cathedra.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Group.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Subject.class)
                    .addAnnotatedClass(Plan.class)
                    .buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
