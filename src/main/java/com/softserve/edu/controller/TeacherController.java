package com.softserve.edu.controller;

import com.softserve.edu.model.Cathedra;
import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.service.CathedraService;
import com.softserve.edu.service.FacultyService;
import com.softserve.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    private FacultyService facultyService;
    private CathedraService cathedraService;
    private TeacherService teacherService;

    @Autowired
    public TeacherController(FacultyService facultyService, CathedraService
            cathedraService, TeacherService teacherService) {
        this.facultyService = facultyService;
        this.cathedraService = cathedraService;
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/faculty/cathedra/teacher/edit",
            method = RequestMethod.GET)
    public String addCathedra(
            @RequestParam(name = "cathedraId") String cathedraId,
            @RequestParam(name = "teacherId", required = false)
                    String teacherId, Model model) {
        Teacher teacher;
        if (teacherId == null || teacherId.equals("")) {
            teacher = new Teacher();
        } else {
            teacher = teacherService
                    .getTeacherById(Integer.parseInt(teacherId));
        }
        model.addAttribute("teacher", teacher);
        Cathedra cathedra =
                cathedraService.getCathedraById(Integer.parseInt(cathedraId));
        model.addAttribute("cathedra", cathedra);
        return "/edit-teacher";
    }

    @RequestMapping(path = "/faculty/cathedra/teacher/edit",
            method = RequestMethod.POST)
    public String editTeacher(
            @RequestParam(name = "cathedraId") String cathedraId,
            @RequestParam(name = "teacherId") String teacherId,
            @ModelAttribute Teacher teacher, Model model) {
        teacher.setCathedra(
                cathedraService.getCathedraById(Integer.parseInt(cathedraId)));
        if (teacherId != null && !teacherId.equals("0")) {
            // speciality.setId(Integer.parseInt(id));
            teacherService.updateTeacher(teacher);
        } else {
            teacherService.addTeacher(teacher);
        }
        Teacher teacher1 =
                teacherService.getTeacherById(teacher.getId());
        model.addAttribute("teacher", teacher1);
        Cathedra cathedra = cathedraService.getCathedraById(Integer.parseInt
                (cathedraId));
        model.addAttribute("cathedra", cathedra);
        return "redirect:/faculty/cathedra?cathedraId=" + cathedra.getId() +
                "&facultyId=" + cathedra.getFaculty().getId();
    }

    @RequestMapping(path = "/faculty/cathedra/teacher/delete",
            method = RequestMethod.GET)
    public String deleteTeacher(
            @RequestParam(name = "cathedraId") String cathedraId,
            @RequestParam(name = "teacherId") String teacherId){
        Teacher teacher = teacherService
                .getTeacherById(Integer.parseInt(teacherId));
        teacherService.deleteTeacher(teacher);
        return "redirect:/faculty/cathedra?cathedraId=" + cathedraId +
                "&facultyId=" + teacher.getCathedra().getFaculty().getId();
    }
}
