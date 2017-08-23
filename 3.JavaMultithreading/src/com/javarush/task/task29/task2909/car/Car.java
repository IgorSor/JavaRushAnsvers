package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception { // 1.
        if (numberOfLiters < 0)throw new Exception();
        fuel += numberOfLiters;

    }
    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        return (date.after(summerStart) && date.before(summerEnd)); //2.

    }
    public double getWinterConsumption(int length){
        return winterFuelConsumption*length+winterWarmingUp;
    }
    public double getSummerConsumption(int length){
        return summerFuelConsumption*length;
    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        if (!isSummer(date,SummerStart,SummerEnd)) {
            return getWinterConsumption(length);
        } else {
            return getSummerConsumption(length);
        }

    }

    public int getNumberOfPassengersCanBeTransferred() {//2.
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        else return 0;
    }
    private boolean canPassengersBeTransferred(){//1.
        return isDriverAvailable() && fuel>0;
    }
    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();

    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers){
        Car car = null;
        if (type == 0){
            car = new Truck(numberOfPassengers);
        }
        if(type ==1){
            car =  new Sedan(numberOfPassengers);
        }
        if(type == 2){
            car =  new Cabriolet(numberOfPassengers);
        }
        return car;
    }
}