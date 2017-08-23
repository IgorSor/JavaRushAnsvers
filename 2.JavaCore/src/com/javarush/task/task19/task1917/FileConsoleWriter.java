package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        //super(fileName, append);
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
       // super(file);
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        //super(file, append);
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);

    }

    public static void main(String[] args) {

    }


    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }

      public void write(char[] cbuf, int off, int len) throws IOException {
          this.fileWriter.write(cbuf, off, len);
          System.out.print(String.valueOf(cbuf).substring(off,off+len));

    }
    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: cbuf)
            stringBuilder.append(c);
        System.out.println(stringBuilder);
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));
    }
    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }
    public void close() throws IOException {
        this.fileWriter.close();
    }
}
