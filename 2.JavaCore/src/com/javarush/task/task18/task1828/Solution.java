package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        long id = 0;
        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while(line != null){
                if(!line.isEmpty()) list.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        id = Long.parseLong(list.get(0).substring(0,8).trim());
        for(String s : list){
            long tmpId = Long.parseLong(s.substring(0,8).trim());
            if(tmpId > id){
                id = tmpId;
            }
        }
        //System.out.println(id);
        switch (args[0]){
            /*
            case "-c":
                StringBuilder stringBuilder = new StringBuilder(String.format("%-8d",id+1));
                stringBuilder.append(String.format("%-30s", args[1]));
                stringBuilder.append(String.format("%-8s",args[2]));
                stringBuilder.append(String.format("%-4s",args[3]));
                list.add(stringBuilder.toString());
                break;
                */
            case "-d":
               int removeId = 0;
                for(String s : list){
                    String tmp = s.substring(0,8).trim();
                    if(args[1].equals(tmp)){
                        removeId = list.indexOf(s);
                    }
                }
                list.remove(removeId);
                break;
            case "-u":
                StringBuilder sb = new StringBuilder(String.format("%-8s",args[1]));
                sb.append(String.format("%-30s", args[2]));
                sb.append(String.format("%-8s",args[3]));
                sb.append(String.format("%-4s",args[4]));
                int upd = 0;
                for(String s : list){
                    String tmp = s.substring(0,8).trim();
                    if(args[1].equals(tmp)){
                        upd = list.indexOf(s);
                    }
                }
                list.set(upd, sb.toString());
                break;
            default:break;
        }
        /*
        if(args[0].equals("-c")){
            StringBuilder stringBuilder = new StringBuilder(String.format("%-8d",id+1));
            stringBuilder.append(String.format("%-30s", args[1]));
            stringBuilder.append(String.format("%-8s",args[2]));
            stringBuilder.append(String.format("%-4s",args[3]));
            list.add(stringBuilder.toString());
        }else{
            System.exit(0);
        }*/
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            for(String str : list){
                fileOutputStream.write(str.concat("\n").getBytes());
            }
        }
    }

}
