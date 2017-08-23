package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.*;

import java.text.ParseException;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person pers = null;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        switch (args[0].toLowerCase()){
            case "-c":
                String name = args[1];

                pers = (args[2].contains("м"))?
                    Person.createMale(name,f.parse(args[3]) ):
                Person.createFemale(name, f.parse(args[3]));

                allPeople.add(pers);
                System.out.println(allPeople.indexOf(pers));
                  break;
            case "-u":
                int index = Integer.parseInt(args[1]);
                pers = allPeople.get(index);
                name = args[2];
                pers = args[3].contains("м")?Person.createMale(name,f.parse(args[4]))
                    :Person.createFemale(name, f.parse(args[4]));


                allPeople.set(index, pers);
                break;
            case "-d":
                index = Integer.parseInt(args[1]);
                pers = allPeople.get(index);
                pers.setName(null);
                pers.setSex(null);
                pers.setBirthDay(null);
                allPeople.set(index,pers);
                break;
            case "-i":
                index = Integer.parseInt(args[1]);
                System.out.print(allPeople.get(index).getName()+" ");
                if (allPeople.get(index).getSex() == Sex.FEMALE){
                    System.out.print("ж");
                }else{
                    System.out.print("м");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                System.out.print(" "+sdf.format(allPeople.get(index).getBirthDay()));
                break;

            default:
                System.out.println("Недопустимая команда.");
        }
    }
}
