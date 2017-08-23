package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by MadHarry on 08.08.2017.
 */
public class Waiter implements Observer {
     @Override
    public void update(Observable observable, Object arg) {

         ConsoleHelper.writeMessage(String.format("%s was cooked by %s",arg, observable));
    }
}
