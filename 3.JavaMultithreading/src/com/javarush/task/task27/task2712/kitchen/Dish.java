package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by MadHarry on 08.08.2017.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int duration) {
        this.duration = duration;
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder();
        for(Dish d : Dish.values()){
            sb.append(d).append(" ");
        }
        return sb.toString();

    }
}
