package com.softserve.edu.dao;

import com.softserve.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kostya on 05.07.2017.
 */
public interface UserDao extends ElementDao<User> {
    User findByUsername(String username);
}
