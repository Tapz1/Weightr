package com.tapz.weightr;

public class ViewDataModel {

    private int id;
    private String date;
    private String weight;
    private String weight_goal;

    public ViewDataModel(int id, String date, String weight, String weight_goal){
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.weight_goal = weight_goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight_goal() {
        return weight_goal;
    }

    public void setWeight_goal(String weight_goal) {
        this.weight_goal = weight_goal;
    }
}
