package com.javarush.task.task18.task1804;

import java.io.FileInputStream;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        HashMap<Integer,Integer> map =new  HashMap<Integer, Integer>();

        while (file.available()>0){
            int data = file.read();
            // System.out.println(data);
            int count = 1;
            if (!map.containsKey(data)){

                map.put(data, count);
            }else{

                int value = map.get(data);
                //System.out.println(value);
                map.put(data,++value);
            }

        }

        file.close();
        for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            //System.out.println(count);
            if (value == 1)
                System.out.print(key+" ");
        }

    }
}