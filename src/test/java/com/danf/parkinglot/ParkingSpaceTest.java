package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        ParkingSpace freeSpace = new ParkingSpace();

        Assert.assertNotNull(myParkingSpace);
        Assert.assertEquals(myParkingSpace,sameParkingSpace);
        Assert.assertNotEquals(myParkingSpace,diffParkingSpace);
        Assert.assertTrue(freeSpace.isFree());

    }

    @Test
    public void parkingSpacePrintTest(){
        Car myCar = new Car("Reg1","Green");
        ParkingSpace mySpace = new ParkingSpace(myCar);

        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        String expPrint = myCar.getRegistrationNo() + "\t" + myCar.getColour() + "\r\n";
        mySpace.print();

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    @Test
    public void parkingSpaceFreePrintTest(){
        ParkingSpace freeSpace = new ParkingSpace();

        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        String expPrint = "is free\r\n";
        freeSpace.print();

        Assert.assertEquals(expPrint, actualPrint.toString());

    }


    @Test
    public void parkingSpaceToStringTest(){
        Car myCar = new Car("Reg1","Green");
        ParkingSpace mySpace = new ParkingSpace(myCar);
        
        ParkingSpace freeSpace = new ParkingSpace();

        Assert.assertEquals("REG1" + "\t" + "Green", mySpace.toString());
        Assert.assertEquals("is free", freeSpace.toString());
    }

}
