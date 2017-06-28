package com.softserve.edu.model.dto;

/**
 * Created by Kostya on 28.06.2017.
 */
public class GroupDTO {
    private int id;
    private int specialityId;
    private String curatorName;
    private int yearEntered;
    private int groupNumber;

    public GroupDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
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
