package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(str1);
        FileInputStream file2 = new FileInputStream(str2);
        byte[] buffer0 = new byte[file1.available()];
        file1.read(buffer0);
        file1.close();
        byte[] buffer = new byte[file2.available()];
        int count1 =0;
        while(file2.available()>0) {
            count1 = file2.read(buffer);
        }
        file2.close();
        FileOutputStream file0 = new FileOutputStream(str1);
        file0.write(buffer,0,count1);
        file0.write(buffer0);
        file0.close();
    }
}
