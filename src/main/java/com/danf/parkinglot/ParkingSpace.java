package com.danf.parkinglot;

import java.util.Objects;

public class ParkingSpace {

    private boolean isFree;
    private Car carInSpace;


    // Constructors

    public ParkingSpace(boolean isFree) {
        this.isFree = isFree;
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


    // methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpace that = (ParkingSpace) o;
        return isFree == that.isFree && this.carInSpace.equals(that.carInSpace);
    }

}
