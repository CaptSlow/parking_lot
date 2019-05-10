package com.danf.parkinglot;

public class Car {

    private String registrationNo;
    private String colour;

    public Car() {
    }

    public Car(String registrationNo, String colour) {
        this.registrationNo = registrationNo.toUpperCase();
        this.colour = capitalise(colour);
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
        this.colour = capitalise(colour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return registrationNo.equals(car.getRegistrationNo()) && colour.equals(car.getColour());
    }
    // methods

    // makes the first chat of a string upper and the rest lower
    private String capitalise(String str){
        String lowStr = str.toLowerCase();
        return lowStr.substring(0, 1).toUpperCase() + lowStr.substring(1);
    }

    public void print(){
        System.out.println(this.getRegistrationNo() + "\t" + this.getColour());
    }
}
