package com.b18cn082.smart_money.model;

public class PlanCreateRequest {
    private String title;
    private String description;

    public PlanCreateRequest() {

    }

    public PlanCreateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
