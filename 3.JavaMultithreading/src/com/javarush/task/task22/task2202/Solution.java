package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int indexSpace =0,firstIndex =0;
                try{

                    firstIndex = string.indexOf(" ");
                    //System.out.println(indexSpace);
                    if(string.length() <39){
                        throw new TooShortStringException();
                    }
                    indexSpace +=string.lastIndexOf(" ",string.length());
                }
                catch (TooShortStringException e){
                    e.printStackTrace();
                }
        return string.substring(firstIndex+1,indexSpace);

    }

    public static class TooShortStringException extends RuntimeException {

    }
}
