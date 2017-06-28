package com.softserve.edu.controller;

import com.softserve.edu.model.Group;
import com.softserve.edu.model.Speciality;
import com.softserve.edu.model.Student;
import com.softserve.edu.model.dto.GroupDTO;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.SpecialityService;
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

    @Autowired
    public GroupController(GroupService groupService,
                           SpecialityService specialityService) {
        this.groupService = groupService;
        this.specialityService = specialityService;
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
            @RequestParam(name = "groupId", required = false) int groupId,
            @RequestParam(name = "specialityId") int specialityId,
            Model model) {
        Group group;
        if (groupId == 0) {
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
    public String editSpeciality(@RequestParam(name = "groupId") int groupId,
                                 @RequestParam(name = "specialityId")
                                         int specialityId,
                                 @ModelAttribute GroupDTO groupDTO,
                                 Model model) {
        if (groupId != 0) {
            Group group = new Group();
            group.setId(groupId);
            group.setSpeciality(specialityService.getSpecialityById(specialityId));
           // group.setCurator();

        }
      //  group.setSpeciality(specialityService.getSpecialityById
        // (specialityId));

        return "";
    }
}
