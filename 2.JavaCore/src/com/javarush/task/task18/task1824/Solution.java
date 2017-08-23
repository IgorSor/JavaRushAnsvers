package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strFile ="";

        while(true){
            FileInputStream file = null;
            try {
                strFile = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file = new FileInputStream(strFile);
            } catch (FileNotFoundException e) {
                System.out.println(strFile);
                break;
            }
            file.close();
        }
    }
}
