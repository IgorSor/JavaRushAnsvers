package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        FileInputStream file = new FileInputStream(str);
        ArrayList<Integer> list = new ArrayList();
        while(file.available()>0){
           int data =  file.read();
           if (!list.contains(data)){
               list.add(data);
           }
        }
        file.close();
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (Integer i : list){
            System.out.print(i + " " );
        }

    }
}
