package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpendCreateResponse {
    private String message;
    @SerializedName("spend")
    @Expose
    private Spend spend;

    public SpendCreateResponse(){

    }
    public SpendCreateResponse(String message, Spend spend) {
        this.message = message;
        this.spend = spend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Spend getSpend() {
        return spend;
    }

    public void setSpend(Spend spend) {
        this.spend = spend;
    }
}
