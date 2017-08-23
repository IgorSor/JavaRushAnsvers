package com.javarush.task.task31.task3102;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        File folder = new File(root);
        if(folder.isDirectory()){
            for(File file : folder.listFiles()){
                list.add(file.getName());
            }
        }



        /*Stack<File> stack = new Stack<>();
        stack.push(new File(root));
        while (!stack.isEmpty()){
            File child = stack.pop();
            if(child.isDirectory()){
                for(File f : child.listFiles()){
                    stack.push(f);
                }
            }else if(child.isFile()){
                list.add(child.getPath());
            }
        }*/

        return list;

    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();

            for(String s : getFileTree(line)){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
