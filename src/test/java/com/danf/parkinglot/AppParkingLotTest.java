package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppParkingLotTest {

    @Test
    public void checkVariablesTest(){
        String[] oArgs={};
        String[] iArgsTxt={"myFile.txt"};
        String[] iArgsNoTxt={"oneVariable"};
        String[] iiArgs={"two","variables"};
        String[] iiiArgs={"too","many","many","variables"};

        AppParkingLot myApp = new AppParkingLot();

        myApp.checkVariables(oArgs);
        Assert.assertEquals(0, myApp.getRunningMode());

        myApp.setRunningMode(-2);
        myApp.checkVariables(iArgsTxt);
        Assert.assertEquals(1, myApp.getRunningMode());

        myApp.setRunningMode(-2);
        myApp.checkVariables(iArgsNoTxt);
        Assert.assertEquals(-1, myApp.getRunningMode());

        myApp.setRunningMode(-2);
        myApp.checkVariables(iiArgs);
        Assert.assertEquals(-1, myApp.getRunningMode());

        myApp.setRunningMode(-2);
        myApp.checkVariables(iiiArgs);
        Assert.assertEquals(-1, myApp.getRunningMode());

    }

    @Test
    public void determineCommandCreateParkingTest(){
        System.out.println("determineCommandTest");
        AppParkingLot myApp = new AppParkingLot();
        myApp.setRunningMode(1);
        String[] inArr = {"create_parking_lot", "6"};
        String expPrint = "Created a parking lot with 6 slots\r\n";

        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myApp.determineCommand(inArr);

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    @Test
    public void determineCommandParkCarTest(){
        System.out.println("determineCommandTest");
        AppParkingLot myApp = new AppParkingLot();
        myApp.setRunningMode(1);
        String[] inArr = {"park", "myreg-123","blue"};
        myApp.parkingLot = new ParkingLot(6);

        String expPrint = "Allocated slot number: 1\r\n";

        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myApp.determineCommand(inArr);
        Assert.assertEquals(expPrint, actualPrint.toString());

    }

}
