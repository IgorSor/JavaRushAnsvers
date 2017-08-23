package com.javarush.task.task08.task0818;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("petrov",510);
        map.put("ivanov",498);
        map.put("sidorov",700);
        map.put("vasya",500);
        map.put("fedor",900);
        map.put("syma",700);
        map.put("olga",498);
        map.put("mihail",900);
        map.put("anton",300);
        map.put("alex",950);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
           String s = entry.getKey();
           int i = entry.getValue();
           if (i<500){
               list.add(s);
           }
       }
       for (String str : list){
            map.remove(str);
       }
       for (Map.Entry<String,Integer> entry : map.entrySet()){
           System.out.println(entry.getKey() + " "+ entry.getValue());
    }

    }

    public static void main(String[] args) throws IOException {
        //removeItemFromMap(createMap());

    }
}