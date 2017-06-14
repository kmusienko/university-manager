package com.softserve.edu.model;

import javax.persistence.*;

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

    public Faculty() {

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
}
