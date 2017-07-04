package com.softserve.edu.dao;

import com.softserve.edu.model.Group;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class GroupDao extends ElementDaoImpl<Group> {

    private SessionFactory sessionFactory;

    @Autowired
    public GroupDao(SessionFactory sessionFactory) {
        super(Group.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }
}
