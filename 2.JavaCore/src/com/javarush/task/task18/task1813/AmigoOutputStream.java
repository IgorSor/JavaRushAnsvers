package com.javarush.task.task18.task1813;

import java.io.*;


/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/results.txt";
    private FileOutputStream component;
    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super(fileName);
        this.component = file;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }
    @Override
    public void close() throws IOException {
        component.flush();
        component.write("JavaRush © All rights reserved.".getBytes());
        component.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

}
