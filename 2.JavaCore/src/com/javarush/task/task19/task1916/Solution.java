package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            List<String> listToFileOne = new ArrayList<>();
            List<String> listToFileTwo = new ArrayList<>();
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            FileReader fileReader = new FileReader(fileName1);
            BufferedReader buf1 = new BufferedReader(fileReader);
            String tmp;
            while ((tmp = buf1.readLine())!= null){
                listToFileOne.add(tmp);
            }
            FileReader fileReader1 = new FileReader(fileName2);
            BufferedReader buf2 = new BufferedReader(fileReader1);
            String tmp1;
            while ((tmp1 = buf2.readLine())!= null){
                listToFileTwo.add(tmp1);
            }
            reader.close();
            fileReader.close();
            fileReader1.close();



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
