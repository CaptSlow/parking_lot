package com.danf.parkinglot;

/**
 * Class for the parkingLotApp
 */
public class AppParkingLot {

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

    public int getRunningMode() {
        return runningMode;
    }

    public void setRunningMode(int runningMode) {
        this.runningMode = runningMode;
    }

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

    public void readInFileMode(String fileName){

    }

    public void interactiveMode(){

    }

}
