package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String tmp = bufferedReader.readLine();
        while(tmp != null){
            for(String str : tmp.split(" ")){
                if(str.matches(".*\\d.*") && str.matches(".*\\w.*")){
                    list.add(str);
                }
            }
            tmp = bufferedReader.readLine();
        }
        bufferedReader.close();
        try(FileWriter fileWriter = new FileWriter(args[1])){
            for(String str : list){
                    fileWriter.write(str.concat(" "));
            }
        }

    }

}
