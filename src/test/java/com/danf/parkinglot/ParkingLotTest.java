package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        ParkingLot myParking = new ParkingLot(5);
        Car iCar = new Car("ab-01-cd-1234","BLUE");
        Car iiCar = new Car("ef-01-gh-1234","red");
        Car iiiCar = new Car("ij-01-kl-1234","WHite");
        Car ivCar = new Car("mn-01-op-1234","green");
        Car vCar = new Car("qr-01-st-1234","WHite");

        myParking.parkInGivenSpot(iCar,0);
        myParking.parkInGivenSpot(iiCar,1);
        myParking.parkInGivenSpot(iiiCar,2);
        Assert.assertEquals(3,myParking.firstFreeSpace());

        myParking.parkInGivenSpot(ivCar,3);
        Assert.assertEquals(4,myParking.firstFreeSpace());

        myParking.parkInGivenSpot(vCar,4);
        Assert.assertEquals(-1,myParking.firstFreeSpace());
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    // expects an ArrayIndexOutOfBoundsException
    @Test
    public void tooManyCarsTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        Car aCar = new Car("ZY-98-XW-9876", "grey");

        thrown.expect(ArrayIndexOutOfBoundsException.class);
        myParking.parkInGivenSpot(aCar,PARKING_SIZE);

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
