package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    private final int PARKING_SIZE = 6;
    private String IS_FREE_STR = "is free";

    @Test
    public void makeParkingLotNumSpacesTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);

        Assert.assertNotNull(myParking);
        Assert.assertEquals(IS_FREE_STR, myParking.getSpaceList()[PARKING_SIZE-1].toString());
        Assert.assertEquals(PARKING_SIZE, myParking.getSpaceList().length);
    }

    @Test
    public void firstFreeSpaceTest(){
//        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
    }

    @Test
    public void parkInGivenSpotTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        int spotNum = 3;
        Car myCar = new Car("ab-01-cd-1234","BLUE");

        myParking.parkInGivenSpot(myCar, spotNum);

        myParking.print();

        Car actualCar = myParking.getSpaceList()[spotNum].getCarInSpace();

        Assert.assertEquals(myCar,actualCar);

    }

    @Test
    public void createParkingLotTest(){

    }

    @Test
    public void parkCarTest(){

    }

    @Test
    public void removeCarTest(){

    }

    @Test
    public void getWhiteCarsSlotNumbersTest(){

    }

    @Test
    public void getWhiteCarsRegistrationNumbersTest(){

    }

}
