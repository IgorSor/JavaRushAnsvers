package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available()>0){
            fileInputStream.read(buffer);
        }
        fileInputStream.close();
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
       // byte[] newBuffer = win1251TestString.getBytes("Windows-1251");
      //  System.out.println(new String(newBuffer));
        String text = new String(buffer,utf8);
        buffer = text.getBytes(windows1251);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
}
