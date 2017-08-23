package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String partFile = fileName.substring(0,fileName.lastIndexOf(".part"));
        //System.out.println(partFile);

        HashMap<String, byte[]> map = new HashMap<>();
        byte[] buffer;
        while(true){

            if(fileName.equals("end")){

                break;
            }else{
                FileInputStream fileInputStream = new FileInputStream(fileName);
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                map.put(fileName,buffer);
                fileInputStream.close();
            }
            fileName = reader.readLine();

        }
        reader.close();
        //System.out.println(temp);
        FileOutputStream fileOutputStream = new FileOutputStream(partFile);
        Map<String,byte[]> treeMap = new TreeMap<>(map);
        for (String str : treeMap.keySet()){
            fileOutputStream.write(treeMap.get(str));
        }
        fileOutputStream.close();

    }
}
