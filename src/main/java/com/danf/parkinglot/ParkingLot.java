package com.danf.parkinglot;

public class ParkingLot {

    private int numSpaces;
    private ParkingSpace[] spaceList;

    // constructor
    public ParkingLot(int numSpaces) {
        this.numSpaces = numSpaces;
        this.spaceList = new ParkingSpace[numSpaces];

        for (int i=0; i<this.spaceList.length; i++){
            this.spaceList[i] = new ParkingSpace();
        }
    }

    public ParkingSpace[] getSpaceList() {
        return spaceList;
    }

    //    ******* METHODS ********

    public void print(){
        System.out.println("No" + "\t" + "Registration No." + "\t" + "Colour");
        int i = 0;
        for ( ParkingSpace ps : this.spaceList ) {
            i++;
            System.out.println(i + "\t" + ps.toString());
        }
    }

    // method to return the lowest number parking space that is free
    public int firstFreeSpace(){
        int freeSpot=-1;

        for (int i=0; i<this.spaceList.length; i++){
            if (this.spaceList[i].isFree()){
                freeSpot=i;
                break;
            }
        }

//        while ( !this.spaceList[spotNum].isFree() && spotNum<this.spaceList.length ){
//            spotNum++;
//        }

        return freeSpot;
    }

    public void parkInGivenSpot(Car car, int spotNum){
        this.spaceList[spotNum] = new ParkingSpace(car);
    }


    // method to park car - in lowest number parking space
    public void parkCar(Car newCar) {
        // find first free space
        // add newCar to list spacelist in that index
        // print out
    }

    private void addCar(Car newCar, int position){



    }

    public void removeCar(int spaceNumber){
        // remove car at given place from list
        // add info to log
    }

}
