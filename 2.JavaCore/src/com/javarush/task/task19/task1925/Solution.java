package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<>();
        while(fileReader.ready()){
            String line = fileReader.readLine();
            String[] mas = line.split(" ");
            for(String s : mas){
                if (s.length()>6){
                    list.add(s+",");
                }
            }
        }
        fileReader.close();
        String last = list.get(list.size()-1);
        list.set(list.size()-1,last.replace(",",""));
        for(String s : list){
            fileWriter.write(s);
        }
        fileWriter.close();
    }
}
