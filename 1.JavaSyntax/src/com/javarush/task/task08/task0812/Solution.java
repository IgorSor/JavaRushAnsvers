package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<10;i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int count =0,max = 1;
        for (int i =0;i<10;i++){
            for(int j=i;j<10;j++) {
                if (list.get(i) == list.get(j)) {
                    count++;
                    if (count > max) {
                        max = count;
                    }
                }
                else break;
            }
            count =0;

        }
        System.out.println(max);
    }

}