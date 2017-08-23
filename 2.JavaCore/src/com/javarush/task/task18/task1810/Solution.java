package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException,IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            //String str = ;
            FileInputStream file = new FileInputStream(reader.readLine());
            System.out.println(file.available());
            if(file.available()<1000){
                file.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
