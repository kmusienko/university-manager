package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Group;
import com.softserve.edu.service.GroupService;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public class GroupServiceImpl implements GroupService {
    public void addGroup(Group group) {
        DaoFactory.getInstance().getGroupDao().addElement(group);
    }

    public void updateGroup(Group group) {
        DaoFactory.getInstance().getGroupDao().updateElement(group);
    }

    public Group getGroupById(int groupId) {
        return DaoFactory.getInstance().getGroupDao().getElementById(groupId);
    }

    public List<Group> getAllGroups() {
        return DaoFactory.getInstance().getGroupDao().getAllElements();
    }

    public void deleteGroup(Group group) {
        DaoFactory.getInstance().getGroupDao().deleteElement(group);
    }
    public String getGroupNameById(int groupId) {
        Group group = getGroupById(groupId);
        String specialityLetter = group.getSpeciality().getLetter();
        String facultyLetter = group.getSpeciality().getFaculty().getLetter();
        int yearEntered = group.getYearEntered();
        return facultyLetter+specialityLetter+"-"+yearEntered;
    }
    public String getGroupName(Group group) {
        String specialityLetter = group.getSpeciality().getLetter();
        String facultyLetter = group.getSpeciality().getFaculty().getLetter();
        int yearEntered = group.getYearEntered()-2000;
        int groupNumber = group.getGroupNumber();
        return facultyLetter+specialityLetter+"-" + yearEntered + "-"
                + groupNumber;
    }
}
