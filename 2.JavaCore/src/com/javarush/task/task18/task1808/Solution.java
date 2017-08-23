package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[3];
        for (int i =0;i<3;i++){
            str[i] = reader.readLine();
        }
        FileInputStream inputStream1 = new FileInputStream(str[0]);
        FileOutputStream file1 = new FileOutputStream(str[1]);
        FileOutputStream file2 = new FileOutputStream(str[2]);
        int count = inputStream1.available();
        //System.out.println(count/2);
        int temp = count/2;
        int temp2 = count-temp;

        byte[] buffer = new byte[temp2];
        int cnt1 = inputStream1.read(buffer);
        file1.write(buffer,0,cnt1);

        byte[] buffer2 = new byte[temp];
        //System.out.println(buffer2.length);
        int cnt0 = inputStream1.read(buffer2);
        file2.write(buffer2,0,cnt0);
        inputStream1.close();
        file1.close();
        file2.close();

    }
}
