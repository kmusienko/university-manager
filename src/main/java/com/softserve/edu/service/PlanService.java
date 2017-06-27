package com.softserve.edu.service;

import com.softserve.edu.model.Plan;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface PlanService {
    void addPlan(Plan plan);
    void updatePlan(Plan plan);
    Plan getPlanById(int planId);
    List<Plan> getAllPlans();
    void deletePlan(Plan plan);
}
