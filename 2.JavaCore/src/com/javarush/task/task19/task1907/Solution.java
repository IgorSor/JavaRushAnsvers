package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();
        FileReader filre = new FileReader(str);
        int countWorld =0;
        String str0 = "world";
        String testWord = "";

        StringBuilder sb = new StringBuilder();
        while(filre.ready()){
            int ch = filre.read();
            if (Character.isLetter(ch)) {
                sb.append((char)ch);
                continue;
            }
            if ((testWord = sb.toString()).equals(str0))
                countWorld++;
            sb.delete(0, sb.length());
        }
        System.out.println(sb);
        filre.close();
    }
}
