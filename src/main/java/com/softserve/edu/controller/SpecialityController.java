package com.softserve.edu.controller;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.service.FacultyService;
import com.softserve.edu.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Kostya on 14.06.2017.
 */
@Controller
public class SpecialityController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(path = "/faculty/speciality")
    public String showSpecialityInfo(
            @RequestParam(name = "id") String specialityId,
            @RequestParam(name = "facultyId") String facultyId, Model model) {
        Speciality speciality = specialityService
                .getSpecialityById(Integer.parseInt(specialityId));
        Faculty faculty =
                facultyService.getFacultyById(Integer.parseInt(facultyId));
        //        List<Speciality> specialities = specialityService
        //                .getSpecialitiesByFacultyId(Integer.parseInt(facultyId));
        model.addAttribute("speciality", speciality);
        model.addAttribute("faculty", faculty);
        //        model.addAttribute("specialities", specialities);
        return "/speciality";
    }

    @RequestMapping(path = "/faculty/speciality/edit",
            method = RequestMethod.GET)
    public String addSpeciality(
            @RequestParam(name = "facultyId") String facultyId,
            @RequestParam(name = "specialityId", required = false)
                    String specialityId, Model model) {
        Speciality speciality;
        if (specialityId == null || specialityId.equals("")) {
            speciality = new Speciality();
        } else {
            speciality = specialityService
                    .getSpecialityById(Integer.parseInt(specialityId));
        }
        model.addAttribute("speciality", speciality);
        Faculty faculty =
                facultyService.getFacultyById(Integer.parseInt(facultyId));
        model.addAttribute("faculty", faculty);
        return "/edit-speciality";
    }

    @RequestMapping(path = "/faculty/speciality/edit",
            method = RequestMethod.POST)
    public String editSpeciality(
            @RequestParam(name = "id", required = false) String id,
            @ModelAttribute Speciality speciality, Model model) {
        if (id != null && !id.equals("0")) {
            speciality.setId(Integer.parseInt(id));
            specialityService.updateSpeciality(speciality);
        } else {
            specialityService.addSpeciality(speciality);
        }
        Speciality speciality1 =
                specialityService.getSpecialityById(speciality.getId());
        model.addAttribute("speciality", speciality1);
        return "/speciality";
    }

}
