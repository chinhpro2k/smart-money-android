package com.b18cn082.smart_money.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    @SerializedName("answer")
    @Expose
    private List<String> listAnswer;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("correctAnswer")
    @Expose
    private String correctAnswer;
    @SerializedName("__v")
    @Expose
    private int v;

    public Question() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question(List<String> listAnswer, String id, String title, String correctAnswer, int v) {
        this.listAnswer = listAnswer;
        this.id = id;
        this.title = title;
        this.correctAnswer = correctAnswer;
        this.v = v;
    }

    public List<String> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<String> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
