package com.example.tests.model;

import java.util.ArrayList;

public class CarModel {
    private ArrayList<Car> cartype = new ArrayList<>();

    public CarModel(){
        cartype.add(new Car("SUV","Santa Fe ", 2017));
        cartype.add(new Car("Sedan","Santa ", 2020));
        cartype.add(new Car("hatch-bag","Fe ", 2019));

    }

    public Car getCarByType(String type){
        Car car = null;
        for(Car c: cartype){
            if (c.getType().toLowerCase().equals(type.toLowerCase())){
                return c;
            }
        }
        return car;
    }
}
