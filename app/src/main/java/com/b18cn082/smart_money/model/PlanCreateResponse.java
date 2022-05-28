package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PlanCreateResponse {
    private String message;
    @SerializedName("plan")
    @Expose
    private Plan plan;

    public PlanCreateResponse(){

    }

    public PlanCreateResponse(String message, Plan plan) {
        this.message = message;
        this.plan = plan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
