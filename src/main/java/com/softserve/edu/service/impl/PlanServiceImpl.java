package com.softserve.edu.service.impl;

import com.softserve.edu.dao.PlanDao;
import com.softserve.edu.model.Plan;
import com.softserve.edu.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanDao planDao;

    @Autowired
    public PlanServiceImpl(PlanDao planDao) {
        this.planDao = planDao;
    }

    @Override
    public void addPlan(Plan plan) {
        planDao.addElement(plan);
    }

    @Override
    public void updatePlan(Plan plan) {
        planDao.updateElement(plan);
    }

    @Override
    public Plan getPlanById(int planId) {
        return planDao.getElementById(planId);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planDao.getAllElements();
    }

    @Override
    public void deletePlan(Plan plan) {
        planDao.deleteElement(plan);
    }
}
