package com.javarush.task.task19.task1924;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");


    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = reader.readLine();
        reader.close();
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReader))){
            String line = bufferedReader.readLine();
            while(line != null){
                StringBuilder sb = new StringBuilder();
                if(!line.isEmpty()){

                    for(String s : line.split(" ")){
                        if(s.matches("\\d{1,2}"))
                            try {
                                sb.append(map.get(Integer.valueOf(s))).append(" ");
                                continue;
                            }catch (NumberFormatException e){

                            }
                        sb.append(s).append(" ");
                    }

                }
                lines.add(sb.toString());
                line = bufferedReader.readLine();
            }
        }
        for(String s : lines){
            System.out.println(s);
        }
    }
}
