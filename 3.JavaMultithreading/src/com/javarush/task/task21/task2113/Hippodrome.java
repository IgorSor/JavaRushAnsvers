package com.javarush.task.task21.task2113;


import java.util.*;


/**
 * Created by MadHarry on 19.03.2017.
*//*
public class Hippodrome {
    private static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public void setHorses(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(horses);

        Horse horse1 = new Horse("Sleven",3,0);
        Horse horse2 = new Horse("Lucky",3,0);
        Horse horse3 = new Horse("Gomer",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game.run();



    }

    public Hippodrome(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(){
    }
    public void move(){
        for (Horse h : horses){
            h.move();
        }
    }
    public void print(){

    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Ошибка sleep");
            }
        }
    }

}*/
public class Hippodrome {
    private static List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }
    public void run(){
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                System.out.println("Ошибка sleep");
            }
        }
    }
    public void print(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).print();
        }
        for(int i = 0;i<10;i++){
            System.out.println();
        }

    }
    public Horse getWinner(){
        double max = 0;

        for (Horse horse : horses){
            if (horse.distance>max){
                max = horse.distance;
            }
        }
        int index = 0;
        for (int i = 0;i<horses.size();i++){
            if(horses.get(i).distance >= max)
            index = i;
        }
        return horses.get(index);
    }
    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName()+"!");
    }

    public void move(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).move();
        }
    }

    public static void main(String[] args) {
        game = new Hippodrome(horses);
        Horse horse1 = new Horse("Sleven",3,0);
        Horse horse2 = new Horse("Lucky",3,0);
        Horse horse3 = new Horse("Gomer",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();

    }
}