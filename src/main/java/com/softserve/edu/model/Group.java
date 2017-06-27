package com.softserve.edu.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kostya on 14.06.2017.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "curator_id", referencedColumnName = "id",
            nullable = false)
    private Teacher curator;
    @ManyToOne
    @JoinColumn(name = "specialities_id", referencedColumnName = "id",
            nullable = false)
    private Speciality speciality;
    @Column(name = "year_int")
    private int yearEntered;
    @Column(name = "group_num")
    private int groupNumber;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade =
            CascadeType.ALL)
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
