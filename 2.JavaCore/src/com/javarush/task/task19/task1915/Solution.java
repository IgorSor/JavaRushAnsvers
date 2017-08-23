package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String string = reader.readLine();
        reader.close();
        PrintStream console = new PrintStream(outputStream);
        System.setOut(console);
        testString.printSomething();
        String result = outputStream.toString();
        FileOutputStream fileOutputStream = new FileOutputStream(string);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();

        System.setOut(consolePrintStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

