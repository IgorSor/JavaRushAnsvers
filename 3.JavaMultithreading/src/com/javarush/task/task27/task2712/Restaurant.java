package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by MadHarry on 08.08.2017.
 */
public class Restaurant {
    public static void main(String[] args){
        Tablet tablet = new Tablet(5);
        Order order = tablet.createOrder();


        Cook cook = new Cook("Vinchenco");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        if (!order.isEmpty())cook.update(tablet,order);

    }
}
