package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0, middle = 0;
        while(true ){
            int str = Integer.parseInt(reader.readLine());
            if(str == -1) break;
            else {
                middle+=str;
                count++;
            }
        }
        //System.out.println(middle + " " + count);
        System.out.println((double)middle/count);
    }
}

