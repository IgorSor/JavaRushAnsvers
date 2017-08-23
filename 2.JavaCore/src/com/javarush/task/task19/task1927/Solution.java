package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream console = new PrintStream(outputStream);
        System.setOut(console);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consolePrintStream);
        String[] temp = result.split("\n");
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<temp.length;i++){
            sb.append(temp[i]).append("\n");
            if((i+1)%2==0){
                sb.append("JavaRush - курсы Java онлайн").append("\n");
            }
        }
        System.out.println(sb.toString());
     }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
