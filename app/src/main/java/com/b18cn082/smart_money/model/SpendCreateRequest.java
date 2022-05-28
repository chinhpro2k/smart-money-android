package com.b18cn082.smart_money.model;

public class SpendCreateRequest {
    private String title;
    private String price;
    private String type;
    private String userId;

    public SpendCreateRequest() {

    }

    public SpendCreateRequest(String title, String price, String type, String userId) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
