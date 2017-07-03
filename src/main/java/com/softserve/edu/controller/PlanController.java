package com.softserve.edu.controller;

import com.softserve.edu.model.Plan;
import com.softserve.edu.model.dto.PlanDTO;
import com.softserve.edu.service.GroupService;
import com.softserve.edu.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostya on 03.07.2017.
 */
@Controller
public class PlanController {

    private PlanService planService;
    private GroupService groupService;

    @Autowired
    public PlanController(PlanService planService, GroupService groupService) {
        this.planService = planService;
        this.groupService = groupService;
    }

    @RequestMapping(path = "/plan")
    public String getAllPlans(Model model) {
        List<Plan> plans = planService.getAllPlans();
        List<PlanDTO> plansDTO = new ArrayList<>(plans.size());
        for (Plan plan : plans) {
            plansDTO.add(new PlanDTO());
        }
        for (int i = 0; i < plans.size(); i++) {
            plansDTO.get(i).setTeacher(plans.get(i).getTeacher());
            plansDTO.get(i).setGroupName(
                    groupService.getGroupName(plans.get(i).getGroup()));
            plansDTO.get(i).setSubject(plans.get(i).getSubject());
            plansDTO.get(i).setHours(plans.get(i).getHours());
            plansDTO.get(i).setSemesterNumber(plans.get(i).getSemesterNumber());
            plansDTO.get(i).setControl(plans.get(i).getControl());
        }
        model.addAttribute("plansDTO", plansDTO);
        return "/plans";
    }
}
