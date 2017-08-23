package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person pers = null;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH),sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);;
        String name = "";
        int index;
        switch (args[0]){
            case "-c":
                    for (int i = 1; i < args.length - 2; i += 3) {
                        name = args[i];
                        pers = (args[i + 1].contains("м")) ?
                                Person.createMale(name, f.parse(args[i + 2])) :
                                Person.createFemale(name, f.parse(args[i + 2]));
                        synchronized (allPeople) {
                        allPeople.add(pers);
                    }
                    System.out.println(allPeople.indexOf(pers));
                }
                break;
            case "-u":
                    for (int i = 1; i < args.length - 2; i += 4) {
                        index = Integer.parseInt(args[i]);
                        synchronized (allPeople) {
                        pers = allPeople.get(index);
                        name = args[i + 1];
                        pers = args[i + 2].contains("м") ? Person.createMale(name, f.parse(args[i + 3]))
                                : Person.createFemale(name, f.parse(args[i + 3]));

                        allPeople.set(index, pers);
                        }
                    }
                    break;
            case "-d":
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        synchronized (allPeople) {
                        pers = allPeople.get(index);
                        pers.setName(null);
                        pers.setSex(null);
                        pers.setBirthDay(null);

                        allPeople.set(index, pers);
                        }
                }
                break;

            case "-i":
                for (int i = 1; i < args.length; i++) {synchronized (allPeople) {
                    index = Integer.parseInt(args[i]);

                    System.out.println(allPeople.get(index).getName() + " " + (allPeople.get(index).getSex() == Sex.FEMALE ? "ж" : "м") + " "
                            + sdf.format(allPeople.get(index).getBirthDay()));
                }
            }
                break;

        }
    }
}
