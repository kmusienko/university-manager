package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 10.06.2017.
 */
@Repository
public class FacultyDao extends ElementDaoImpl<Faculty> {

    public FacultyDao() {
        super(Faculty.class);
    }
}
