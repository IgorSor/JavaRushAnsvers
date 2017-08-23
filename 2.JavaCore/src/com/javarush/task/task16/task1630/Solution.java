package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String fileName;
        public String fileContent = "";
        @Override
        public void setFileName(String fullFileName) {
            //System.out.println("in constructor");
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return this.fileContent;
        }

        @Override
        public void start() {
            this.run();
        }

        @Override
        public void run() {
            try {
                //System.out.println("in run");
                FileInputStream file = new FileInputStream(this.fileName);
                //byte[] buffer = new byte[file.available()];
               // int count = 0;
                while(file.available() >0){
                    //count = file.read(buffer);
                    int data  = file.read();
                    if (data != 13 && data != 10){
                        fileContent+=(char)data;
                    }
                    else fileContent+=" ";
                   // System.out.println(data);
                }
                file.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
