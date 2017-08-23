package com.javarush.task.task27.task2712.kitchen;
import com.javarush.task.task27.task2712.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by MadHarry on 08.08.2017.
 */
public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        setChanged();
        notifyObservers(arg);
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg,((Order)arg).getTotalCookingTime()));

    }
}
