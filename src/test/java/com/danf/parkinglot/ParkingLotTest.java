package com.danf.parkinglot;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ParkingLotTest {

    private final int PARKING_SIZE = 6;
    private final String IS_FREE_STR = "is free";
    private final String LOT_FULL_STR = "Sorry, parking lot is full";
    private final String ALLOCATE_STR = "Allocated slot number: ";
    private final String REM_CAR_STR_I = "Slot number ";
    private final String REM_CAR_STR_II =  " is free";

    /**
     * Tests the constructor of the parking lot
     */
    @Test
    public void makeParkingLotTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);

        Assert.assertNotNull(myParking);
        Assert.assertEquals(IS_FREE_STR, myParking.getSpaceList()[PARKING_SIZE-1].toString());
        Assert.assertEquals(PARKING_SIZE, myParking.getSpaceList().length);
    }

    /**
     * Tests finding the first free space in the parking lot
     */
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

    @Test
    public void parkingLotPrintTest(){
        int size = 2;
        String myReg = "DA-26-NF-1234";
        String myCol = "Orange";
        ParkingLot myParking = new ParkingLot(size);
        Car myCar = new Car(myReg,myCol);

        for ( int i=0; i<size; i++) {
            myParking.parkCar(myCar);
        }

        myParking.removeCar(0);

        String expPrint = "No" + "\t" + "Registration No." + "\t" + "Colour" + "\r\n" +
                size + "\t" + myReg + "\t" + myCol + "\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.print();
        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    /**
     * tests adding to a space beyond size of parking lot
     * expects an ArrayIndexOutOfBoundsException
     */
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
    public void parkCarTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        Car myCar = new Car("DA-26-NF-1234","Orange");

        for ( int i=0; i<PARKING_SIZE-1; i++) {
            myParking.parkCar(myCar);
        }

        Assert.assertEquals(myCar, myParking.getSpaceList()[PARKING_SIZE-2].getCarInSpace());
        Assert.assertTrue(myParking.getSpaceList()[PARKING_SIZE-1].isFree());

        myParking.parkCar(myCar);

        String expPrint = LOT_FULL_STR + "\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.parkCar(myCar);

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    @Test
    public void parkCarPrintTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        Car myCar = new Car("DA-26-NF-1234","Orange");

        String expPrint = ALLOCATE_STR + "1\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.parkCar(myCar);

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    @Test
    public void removeCarTest(){
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        Car myCar = new Car("DA-26-NF-1234","Orange");

        for ( int i=0; i<PARKING_SIZE; i++) {
            myParking.parkCar(myCar);
        }

        String expPrint = REM_CAR_STR_I + PARKING_SIZE + REM_CAR_STR_II + "\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.removeCar(PARKING_SIZE-1);

        Assert.assertEquals(expPrint, actualPrint.toString());
        Assert.assertTrue(myParking.getSpaceList()[PARKING_SIZE-1].isFree());

    }

    @Test
    public void getRegCarsByColourTest(){
        String myCol = "Blue";
        Car myCar = new Car("DA-26-NF-1234",myCol);

        ParkingLot myParking = getFullLot();

        ArrayList<Car> blueList = myParking.getCarsByColour(myCol);
        Assert.assertEquals(myCar,blueList.get(1));

        String expPrint = "DA-26-NF-1234,DA-26-NF-1234\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.registrationNumbersForCarsColour(myCol);

        Assert.assertEquals(expPrint, actualPrint.toString());

    }

    private ParkingLot getFullLot(){
        String myCol = "Blue";
        ParkingLot myParking = new ParkingLot(PARKING_SIZE);
        Car myCar = new Car("DA-26-NF-1234",myCol);
        Car gCar = new Car("DA-26-NF-1234","Green");
        Car oCar = new Car("DA-26-NF-1234","Orange");

        myParking.parkCar(myCar);
        myParking.parkCar(gCar);
        myParking.parkCar(oCar);
        myParking.parkCar(myCar);

        return myParking;

    }

    @Test
    public void slotNumbersForCarsColourTest(){
        ParkingLot myParking = getFullLot();

        Assert.assertEquals("1,4\r\n", myParking.slotNumbersForCarsColour("Blue"));
    }

    @Test
    public void slotForRegNumberTest(){
        int size = 2;
        String myReg = "DA-26-NF-1234";
        String otherReg = "XX-26-XX-1234";
        String diffReg = "OO-26-OO-1234";
        String myCol = "Orange";

        ParkingLot myParking = new ParkingLot(size);
        Car myCar = new Car(myReg,myCol);
        Car otherCar = new Car(otherReg,myCol);

        for ( int i=0; i<size-1; i++) {
            myParking.parkCar(otherCar);
        }
        myParking.parkCar(myCar);

        String expPrint = size + "\r\nNot found\r\n";
        ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrint));

        myParking.slotForRegNumber(myReg);
        myParking.slotForRegNumber(diffReg);

        Assert.assertEquals(expPrint, actualPrint.toString());

    }
}
