package com.example.tests.model;

public class Car {
    private String type;
    private String make;
    private int model;

    public String getType() {
        return type;
    }

    public Car(String type, String make, int model) {
        this.type = type;
        this.make = make;
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}
