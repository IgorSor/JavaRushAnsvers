package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){

            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] tmp = line .split(" ");
                int count = 0;
                for(String word :tmp){
                    for(String s : words){
                        if(word.equals(s)){
                            count++;
                        }
                    }
                }
                if(count ==2) System.out.println(line);

            }

        }

    }
}
