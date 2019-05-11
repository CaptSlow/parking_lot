package com.danf.parkinglot;

public class ParkingLot {

    private int numSpaces;
    private ParkingSpace[] spaceList;

    private final String LOT_FULL_STR = "Sorry, parking lot is full";
    private final String CREATE_LOT_STR_I = "Created a parking lot with ";
    private final String CREATE_LOT_STR_II = " slots";
    private final String SLOT_NO_STR = "No";
    private final String REG_NO_STR = "Registration No.";
    private final String COLOUR_STR= "Colour";
    private final String ALLOCATE_STR = "Allocated slot number: ";
    private final String REM_CAR_STR_I = "Slot number ";
    private final String REM_CAR_STR_II =  " is free";


    /**
     * Parking lot constructor
     * @param numSpaces the size of the car park, has to be more than 0
     * Has to have a number of spaces or it is not created
     */
    public ParkingLot(int numSpaces) {
        if (numSpaces<1){
            System.out.println("Cannot create parking lot with less than 1 slot");
            // TODO expand on this
        } else {
            this.numSpaces = numSpaces;
            this.spaceList = new ParkingSpace[numSpaces];

            for (int i = 0; i < this.spaceList.length; i++) {
                this.spaceList[i] = new ParkingSpace();
            }
            System.out.println(CREATE_LOT_STR_I + numSpaces + CREATE_LOT_STR_II);
        }
    }

    public ParkingSpace[] getSpaceList() {
        return spaceList;
    }

    //    ******* METHODS ********

    /**
     * Prints the car park's status
     */
    public void print(){
        System.out.println(SLOT_NO_STR + "\t" + REG_NO_STR + "\t" + COLOUR_STR);
        int i = 0;
        for ( ParkingSpace ps : this.spaceList ) {
            i++;
            if (!ps.isFree()) {
                System.out.println(i + "\t" + ps.toString());
            }
        }
    }

    /**
     * method to return the lowest number parking space that is free
     */
    public int firstFreeSpace(){
        int freeSpot=-1;

        for (int i=0; i<this.spaceList.length; i++){
            if (this.spaceList[i].isFree()){
                freeSpot=i;
                break;
            }
        }
        return freeSpot;
    }

    /**
     * Parks a car in a specific spot
     * @param car to park
     * @param spotNum to park in
     */
    public void parkInGivenSpot(Car car, int spotNum){
        this.spaceList[spotNum] = new ParkingSpace(car);
    }

    /**
     * method to park car - in lowest number parking space
     * @param newCar the car to be parked
     */
    public void parkCar(Car newCar) {
        int slot = firstFreeSpace();
        if (slot==-1) {
            System.out.println(LOT_FULL_STR);
        } else {
            this.parkInGivenSpot(newCar, slot);
            System.out.println(ALLOCATE_STR + (slot+1));
        }

    }

    /**
     * Remove a car from a slot
     * @param slotNumber that car is remove from
     */
    public void removeCar(int slotNumber) {
        this.spaceList[slotNumber] = new ParkingSpace();
        System.out.println(REM_CAR_STR_I + (slotNumber+1) + REM_CAR_STR_II);
    }

    public void slotNumbersForCarsColour(String colour){
        // todo return/print slots for cars
    }

    public void registrationNumbersForCarsColour(String colour){
        // todo return/print regs for cars
    }

    public void slotForRegNumber(String regNumber){
        // return slot for reg number
        boolean exists=false;
        for (int i = 0; i < this.spaceList.length; i++) {
            if (this.spaceList[i].getCarInSpace().getRegistrationNo().equals(regNumber)){
                System.out.println(i+1);
                exists=true;
            }
        }
            if (!exists){
                System.out.println("Not found");
            }
    }
}
