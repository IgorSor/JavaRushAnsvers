package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;

import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String str1 = ;
        //String str2 = ;
        BufferedReader bd = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader bd1 = new BufferedReader(new FileReader(reader.readLine()));
        while(true){
            String s = bd.readLine();
            if(s == null){
                break;
            }
            allLines.add(s);
        }
        bd.close();
        while (true){
            String n = bd1.readLine();
            if (n == null){
                break;
            }
            forRemoveLines.add(n);
        }
        bd1.close();
        Solution s = new Solution();
        s.joinData();

    }

    public void joinData () throws CorruptedDataException {

            if (allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
            }else {
                allLines.clear();
                throw new CorruptedDataException();
            }





    }
}
