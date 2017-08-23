package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String str = ;
        int[] number = new int[15];
        for (int i=0;i<15;i++){
            //System.out.println(i + " ");
            number[i]= Integer.parseInt(reader.readLine());
        }
        int even= 0, odd = 0;
        for (int i = 0;i<15;i++){
            if (i%2 == 0 || i == 0){
                even+=number[i];
            }else odd+=number[i];
        }
        //System.out.println("even:" + even+" odd:"+odd);
        if (odd < even){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else
        {System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }

}
