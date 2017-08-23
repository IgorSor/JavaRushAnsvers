package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

//import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws  IOException {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(args[0]);//reader.readLine()
        int litter = 0;
        while(file.available()>0){
            int data = file.read();
            //System.out.println(data);
            if (data >= 65 && data <=122){
                litter++;
            }
        }
        file.close();
        System.out.println(litter);
    }
}
