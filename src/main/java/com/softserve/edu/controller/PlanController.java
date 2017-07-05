package com.softserve.edu.controller;

import com.softserve.edu.model.Plan;
import com.softserve.edu.model.dto.PlanDTO;
import com.softserve.edu.model.enums.Control;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.PlanService;
import com.softserve.edu.service.SubjectService;
import com.softserve.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostya on 03.07.2017.
 */
@Controller
public class PlanController {

    private PlanService planService;
    private GroupService groupService;
    private TeacherService teacherService;
    private SubjectService subjectService;

    @Autowired
    public PlanController(PlanService planService, GroupService groupService,
                          TeacherService teacherService,
                          SubjectService subjectService) {
        this.planService = planService;
        this.groupService = groupService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @RequestMapping(path = "/plans")
    public String getAllPlans(
            @RequestParam(name = "groupName", required = false)
                    String groupName, Model model) {
        List<Plan> allPlans = planService.getAllPlans();
        List<Plan> plans = new ArrayList<>();
        List<PlanDTO> plansDTO = new ArrayList<>();
        if (groupName != null && !groupName.equals("")) {
            for (Plan plan : allPlans) {
                if (groupService.getGroupName(plan.getGroup())
                        .equals(groupName)) {
                    plans.add(plan);
                    plansDTO.add(new PlanDTO());
                }
            }
        } else {
            plans = allPlans;
            for (Plan plan : plans) {
                plansDTO.add(new PlanDTO());
            }
        }
            for (int i = 0; i < plans.size(); i++) {
                plansDTO.get(i).setId(plans.get(i).getId());
                plansDTO.get(i)
                        .setTeacherName(plans.get(i).getTeacher().getName());
                plansDTO.get(i).setGroupName(
                        groupService.getGroupName(plans.get(i).getGroup()));
                plansDTO.get(i)
                        .setSubjectName(plans.get(i).getSubject().getName());
                plansDTO.get(i).setHours(plans.get(i).getHours());
                plansDTO.get(i)
                        .setSemesterNumber(plans.get(i).getSemesterNumber());
                plansDTO.get(i)
                        .setControlName(plans.get(i).getControl().name());
            }
        model.addAttribute("plansDTO", plansDTO);
        return "/plans";
    }

    @RequestMapping(path = "/plan/edit", method = RequestMethod.GET)
    public String addPlan(
            @RequestParam(name = "planId", required = false) String planId,
            Model model) {
        Plan plan;
        PlanDTO planDTO = new PlanDTO();
        if (planId != null && !planId.equals("")) {
            plan = planService.getPlanById(Integer.parseInt(planId));
            planDTO.setTeacherName(plan.getTeacher().getName());
            planDTO.setGroupName(groupService.getGroupName(plan.getGroup()));
            planDTO.setSubjectName(plan.getSubject().getName());
            planDTO.setHours(plan.getHours());
            planDTO.setSemesterNumber(plan.getSemesterNumber());
            planDTO.setControlName(plan.getControl().name());
        } else {
            plan = new Plan();
        }
        model.addAttribute("planDTO", planDTO);
        model.addAttribute("plan", plan);
        return "/edit-plan";
    }

    @RequestMapping(path = "/plan/edit", method = RequestMethod.POST)
    public String editPlan(@RequestParam(name = "planId") String planId,
                           @ModelAttribute PlanDTO planDTO) {
        Plan plan;
        if (planId != null && !planId.equals("0")) {
            plan = planService.getPlanById(Integer.parseInt(planId));
            plan.setTeacher(
                    teacherService.getTeacherByName(planDTO.getTeacherName()));
            plan.setGroup(groupService.getGroupByName(planDTO.getGroupName()));
            plan.setSubject(
                    subjectService.getSubjectByName(planDTO.getSubjectName()));
            plan.setHours(planDTO.getHours());
            plan.setSemesterNumber(planDTO.getSemesterNumber());
            plan.setControl(Control.valueOf(planDTO.getControlName()));
            planService.updatePlan(plan);
        } else {
            plan = new Plan();
            plan.setTeacher(
                    teacherService.getTeacherByName(planDTO.getTeacherName()));
            plan.setGroup(groupService.getGroupByName(planDTO.getGroupName()));
            plan.setSubject(
                    subjectService.getSubjectByName(planDTO.getSubjectName()));
            plan.setHours(planDTO.getHours());
            plan.setSemesterNumber(planDTO.getSemesterNumber());
            plan.setControl(Control.valueOf(planDTO.getControlName()));
            planService.addPlan(plan);
        }
        return "redirect:/plans";
    }

    @RequestMapping(path = "/plan/delete")
    public String deletePlan(@RequestParam(name = "planId") Integer planId) {
        planService.deletePlan(planService.getPlanById(planId));
        return "redirect:/plans";
    }
}
