package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream outputStream;
    public QuestionFileOutputStream(AmigoOutputStream stream) {
        this.outputStream = stream;

    }

    @Override
    public void flush() throws IOException {
        this.outputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.outputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equals("Д")){
            this.outputStream.close();
        }




    }
}

