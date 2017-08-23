package com.javarush.task.task21.task2113;

/**
 * Created by MadHarry on 19.03.2017.
 */
public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        Double d = Math.random();
        this.distance+=speed*d;

    }
    public void print(){
    for (int i =0;i<Math.floor(distance);i++){
        System.out.print(".");
    }
        System.out.println(name);
    }
}
