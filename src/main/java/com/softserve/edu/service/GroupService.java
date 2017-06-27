package com.softserve.edu.service;

import com.softserve.edu.model.Group;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface GroupService {
    void addGroup(Group group);
    void updateGroup(Group group);
    Group getGroupById(int groupId);
    List<Group> getAllGroups();
    void deleteGroup(Group group);
    String getGroupName(Group group);
    String getGroupNameById(int groupId);
}
