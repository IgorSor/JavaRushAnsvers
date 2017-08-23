package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());

    }
    public static void main(String[] args) {
    }
    public static class thread1 extends Thread{
        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            while(true){
                super.run();
            }
        }
    }
    public static class thread2 extends Thread{
        @Override
        public void interrupt() {
            System.out.println("InterruptedException");
            super.interrupt();
        }

        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            super.run();
        }
    }
    public static class thread3 extends Thread{
        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            while(true){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static class thread4 extends Thread implements Message{

        @Override
        public void showWarning() {
            if(!this.isAlive()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            super.run();
        }
    }
    public static class thread5 extends Thread{
        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                int sum =0;
                String str = "";
                while(true){
                    str = reader.readLine();
                    if(str.equals("N")){
                        break;
                    }
                    else {
                        sum+=Integer.parseInt(str);
                    }
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}