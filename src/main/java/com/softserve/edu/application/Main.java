package com.softserve.edu.application;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.SpecialityService;
import com.softserve.edu.service.impl.FacultyServiceImpl;
import com.softserve.edu.service.FacultyService;
import com.softserve.edu.service.impl.SpecialityServiceImpl;

/**
 * Created by Kostya on 10.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        FacultyService facutyService = new FacultyServiceImpl();
        Faculty faculty = new Faculty("аыаы","fds","f");
        facutyService.addFaculty(faculty);
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
