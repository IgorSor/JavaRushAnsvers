package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(fileReader));
        reader.close();
        while(fr.ready()){
            StringBuffer sb = new StringBuffer(fr.readLine());
            System.out.println(sb.reverse().toString());
        }
        fr.close();

    }
}
