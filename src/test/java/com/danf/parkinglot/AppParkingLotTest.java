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

//    @Test
//    public void splitInteractiveInputTest(){
//        AppParkingLot myApp = new AppParkingLot();
//
//        String in = "create_parking_lot 6";
//        String[] inArr = myApp.splitInteractiveInput(in);
//
//        Assert.assertEquals("create_parking_lot", inArr[0] );
//        Assert.assertEquals("6", inArr[1] );
//
//    }

    @Test
    public void determineCommandTest(){
//        System.out.println("determineCommandTest");
//        AppParkingLot myApp = new AppParkingLot();
//        String[] in = {"create_parking_lot", "6"};
//        String expPrint = "Created a parking lot with 6 slots\r\n";
//
//        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(actualPrint));
//
//        myApp.determineCommand(in);
//
//        Assert.assertEquals(expPrint, actualPrint.toString());

    }

}
