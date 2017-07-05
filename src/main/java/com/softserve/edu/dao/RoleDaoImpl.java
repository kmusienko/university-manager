package com.softserve.edu.dao;

import com.softserve.edu.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 05.07.2017.
 */
@Repository
public class RoleDaoImpl extends ElementDaoImpl<Role> implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(Role.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
