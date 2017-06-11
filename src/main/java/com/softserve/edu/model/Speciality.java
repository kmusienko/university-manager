package com.softserve.edu.model;

import javax.persistence.*;

/**
 * Created by Kostya on 11.06.2017.
 */
@Entity
@Table(name = "specialities")
public class Speciality {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "letter")
    private String letter;
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable =
            false)
    private Faculty faculty;

    public Speciality() {

    }
    public Speciality(String name,String letter, Faculty faculty) {
        this.name = name;
        this.letter = letter;
        this.faculty = faculty;
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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
