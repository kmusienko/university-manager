package com.softserve.edu.controller;

import com.softserve.edu.model.*;
import com.softserve.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CathedraController {
    private FacultyService facultyService;
    private CathedraService cathedraService;
    private TeacherService teacherService;

    @Autowired
    public CathedraController(FacultyService facultyService, CathedraService
            cathedraService, TeacherService teacherService) {
        this.facultyService = facultyService;
        this.cathedraService = cathedraService;
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/faculty/cathedra")
    public String showSpecialityInfo(
            @RequestParam(name = "cathedraId") String cathedraId,
            @RequestParam(name = "facultyId") String facultyId, Model model) {
        Cathedra cathedra =
                cathedraService.getCathedraById(Integer.parseInt(cathedraId));
        Faculty faculty =
                facultyService.getFacultyById(Integer.parseInt(facultyId));

        model.addAttribute("cathedra", cathedra);
        model.addAttribute("faculty", faculty);
        //        model.addAttribute("specialities", specialities);
        List<Teacher> teachers = cathedra.getTeachers();
        model.addAttribute("teachers", teachers);
        return "/cathedra";
    }

    @RequestMapping(path = "/faculty/cathedra/edit",
            method = RequestMethod.GET)
    public String addCathedra(
            @RequestParam(name = "facultyId") String facultyId,
            @RequestParam(name = "cathedraId", required = false)
                    String cathedraId, Model model) {
        Cathedra cathedra;
        if (cathedraId == null || cathedraId.equals("")) {
            cathedra = new Cathedra();
        } else {
            cathedra = cathedraService
                    .getCathedraById(Integer.parseInt(cathedraId));
        }
        model.addAttribute("cathedra", cathedra);
        Faculty faculty =
                facultyService.getFacultyById(Integer.parseInt(facultyId));
        model.addAttribute("faculty", faculty);
        return "/edit-cathedra";
    }

    @RequestMapping(path = "/faculty/cathedra/edit",
            method = RequestMethod.POST)
    public String editCathedra(
            @RequestParam(name = "facultyId") String facultyId,
            @RequestParam(name = "cathedraId") String cathedraId,
            @ModelAttribute Cathedra cathedra, Model model) {
        cathedra.setFaculty(
                facultyService.getFacultyById(Integer.parseInt(facultyId)));
        if (cathedraId != null && !cathedraId.equals("0")) {
            // speciality.setId(Integer.parseInt(id));
            cathedraService.updateCathedra(cathedra);
        } else {
            cathedraService.addCathedra(cathedra);
        }
        Cathedra cathedra1 =
                cathedraService.getCathedraById(cathedra.getId());
        model.addAttribute("speciality", cathedra1);
        Faculty faculty = facultyService.getFacultyById(Integer.parseInt(facultyId));
        model.addAttribute("faculty", faculty);
        //        List<Group> groups = speciality.getGroups();
        //        model.addAttribute("groups", groups);
        return "redirect:/faculty/cathedra?cathedraId=" + cathedra.getId() +
                "&facultyId=" + facultyId;
    }

    @RequestMapping(path = "/faculty/cathedra/delete",
            method = RequestMethod.GET)
    public String deleteCathedra(
            @RequestParam(name = "facultyId") String facultyId,
            @RequestParam(name = "cathedraId") String cathedraId){
        Cathedra cathedra = cathedraService
                .getCathedraById(Integer.parseInt(cathedraId));
        cathedraService.deleteCathedra(cathedra);
        return "redirect:/faculty?id=" + facultyId;
    }


}

