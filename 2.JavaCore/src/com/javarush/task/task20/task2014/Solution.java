package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        File your_file_name = File.createTempFile("myNewFile", ".txt",new File("L:\\"));
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);
        Solution savedObject = new Solution(4);
        savedObject.save(outputStream);
        System.out.println(new Solution(4));
        Solution loadedObject = new Solution(0);
        loadedObject.load(inputStream);
        outputStream.close();
        inputStream.close();
        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.println(this.string);
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        this.string = reader.readLine();
        reader.close();
    }
}
