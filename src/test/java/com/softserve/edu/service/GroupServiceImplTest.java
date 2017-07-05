package com.softserve.edu.service;

import com.softserve.edu.dao.GroupDao;
import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Group;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.impl.GroupServiceImpl;
import org.junit.Assert;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImplTest {

    @Mock
    private GroupDao groupDao;

    @Test
    public void getGroupName_Group_GroupNameReturned() {

        //Arrange
        GroupService groupService = new GroupServiceImpl(groupDao);
        Faculty faculty = new Faculty();
        faculty.setLetter("П");

        Speciality speciality = new Speciality();
        speciality.setLetter("С");
        speciality.setFaculty(faculty);

        Group group = new Group();
        group.setSpeciality(speciality);
        group.setYearEntered(2014);
        group.setGroupNumber(1);

        String expectedGroupName = "ПС-14-1";

        //Act
        String actualGroupName = groupService.getGroupName(group);

        //Assert
        Assert.assertEquals(expectedGroupName, actualGroupName);

    }

    @Test
    public void getGroupByName_GroupName_GroupReturned() {

        //Arrange
        MockitoAnnotations.initMocks(this);
        GroupService groupService = new GroupServiceImpl(groupDao);

        String groupName = "ПС-14-1";

        Faculty faculty = new Faculty();
        faculty.setLetter("П");
        Speciality speciality = new Speciality();
        speciality.setLetter("С");
        speciality.setFaculty(faculty);

        Group expectedGroup = new Group();
        expectedGroup.setSpeciality(speciality);
        expectedGroup.setYearEntered(2014);
        expectedGroup.setGroupNumber(1);

        List<Group> groups = new ArrayList<>();
        groups.add(expectedGroup);

        //Act
        Mockito.doReturn(groups).when(groupDao).getAllElements();
        Group actualGroup = groupService.getGroupByName(groupName);

        //Assert
        Assert.assertEquals(expectedGroup, actualGroup);

    }
    @Test(expected = IllegalArgumentException.class)
    public void getGroupByName_NotExistGroupName_ExceptionThrown() {

        //Arrange
        MockitoAnnotations.initMocks(this);
        GroupService groupService = new GroupServiceImpl(groupDao);

        String groupName = "ПС-12-1";

        Faculty faculty = new Faculty();
        faculty.setLetter("П");
        Speciality speciality = new Speciality();
        speciality.setLetter("С");
        speciality.setFaculty(faculty);

        Group group1 = new Group();
        group1.setSpeciality(speciality);
        group1.setYearEntered(2014);
        group1.setGroupNumber(1);
        Group group2 = new Group();
        group2.setSpeciality(speciality);
        group2.setYearEntered(2010);
        group2.setGroupNumber(2);

        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        //Act
        Mockito.doReturn(groups).when(groupDao).getAllElements();
        Group actualGroup = groupService.getGroupByName(groupName);

    }
}
