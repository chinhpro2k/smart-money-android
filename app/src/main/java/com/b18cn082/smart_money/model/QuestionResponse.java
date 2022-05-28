package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuestionResponse implements Serializable {
    @SerializedName("question")
    @Expose
    private List<Question> listQuestion;

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public QuestionResponse() {
    }

    public QuestionResponse(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }
}
