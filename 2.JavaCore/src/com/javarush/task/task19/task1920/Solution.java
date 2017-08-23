package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Double max = 0.0;
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        HashMap<String,Double> mapPeople = new HashMap<>();
        while(fileReader.ready()){
            String line = fileReader.readLine();
            if(line.length()>1){
                String temp[] = line.split(" ");
                if(!mapPeople.containsKey(temp[0])){

                    mapPeople.put(temp[0],Double.parseDouble(temp[1]));

                }else {
                    Double value = mapPeople.get(temp[0])+Double.parseDouble(temp[1]);
                    if (value>max){
                        max = value;
                    }
                    mapPeople.put(temp[0],value);
                }
            }

        }
        fileReader.close();
        List list = new ArrayList(mapPeople.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> a, Map.Entry<String, Double> b) {
                return (int)(a.getValue() - b.getValue());
            }
        });
        for (int i=0;i<list.size();i++){
            Map.Entry<String, Double> temp = (Map.Entry<String, Double>) list.get(i);
            if(temp.getValue()>=max){
                System.out.println(temp.getKey());
            }

        }

    }
}
