package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file = new FileInputStream(args[0]);

        HashMap<Integer,Integer> map = new HashMap<>();
        try {
            while(file.available()>0){
                int data = file.read();
                if(map.containsKey(data)){
                    int value = map.get(data);
                    map.put(data, ++value);
                }else {
                    map.put(data,1);
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getKey() - b.getKey();
            }
        });

        for (int i=0;i<list.size();i++){
            Map.Entry<Integer,Integer> temp = (Map.Entry<Integer, Integer>) list.get(i);
            int key = temp.getKey();
            System.out.println((char)key+" "+temp.getValue());
        }
    }
}
