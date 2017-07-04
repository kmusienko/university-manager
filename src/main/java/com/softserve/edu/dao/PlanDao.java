package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Plan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 27.06.2017.
 */
@Repository
public class PlanDao extends ElementDaoImpl<Plan> {

    private SessionFactory sessionFactory;

    @Autowired
    public PlanDao(SessionFactory sessionFactory) {
        super(Plan.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }
}
