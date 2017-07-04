package com.softserve.edu.model.dto;

import com.softserve.edu.model.Group;
import com.softserve.edu.model.Subject;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.model.enums.Control;

/**
 * Created by Kostya on 03.07.2017.
 */
public class PlanDTO {
    private int id;
    private String teacherName;
    private String  groupName;
    private String subjectName;
    private int hours;
    private int semesterNumber;
    private String controlName;

    public PlanDTO() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
