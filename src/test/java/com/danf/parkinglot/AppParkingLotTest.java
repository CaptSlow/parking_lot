package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

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

}
