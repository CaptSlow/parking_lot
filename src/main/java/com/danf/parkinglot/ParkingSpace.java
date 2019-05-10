package com.danf.parkinglot;

public class ParkingSpace {

    private boolean isFree;
    private Car carInSpace;


    // Constructors

    public ParkingSpace(){
        this.isFree=true;
    }

    public ParkingSpace(Car carInSpace) {
        this.isFree = false;
        this.carInSpace = carInSpace;
    }

    // getters and setters

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Car getCarInSpace() {
        return carInSpace;
    }

    public void setCarInSpace(Car carInSpace) {
        this.carInSpace = carInSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpace that = (ParkingSpace) o;
        return isFree == that.isFree && this.carInSpace.equals(that.carInSpace);
    }

    // methods

    @Override
    public String toString() {
        return this.isFree ? "is free" : ( this.carInSpace.getRegistrationNo() + "\t" + this.carInSpace.getColour() );
    }

    public void print(){
        if (this.isFree){
            System.out.println("is free");
        } else {
            this.getCarInSpace().print();
        }
    }

}
