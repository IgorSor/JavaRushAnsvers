package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.util.List;

/**
 * Created by MadHarry on 08.08.2017.
 */
public class Order {
    protected List<Dish> dishes;
    private final Tablet tablet;


    public Order(Tablet tablet) {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
    if (dishes.isEmpty())return "";
        else{
            return String.format("Your order: %s of %s", dishes.toString(), tablet.toString());
        }
    }
    public int getTotalCookingTime(){
        int result = 0;
        for (Dish d : dishes){
            result+=d.getDuration();
        }
        return result;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
