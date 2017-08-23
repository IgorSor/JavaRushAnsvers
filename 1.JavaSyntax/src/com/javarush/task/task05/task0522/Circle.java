package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle(){

    }
    public Circle(double a)
    {
        this.x  = a;
    }
    public Circle(double a, double b){
        this.x = a;
        this.y = b;
    }
    public Circle(double a,double b,double c){
        this.x = a;
        this.y = b;
        this.radius = c;
    }

    public static void main(String[] args) {

    }
}