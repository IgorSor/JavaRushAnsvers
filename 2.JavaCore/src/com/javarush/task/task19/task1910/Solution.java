package com.javarush.task.task19.task1910;

/*
Пунктуация
*/

import java.io.*;

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
            fileOutput.write(data.replaceAll("\\p{Punct}",""));

        }
        fileOutput.close();
        file.close();
    }
}
