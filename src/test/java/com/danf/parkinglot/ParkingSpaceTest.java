package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingSpaceTest {

    @Test
    public void parkingSpaceEqualsTest() {
        String myReg = "DA-01-NF-5100";
        String myColour = "Black";

        String diffReg = "DA-01-NF-5000";
        String diffColour = "Blue";

        Car myCar = new Car(myReg, myColour);
        Car diffCar = new Car(diffReg, diffColour);

        ParkingSpace myParkingSpace = new ParkingSpace(myCar);
        ParkingSpace sameParkingSpace = new ParkingSpace(myCar);
        ParkingSpace diffParkingSpace = new ParkingSpace(diffCar);
        ParkingSpace freeSpace = new ParkingSpace(true);

        Assert.assertNotNull(myParkingSpace);
        Assert.assertEquals(myParkingSpace,sameParkingSpace);
        Assert.assertNotEquals(myParkingSpace,diffParkingSpace);
        Assert.assertTrue(freeSpace.isFree());

    }

}
