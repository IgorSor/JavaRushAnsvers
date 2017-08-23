package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader  reader = new BufferedReader(new F);

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputName = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            try {
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    fileOutputName.write(~data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(args[0].equals("-d")){
            try {
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    fileOutputName.write(~data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else System.out.println("Неправильный ключ.");
        fileInputStream.close();
        fileOutputName.close();


    }

}
