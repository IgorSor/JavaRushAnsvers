package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1= reader.readLine();
        String str2 = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(str1));
        BufferedWriter fileOutput = new BufferedWriter(new FileWriter(str2));
        while(file.ready()){
            String data = file.readLine();
            for(String s : data.split(" ")){
                try {
                    Integer.parseInt(s);
                    fileOutput.write(s);
                    fileOutput.write(32);
                }catch (NumberFormatException e){
                    continue;
                }
            }
        }
        fileOutput.close();
        file.close();
    }
}
