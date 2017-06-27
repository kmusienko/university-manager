package com.softserve.edu.application;

import com.softserve.edu.model.*;
import com.softserve.edu.service.*;
import com.softserve.edu.service.impl.*;

/**
 * Created by Kostya on 10.06.2017.
 */
public class Main {
    public static void main(String[] args) {
//        FacultyService facutyService = new FacultyServiceImpl();
//        Faculty faculty = new Faculty("аыаы","fds","f");
//        facutyService.addFaculty(faculty);
        CathedraService cathedraService = new CathedraServiceImpl();
        for (Cathedra cathedra : cathedraService.getAllCathedras()) {
            System.out.println(cathedra.getName());
        }
        TeacherService teacherService = new TeacherServiceImpl();
        for (Teacher teacher : teacherService.getAllTeachers()) {
            System.out.println(teacher.getName());
        }
        GroupService groupService = new GroupServiceImpl();
        for (Group group : groupService.getAllGroups()) {
            System.out.println(groupService.getGroupName(group));
        }
        StudentService studentService = new StudentServiceImpl();
        for (Student student : studentService.getAllStudents()) {
            System.out.println(student.getFirstName() + " " + student
                    .getLastName() + " " + student.getBirthdayDate());
        }
        SubjectService subjectService = new SubjectServiceImpl();
        for (Subject subject : subjectService.getAllSubjects()) {
            System.out.println(subject.getName());
        }

//        SpecialityService specialityService = new SpecialityServiceImpl();
//        for (Speciality speciality : specialityService.getAllSpecialities()) {
//            System.out.println(speciality.getName());
//        }
//        System.out.println("----------");
//        for (Speciality speciality : specialityService
//                .getSpecialitiesByFacultyId(1)) {
//            System.out.println(speciality.getName());
//        }
    }
}
