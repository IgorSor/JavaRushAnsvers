package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadHarry on 08.08.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String inputString = null;
        try {
            inputString =  reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }
    public static List<Dish> getAllDishesForOrder(){
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда: ");
        String answer = readString();
        while(!answer.equals("exit")){
            switch (answer){
                case "Fish":dishes.add(Dish.Fish);break;
                case "Steak":dishes.add(Dish.Steak);break;
                case "Soup":dishes.add(Dish.Soup);break;
                case "Juice":dishes.add(Dish.Juice);break;
                case "Water":dishes.add(Dish.Water);break;
                default:writeMessage("Нет такого блюда");break;
            }
            answer = readString();
        }
        return dishes;

    }
}
