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
import java.util.Set;

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
    public String showFacultyInfo(
            @RequestParam(name = "id", required = false) Integer facultyId,
            @RequestParam(name = "name", required = false) String name, Model
                    model) {
        if (facultyId!=null) {
            Faculty faculty = facultyService.getFacultyById(facultyId);
            //        List<Speciality> specialities = specialityService
            //                .getSpecialitiesByFacultyId(Integer.parseInt(facultyId));
            List<Speciality> specialities = faculty.getSpecialities();
            model.addAttribute("faculty", faculty);
            model.addAttribute("specialities", specialities);
        } else if (name!=null && !name.equals("")) {
            Faculty faculty = facultyService.getFacultyByName(name);
            List<Speciality> specialities = faculty.getSpecialities();
            model.addAttribute("specialities", specialities);
            model.addAttribute("faculty", faculty);
        }
        return "/faculty";
    }

    @RequestMapping(path = "/faculty/edit", method = RequestMethod.GET)
    public String addFaculty(
            @RequestParam(name = "id", required = false) String id,
            Model model) {
        Faculty faculty;
        if (id == null) {
            faculty = new Faculty();
        } else {
            faculty = facultyService.getFacultyById(Integer.parseInt(id));
        }
        model.addAttribute("faculty", faculty);
        return "/edit-faculty";
    }

    @RequestMapping(path = "/faculty/edit", method = RequestMethod.POST)
    public String editFaculty(
            @RequestParam(name = "id", required = false) String id,
            @ModelAttribute Faculty faculty, Model model) {
        if (id != null && !id.equals("0")) {
            //   faculty.setId(Integer.parseInt(id));
            facultyService.updateFaculty(faculty);
        } else {
            facultyService.addFaculty(faculty);
        }
        Faculty faculty1 = facultyService.getFacultyById(faculty.getId());
        model.addAttribute("faculty", faculty1);
        return "redirect:/faculty";
    }

    @RequestMapping(path = "/faculty/delete", method = RequestMethod.GET)
    public String deleteFaculty(@RequestParam(name = "id") String id) {
        Faculty faculty = facultyService.getFacultyById(Integer.parseInt(id));
        facultyService.deleteFaculty(faculty);
        return "redirect:/faculties";
    }
}
