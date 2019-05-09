package com.danf.parkinglot;

public class Car {

    private String registrationNo;
    private String colour;

    public Car() {
    }

    public Car(String registrationNo, String colour) {
        this.registrationNo = registrationNo.toUpperCase();
        this.colour = colour.toUpperCase();
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo.toUpperCase();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return registrationNo.equals(car.getRegistrationNo()) && colour.equals(car.getColour());
    }

}
