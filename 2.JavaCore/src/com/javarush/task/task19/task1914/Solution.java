package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream console = new PrintStream(outputStream);
        System.setOut(console);
        testString.printSomething();
        System.setOut(consolePrintStream);
        String result = outputStream.toString().trim();
        String temp[]= result.split(" ");
        int data = 0;
        if(temp[1].equals("+")){
            data = Integer.parseInt(temp[0])+Integer.parseInt(temp[2]);
        }else if (temp[1].equals("-")){
            data = Integer.parseInt(temp[0])-Integer.parseInt(temp[2]);
        }else if(temp[1].equals("*")){
            data = Integer.parseInt(temp[0])*Integer.parseInt(temp[2]);
        }
        else System.out.println("Неподдерживаемая операция.");

        System.out.println(result+=" "+data);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

