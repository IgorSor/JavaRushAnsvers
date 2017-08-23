package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        String str3 = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(str1);
        FileInputStream file2 = new FileInputStream(str2);
        FileInputStream file3 = new FileInputStream(str3);
        while (file2.available()>0){
            int data = file2.read();
            file1.write(data);
        }
        file2.close();
        while (file3.available()>0){
            int data = file3.read();
            file1.write(data);
        }
        file3.close();
        file1.close();





    }
}
