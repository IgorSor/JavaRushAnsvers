package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] str = url.substring(url.indexOf("?")+1).split("&");
        String param = "";
        for (int i = 0;i<str.length;i++){
            //System.out.println(str[i]);

                if(str[i].contains("=")){
                    String[] temp = str[i].split("=");
                    str[i] = temp[0];
                    if(str[i].startsWith("obj")){
                        param = temp[1];
                    }
                }
        }
        for(int i = 0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
        System.out.println();
        if(param.length()>0){
                try{
                    alert(Double.parseDouble(param));
                }catch (Exception e){
                    alert(param);
                }

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
