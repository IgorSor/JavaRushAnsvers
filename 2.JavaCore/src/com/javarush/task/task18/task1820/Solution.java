package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        FileInputStream file = new FileInputStream(str);
        FileOutputStream file2 = new FileOutputStream(str2);
        while(file.available()>0){
            int data = file.read();
            String temp ="";
            while(true){

                if (data == 32 || file.available()<=0){
                    break;
                }
                else{
                    temp+=(char)data;
                   // System.out.println(temp);
                }
                data = file.read();
            }
            temp+=(char)data;
            double d = Double.parseDouble(temp);
            int end =(int)Math.round(d);
            String res = "" +end;
            for (int i = 0; i<res.length();i++){
                file2.write((int)res.charAt(i));
            }
            file2.write(32);
        }
        file.close();
        file2.close();

    }
}
