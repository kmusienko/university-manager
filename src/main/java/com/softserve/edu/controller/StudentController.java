package com.softserve.edu.controller;

import com.softserve.edu.model.Group;
import com.softserve.edu.model.Student;
import com.softserve.edu.model.dto.LocalDateDTO;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by Kostya on 03.07.2017.
 */
@Controller
public class StudentController {

    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService,
                             GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    //todo: refactor this method
    @RequestMapping(path = "/faculty/speciality/group/student")
    public String showStudentInfo(
            @RequestParam(name = "studentId", required = false)
                    String studentId,
            @RequestParam(name = "lastName", required = false) String lastName,
            Model model) {
        if (studentId != null) {
            Student student =
                    studentService.getStudentById(Integer.parseInt(studentId));
            Group group = student.getGroup();
            String groupName = groupService.getGroupName(group);
            model.addAttribute("student", student);
            model.addAttribute("group", group);
            model.addAttribute("groupName", groupName);
        } else if (lastName != null && !lastName.equals("")){
            Student student = studentService.getStudentByLastName(lastName);
            Group group = student.getGroup();
            String groupName = groupService.getGroupName(group);
            model.addAttribute("student", student);
            model.addAttribute("group", group);
            model.addAttribute("groupName", groupName);
        }
        return "/student";
    }

    @RequestMapping(path = "/faculty/speciality/group/student/edit")
    public String addStudent(@RequestParam(name = "studentId", required = false)
                                     String studentId,
                             @RequestParam(name = "groupId") String groupId,
                             Model model) {
        Student student;
        if (studentId == null || studentId.equals("")) {
            student = new Student();
        } else {
            student =
                    studentService.getStudentById(Integer.parseInt(studentId));
        }
        Group group = groupService.getGroupById(Integer.parseInt(groupId));
        model.addAttribute("student", student);
        model.addAttribute("group", group);
        return "/edit-student";
    }

    @RequestMapping(path = "/faculty/speciality/group/student/edit",
            method = RequestMethod.POST)
    public String editStudent(
            @RequestParam(name = "studentId") String studentId,
            @RequestParam(name = "groupId") String groupId,
            @ModelAttribute Student student,
            @ModelAttribute LocalDateDTO localDateDTO, Model model) {
        student.setGroup(groupService.getGroupById(Integer.parseInt(groupId)));
        student.setBirthdayDate(LocalDate.parse(localDateDTO.getDateString()));
        if (studentId != null && !studentId.equals("0")) {
            studentService.updateStudent(student);
        } else {
            studentService.addStudent(student);
        }
        Group group = groupService.getGroupById(Integer.parseInt(groupId));
        model.addAttribute("student", student);
        model.addAttribute("group", group);
        return "redirect:/faculty/speciality/group/student?studentId=" +
                student.getId() + "&groupId=" + groupId;
    }

    @RequestMapping(path = "/faculty/speciality/group/student/delete")
    public String deleteStudent(
            @RequestParam(name = "studentId") String studentId,
            @RequestParam(name = "groupId") String groupId) {
        Student student =
                studentService.getStudentById(Integer.parseInt(studentId));
        studentService.deleteStudent(student);
        return "redirect:/faculty/speciality/group?groupId=" + groupId;
    }
}
