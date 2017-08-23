package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

//import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(args[0]);//
        int spaces = 0, liter =0 ;
        while(file.available()>0){
            int data = file.read();
           // System.out.println(data);
            if (data == 32){
                spaces++;
            }else liter++;
        }
        file.close();
        double result = ((double)spaces/(liter+spaces))*100;
        System.out.println(String.format("%.2f", result));
    }
}

