package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i<10;i++){
            arr.add(reader.readLine());
        }

        int min = arr.get(0).length();
        for (int i = 0;i<10;i++){
            if (arr.get(i).length()>=min)
                min = arr.get(i).length();
            else {

                System.out.println(i);
                break;
            }
        }

    }
}

