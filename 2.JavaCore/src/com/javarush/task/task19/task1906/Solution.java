package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        reader.close();
        FileReader readerFile = new FileReader(str1);
        FileWriter writer = new FileWriter(str2);
        int index =0;

        while(readerFile.ready()){
            int data = readerFile.read();
            //System.out.println(data);
            if(index%2!=0){
                //System.out.println(data);
                writer.write(data);
            }
            index++;
        }
        readerFile.close();
        writer.close();

    }
}
