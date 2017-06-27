package com.softserve.edu.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "letter")
    private String letter;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty", cascade =
            CascadeType.ALL)
    private List<Speciality> specialities;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty", cascade =
            CascadeType.ALL)
    private List<Cathedra> cathedras;

    public Faculty() {

    }

    public List<Cathedra> getCathedras() {
        return cathedras;
    }

    public void setCathedras(List<Cathedra> cathedras) {
        this.cathedras = cathedras;
    }



    public Faculty(String name, String address, String letter) {
        this.name = name;
        this.address = address;
        this.letter = letter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

}
