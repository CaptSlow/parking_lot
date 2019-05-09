package com.danf.parkinglot;

public class Application {

    public static void main(String[] args){
        System.out.println("Starting parking lot application");
        System.out.println("Number of arguments is " + args.length);

        for(String str : args) {
            System.out.println(str);
        }

    }

}
