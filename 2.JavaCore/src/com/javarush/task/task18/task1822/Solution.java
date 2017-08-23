package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = reader.readLine();
        //FileInputStream file = new FileInputStream(fileReader);
       BufferedReader br = new BufferedReader(new FileReader(fileReader));
        int id = Integer.parseInt(args[0]);
       while (true){
           String s = br.readLine();
           if (s == null) {
               break;
           }
           if (id == Integer.parseInt(s.split(" ")[0])) {
               System.out.println(s);
               br.close();
               break;
           }
       }

    }
}
