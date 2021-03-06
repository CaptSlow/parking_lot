package com.danf.parkinglot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class for the parkingLotApp
 */
public class AppParkingLot {

    ParkingLot parkingLot;

    /**
     * runningMode determines how the app runs
     * 0  - interactive mode
     * 1  - read in file mode
     * -1 - should not run - too many arguments
     */
    int runningMode;

    public AppParkingLot(){
        System.out.println("Starting parking lot application");
    }

    /**
     * Getter and setter
     * @return running mode
     */
    public int getRunningMode() {
        return runningMode;
    }

    public void setRunningMode(int runningMode) {
        this.runningMode = runningMode;
    }

    /**
     * Initial run method, goes to interactive mode or read in mode
     * or undefined mode and stops
     * @param args
     */
    public void run(String[] args) {

        this.checkVariables(args);

        switch (this.getRunningMode()) {
            case -1:
                System.out.println("Exiting");
                break;
            case 0:
                System.out.println("Interactive mode");
                this.interactiveMode();
                break;
            case 1:
                System.out.println("Read in file mode");
                String fileName = args[0];
                this.readInFileMode(fileName);
                break;
            default:
                System.out.println("Other undefined mode");
        }

    }

    /**
     * @param args app input arguments
     * Sets the app's running mode by checking the number of arguments
     * 0 arguments               - mode 0  - interactive mode
     * 1 argument (txt file)     - mode 1  - read in file mode
     * 1 argument (not txt file) - mode -1 - do not run mode
     * >1 argument               - mode -1
     */
    public void checkVariables(String[] args){

        if (args.length==0){
            this.runningMode=0;
        } else if(args.length==1){
            String singleStr = args[0];
            String fileEnd = singleStr.substring(singleStr.length()-4);
            if (fileEnd.equals(".txt")){
                this.runningMode=1;
            } else {
                this.runningMode=-1;
                System.out.println("Argument is not a text file");
            }
        } else {
            this.runningMode=-1;
            System.out.println("Too many arguments");
        }

    }

    /**
     * read in file mode, gets content from file and loops rows of file and
     * determines the commands
     * @param fileName of static file with commands
     */
    public void readInFileMode(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] inArr = line.split(" ");
                this.determineCommand(inArr);
            }

        } catch (FileNotFoundException fne){
            System.out.println("FileNotFoundException - cannot find file " + fne.getMessage());
        } catch (IOException ioe){
            System.out.println("IOException - Unable to read line in file " + ioe.getMessage());
        }


    }

    /**
     * Interactive mode method, gets user input and determines command
     */
    public void interactiveMode(){
        String[] inArr = this.getUserInput();

        if (inArr.length>3){
            System.out.println("Too many arguments");
            this.interactiveMode();
        } else {
            this.determineCommand(inArr);
        }

    }

    /**
     * scan user input
     * @return String array of command and parameter
     */
    public String[] getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }

    /**
     * Determines what action to take based on input from user:
     * create_parking_lot, park, leave, status,
     * registration_numbers_for_cars_with_colour,
     * slot_numbers_for_cars_with_colour,
     * slot_number_for_registration_number, exit or default
     * @param inArr value inputted command from command line
     */
    public void determineCommand(String[] inArr){
        String command = inArr[0];

        switch (command) {
            case "create_parking_lot":
                if (inArr.length==2) {
                    this.setParkingLot(Integer.parseInt(inArr[1]));
                    if (this.runningMode==0){
                        this.interactiveMode();
                    }
                } else if (inArr.length==1) {
                    System.out.println("The Number of parking spaces is required");
                    if (this.runningMode==0){
                        this.interactiveMode();
                    }
                } else {
                    System.out.println("Too many arguments");
                    if (this.runningMode==0){
                        this.interactiveMode();
                    }
                }
                break;

            case "park":
                if (inArr.length==3) {
                    String inReg=inArr[1];
                    String inColour=inArr[2];
                    Car inCar = new Car(inReg,inColour);
                    this.parkingLot.parkCar(inCar);
                    if (this.runningMode==0){
                        this.interactiveMode();
                    }
                }
                break;

            case "leave":
                int inSlot = Integer.parseInt(inArr[1]);
                this.parkingLot.removeCar(inSlot-1);
                if (this.runningMode==0){
                    this.interactiveMode();
                }
                break;

            case "status":
                this.parkingLot.print();
                if (this.runningMode==0){
                    this.interactiveMode();
                }
                break;

            case "registration_numbers_for_cars_with_colour":
                this.parkingLot.registrationNumbersForCarsColour(inArr[1]);
                if (this.runningMode==0){
                    this.interactiveMode();
                }
                break;

            case "slot_numbers_for_cars_with_colour":
                System.out.print(this.parkingLot.slotNumbersForCarsColour(inArr[1]));
                if (this.runningMode==0){
                    this.interactiveMode();
                }
                break;

            case "slot_number_for_registration_number":
                this.parkingLot.slotForRegNumber(inArr[1]);
                if (this.runningMode==0){
                    this.interactiveMode();
                }
                break;

            case "exit":
                System.out.println("Bye bye");
                break;

            default:
                System.out.println("Unknown command. Type exit to exit");
                if (this.runningMode==0){
                    this.interactiveMode();
                }
        }
    }

    /**
     * create
     * @param numSpaces size of new parking lot
     */
    public void setParkingLot(int numSpaces){
        this.parkingLot = new ParkingLot(numSpaces);
    }

}
