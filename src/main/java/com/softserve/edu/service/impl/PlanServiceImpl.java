package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Plan;
import com.softserve.edu.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public void addPlan(Plan plan) {
        DaoFactory.getInstance().getPlanDao().addElement(plan);
    }

    @Override
    public void updatePlan(Plan plan) {
        DaoFactory.getInstance().getPlanDao().updateElement(plan);
    }

    @Override
    public Plan getPlanById(int planId) {
        return  DaoFactory.getInstance().getPlanDao().getElementById(planId);
    }

    @Override
    public List<Plan> getAllPlans() {
        return  DaoFactory.getInstance().getPlanDao().getAllElements();
    }

    @Override
    public void deletePlan(Plan plan) {
        DaoFactory.getInstance().getPlanDao().deleteElement(plan);
    }
}
