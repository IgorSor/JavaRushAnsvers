package com.javarush.task.task29.task2909.car;

/**
 * Created by MadHarry on 08.05.2017.
 */
public class Sedan extends Car {
    private static final int MAX_SEDAN_SPEED = 120;
    public Sedan(int numberOfPassengers) {
        super(2,numberOfPassengers);
    }
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
