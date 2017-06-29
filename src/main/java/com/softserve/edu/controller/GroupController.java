package com.softserve.edu.controller;

import com.softserve.edu.model.Group;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.model.Student;
import com.softserve.edu.model.Teacher;
import com.softserve.edu.model.dto.GroupDTO;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.SpecialityService;
import com.softserve.edu.service.TeacherService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Controller
public class GroupController {

    private GroupService groupService;
    private SpecialityService specialityService;
    private TeacherService teacherService;

    @Autowired
    public GroupController(GroupService groupService,
                           SpecialityService specialityService,
                           TeacherService teacherService) {
        this.groupService = groupService;
        this.specialityService = specialityService;
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/faculty/speciality/group")
    public String showGroupInfo(@RequestParam(name = "groupId") int groupId,
                                Model model) {
        Group group = groupService.getGroupById(groupId);
        String groupName = groupService.getGroupNameById(groupId);
        List<Student> students = group.getStudents();
        model.addAttribute("group", group);
        model.addAttribute("groupName", groupName);
        model.addAttribute("students", students);
        return "/group";
    }

    @RequestMapping(path = "/faculty/speciality/group/edit",
            method = RequestMethod.GET)
    public String addGroup(
            @RequestParam(name = "specialityId") int specialityId,
            @RequestParam(name = "groupId", required = false) Integer groupId,
            Model model) {
        Group group;
        if (groupId == null) {
            group = new Group();
        } else {
            group = groupService.getGroupById(groupId);
        }
        Speciality speciality =
                specialityService.getSpecialityById(specialityId);
        model.addAttribute("group", group);
        model.addAttribute("speciality", speciality);
        return "/edit-group";
    }

    @RequestMapping(path = "/faculty/speciality/group/edit",
            method = RequestMethod.POST)
    public String editGroup(@RequestParam(name = "groupId") Integer groupId,
                            @RequestParam(name = "specialityId")
                                    Integer specialityId,
                            @ModelAttribute GroupDTO groupDTO, Model model) {
        Group group;
        if (groupId == 0) {
            group = new Group();
            group.setSpeciality(
                    specialityService.getSpecialityById(specialityId));
            group.setCurator(
                    teacherService.getTeacherByName(groupDTO.getCuratorName()));
            group.setYearEntered(groupDTO.getYearEntered());
            group.setGroupNumber(groupDTO.getGroupNumber());
            groupService.addGroup(group);
        } else {
            group = new Group();//test
        }
        //  group.setSpeciality(specialityService.getSpecialityById
        // (specialityId));

        return "redirect:/faculty/speciality/group?groupId=" + group.getId();
    }

    @RequestMapping(path = "/faculty/speciality/group/delete")
    public String deleteGroup(@RequestParam(name = "groupId") int groupId,
                              @RequestParam(name = "specialityId")
                                      int specialityId) {
        groupService.deleteGroup(groupService.getGroupById(groupId));
        return "redirect:/faculty/speciality?id=" + specialityId +
                "&facultyId=" +
                specialityService.getSpecialityById(specialityId).getFaculty()
                        .getId();
    }
}
