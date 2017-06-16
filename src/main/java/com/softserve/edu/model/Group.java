package com.softserve.edu.model;

import javax.persistence.*;

/**
 * Created by Kostya on 14.06.2017.
 */
//@Entity
//@Table(name = "groups")
public class Group {
    private int id;
    private Teacher curator;
    private Speciality speciality;
    private int yearEntered;
    private int groupNumber;

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getYearEntered() {
        return yearEntered;
    }

    public void setYearEntered(int yearEntered) {
        this.yearEntered = yearEntered;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

}
