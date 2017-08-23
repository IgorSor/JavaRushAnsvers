package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double d) {
        //TODO:
        int index = 0;
        for (Student s : students){
            if(s.getAverageGrade() == d) index = students.indexOf(s);

        }
        return students.get(index);
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = students.get(0).getAverageGrade();
        int index = 0;
        for(Student s : students){
            if(s.getAverageGrade() > max){
                max = s.getAverageGrade();
            }
        }
        for (Student s: students){
            if(s.getAverageGrade() == max) index = students.indexOf(s);
        }
        return students.get(index);
    }


    public Student getStudentWithMinAverageGrade(){
        double min = students.get(0).getAverageGrade();
        int index = 0;
        for(Student s : students){
            if(s.getAverageGrade() < min){
                min = s.getAverageGrade();
            }
        }
        for (Student s: students){
            if(s.getAverageGrade() == min) index = students.indexOf(s);
        }
        return students.get(index);
    }
    public void expel(Student student){
        students.remove(student);
    }
}