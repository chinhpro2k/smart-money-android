package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpendReportResponse {
    @SerializedName("spends")
    @Expose
    private List<Spend> listSpend;

    public SpendReportResponse() {

    }

    public SpendReportResponse(List<Spend> listSpend) {
        this.listSpend = listSpend;
    }

    public List<Spend> getListSpend() {
        return listSpend;
    }

    public void setListSpend(List<Spend> listSpend) {
        this.listSpend = listSpend;
    }
}
