package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter ad = new PersonScannerAdapter(new Scanner(new File("L:\\file.txt")));
        Person person = ad.read();
        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String str = this.fileScanner.nextLine();

                String[] person = str.split(" ");
                String firstName = person[1],
                        middleName = person[2],
                        lastName = person[0];
                String date = person[3]+ person[4]+ person[5];
                SimpleDateFormat f = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
                return new Person(firstName, middleName, lastName, f.parse(date));

        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }


    }
}
