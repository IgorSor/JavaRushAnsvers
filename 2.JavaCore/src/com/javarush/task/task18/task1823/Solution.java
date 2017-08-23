package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String str ;
        int index= 0;
        while(true){
            str = reader.readLine();
            if(str.equals("exit")){
                break;

            }else {
                ReadThread thread = new ReadThread(str);
                thread.start();



            }

        }

    }

    public static class ReadThread extends Thread {
        private String filename;
        private int foundByte;
        private Map<Integer, Integer> tempMap = new HashMap<>();
        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){

            try {
                int max = 1;
                FileInputStream file = new FileInputStream(this.filename);
                while (file.available()>0){
                    int data = file.read();
                    if(tempMap.containsKey(data)){
                        int value = tempMap.get(data);
                        if (value >max){
                            max = value;
                        }
                        tempMap.put(data,++value);
                    }else{
                        tempMap.put(data,1);
                    }
                }
                file.close();
                for(Map.Entry<Integer, Integer> pair : this.tempMap.entrySet()){
                    int key = pair.getKey();
                    int value = pair.getValue();
                    if(value > max){
                        //System.out.println(value + " " + key);
                        this.foundByte = key;
                    }
                }
                resultMap.put(this.filename,this.foundByte);
                tempMap.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
