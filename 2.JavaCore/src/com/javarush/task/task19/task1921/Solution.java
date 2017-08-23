package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        while(fileReader.ready()) {
            String query = fileReader.readLine().trim();

            if(query.length() >0 && !query.isEmpty() ){
                String[] name = query.split("\\s\\d+");

                    System.out.println(name.length);

                String[] birthday = query.split("^\\D+\\s");
                System.out.println(birthday[1]);

            }
            else continue;

        }
        fileReader.close();
        for (Person p : PEOPLE) {
            System.out.println(p.getName()+" "+p.getBirthday());
        }
    }
}
