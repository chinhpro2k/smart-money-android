package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanResponse {
    @SerializedName("plan")
    @Expose
    private List<Plan> listPlan;

    public PlanResponse() {

    }
    public PlanResponse(List<Plan> listPlan) {
        this.listPlan = listPlan;
    }

    public List<Plan> getListPlan() {
        return listPlan;
    }

    public void setListPlan(List<Plan> listPlan) {
        this.listPlan = listPlan;
    }
}
