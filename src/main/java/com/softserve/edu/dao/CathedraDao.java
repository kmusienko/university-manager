package com.softserve.edu.dao;

import com.softserve.edu.model.Cathedra;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class CathedraDao extends ElementDaoImpl<Cathedra> {

    private SessionFactory sessionFactory;

    @Autowired
    public CathedraDao(SessionFactory sessionFactory) {
        super(Cathedra.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }
}
