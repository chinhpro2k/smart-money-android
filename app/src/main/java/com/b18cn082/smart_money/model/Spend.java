package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spend {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("type")
    @Expose
    private String type;

    public Spend(){

    }
    public Spend(String title, String price, String userId, String type) {
        this.title = title;
        this.price = price;
        this.userId = userId;
        this.type = type;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
