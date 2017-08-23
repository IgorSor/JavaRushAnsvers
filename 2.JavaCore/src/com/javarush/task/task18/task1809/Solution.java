package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);

        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);
       // outputStream.write(buffer,0,count);
        for (int i = buffer.length-1;i>=0;i--){
            outputStream.write(buffer[i]);
        }
        inputStream.close();
        outputStream.close();
    }
}
