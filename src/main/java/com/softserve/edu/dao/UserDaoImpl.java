package com.softserve.edu.dao;

import com.softserve.edu.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 05.07.2017.
 */
@Repository
public class UserDaoImpl extends ElementDaoImpl<User> implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUsername(String username) {
        Session session = null;
        User user;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from User user where user.username=:tUserName";
            user = session.createQuery(hql, User.class)
                    .setParameter("tUserName", username).getSingleResult();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return user;
    }
}
