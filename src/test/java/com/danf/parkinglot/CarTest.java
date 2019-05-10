package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CarTest {

    @Test
    public void carEqualsTest(){
        String myReg = "DA-01-NF-5100";
        String myColour = "BlacK";

        String sameReg = "da-01-nf-5100";
        String sameColour = "black";

        String diffReg = "DA-01-NF-5000";
        String diffColour = "Blue";

        Car myCar = new Car(myReg,myColour);
        Car sameCar = new Car();
        Car diffCar = new Car();

        sameCar.setRegistrationNo(sameReg);
        sameCar.setColour(sameColour);

        diffCar.setRegistrationNo(diffReg);
        diffCar.setColour(diffColour);

        Assert.assertNotNull(myCar);
        Assert.assertEquals(myCar,sameCar);
        Assert.assertNotEquals(myCar,diffCar);

    }

    @Test
    public void carPrintTest(){
        String myReg = "da-01-nf-5100";
        String myColour = "BlacK";

        Car myCar = new Car(myReg,myColour);

        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        String expPrint = myCar.getRegistrationNo() + "\t" + myCar.getColour() + "\r\n";

        myCar.print();

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

}
