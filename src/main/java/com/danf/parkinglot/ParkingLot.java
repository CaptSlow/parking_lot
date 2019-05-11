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


    /**
     * Parking lot constructor
     * @param numSpaces the size of the car park
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
            System.out.println(i + "\t" + ps.toString());
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


    public void removeCar(int slotNumber) {
        // todo remove car from a specific spot
        System.out.println("Slot number " + slotNumber + " is free");
    }

}
