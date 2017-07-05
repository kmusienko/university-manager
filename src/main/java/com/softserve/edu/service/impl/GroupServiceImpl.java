package com.softserve.edu.service.impl;

import com.softserve.edu.dao.GroupDao;
import com.softserve.edu.model.Group;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE) - разный объект на каждый запрос
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addElement(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateElement(group);
    }

    @Override
    public Group getGroupById(int groupId) {
        return groupDao.getElementById(groupId);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllElements();
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteElement(group);
    }

    @Override
    public String getGroupNameById(int groupId) {
        Group group = getGroupById(groupId);
        String specialityLetter = group.getSpeciality().getLetter();
        String facultyLetter = group.getSpeciality().getFaculty().getLetter();
       // int yearEntered = group.getYearEntered() - 2000;
        String yearEnteredStr = String.valueOf(group.getYearEntered());
        String number = yearEnteredStr.substring(yearEnteredStr.length() - 2,
                                                 yearEnteredStr.length());
        int groupNumber = group.getGroupNumber();
        return facultyLetter + specialityLetter + "-" + number + "-" +
                groupNumber;
    }

    @Override
    public String getGroupName(Group group) {
        String specialityLetter = group.getSpeciality().getLetter();
        String facultyLetter = group.getSpeciality().getFaculty().getLetter();
        // int yearEntered = group.getYearEntered() - 2000;
        String yearEnteredStr = String.valueOf(group.getYearEntered());
        String number = yearEnteredStr.substring(yearEnteredStr.length() - 2,
                                                 yearEnteredStr.length());
        int groupNumber = group.getGroupNumber();
        return facultyLetter + specialityLetter + "-" + number + "-" +
                groupNumber;
    }

    @Override
    public Group getGroupByName(String groupName) {

        List<Group> groups = getAllGroups();
        for (Group group : groups) {
            if (getGroupName(group).equals(groupName)) {
                return group;
            }
        }
        throw new IllegalArgumentException(
                "Group with name " + groupName + "doesn't exist");
    }
}
