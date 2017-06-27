package com.softserve.edu.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Kostya on 27.06.2017.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable =
            false)
    private Group group;
    @Column(name = "ind_number")
    private String indNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday_date")
    private LocalDate birthdayDate;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getIndNumber() {
        return indNumber;
    }

    public void setIndNumber(String indNumber) {
        this.indNumber = indNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
