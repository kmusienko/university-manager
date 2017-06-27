package com.softserve.edu.model;

import com.softserve.edu.model.enums.Control;

import javax.persistence.*;

/**
 * Created by Kostya on 27.06.2017.
 */
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable =
            false)
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable =
            false)
    private Group group;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable =
            false)
    private Subject subject;
    @Column(name = "hours")
    private int hours;
    @Column(name = "semester_num")
    private int semesterNumber;
    @Enumerated(EnumType.STRING)
    private Control control;

    public Plan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
