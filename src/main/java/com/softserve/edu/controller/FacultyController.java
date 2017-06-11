package com.softserve.edu.controller;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.FacultyService;
import com.softserve.edu.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Kostya on 11.06.2017.
 */
@Controller
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(path = "/faculties")
    public String getAllFaculties(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "/faculties";
    }

    @RequestMapping(path = "/faculty")
    public String showFacultyInfo(@RequestParam(name = "id") String facultyId,
                                  Model model) {
        Faculty faculty =
                facultyService.getFacultyById(Integer.parseInt(facultyId));
        List<Speciality> specialities = specialityService
                .getSpecialitiesByFacultyId(Integer.parseInt(facultyId));
        model.addAttribute("faculty", faculty);
        model.addAttribute("specialities", specialities);
        return "/faculty";
    }
}
