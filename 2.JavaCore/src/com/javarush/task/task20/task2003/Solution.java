package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        load(fileInputStream);
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties pr = new Properties();
        for (Map.Entry<String, String> str : properties.entrySet()){
            String key = str.getKey();
            String value = str.getValue();
            System.out.println(key + " - "+ value);
            pr.put(key,value);
        }
        pr.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {

       Properties pr = new Properties();
       pr.load(inputStream);
       for (String str : pr.stringPropertyNames()){
            String key = str;
            String value = pr.get(str).toString();
            System.out.println(key +" - "+value);
            properties.put(key,value);
        }

    }

    public static void main(String[] args) throws Exception {

    }
}
