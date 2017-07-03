package com.softserve.edu.model.dto;

import com.softserve.edu.model.Group;
import com.softserve.edu.model.Subject;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.model.enums.Control;

/**
 * Created by Kostya on 03.07.2017.
 */
public class PlanDTO {

    private Teacher teacher;
    private String  groupName;
    private Subject subject;
    private int hours;
    private int semesterNumber;
    private Control control;

    public PlanDTO() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
}
