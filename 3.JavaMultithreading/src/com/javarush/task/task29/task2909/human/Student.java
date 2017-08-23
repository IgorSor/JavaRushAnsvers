package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;
    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }


    public String getPosition(){
        return "Студент";
    }
    public void live() {
        learn();
    }

    public void learn() {
    }
    public int getCourse() {
        return course;
    }

    public void incAverageGrade(double delta){
        double d = getAverageGrade()+delta;
        setAverageGrade(d);
        //averageGrade+=delta;
    }

    public void setCourse(int value){

            this.course = value;


    }
    public void setAverageGrade(double value){

            this.averageGrade = value;


    }

    public void setBeginningOfSession(Date date) {
        this.beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        this.endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}