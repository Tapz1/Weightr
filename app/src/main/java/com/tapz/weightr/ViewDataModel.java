package com.tapz.weightr;

public class ViewDataModel {

    private String date;
    private Double weight;
    private Double weight_goal;

    public ViewDataModel(String date, Double weight, Double weight_goal){
        this.date = date;
        this.weight = weight;
        this.weight_goal = weight_goal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight_goal() {
        return weight_goal;
    }

    public void setWeight_goal(Double weight_goal) {
        this.weight_goal = weight_goal;
    }
}
