//package com.softserve.edu.service.impl;
//
//import com.softserve.edu.dao.RoleDao;
//import com.softserve.edu.dao.UserDao;
//import com.softserve.edu.model.Role;
//import com.softserve.edu.model.User;
//import com.softserve.edu.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Kostya on 05.07.2017.
// */
//@Service
//public class UserServiceImpl implements UserService{
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private RoleDao roleDao;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getElementById(1));
//        user.setRoles(roles);
//        userDao.addElement(user);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userDao.findByUsername(username);
//    }
//}
