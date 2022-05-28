package com.b18cn082.smart_money.model;

public class SpendReportRequest {
    private String userId;

    public SpendReportRequest() {

    }

    public SpendReportRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
