package com.javarush.task.task25.task2506;

/*
Мониторинг состояния нити
*/
public class Solution {
    static class LoggingStateThread extends Thread{
        LoggingStateThread(Thread t){
            while (t.isAlive()){
                switch (t.getState()){
                    case RUNNABLE:System.out.println(t.getState());break;
                    case TERMINATED:
                        System.out.println(t.getState());break;
                    case NEW:System.out.println(t.getState());break;
                    case WAITING:System.out.println(t.getState());break;
                    case BLOCKED:System.out.println(t.getState());break;
                    case TIMED_WAITING:System.out.println(t.getState());break;
                }
            }
            super.interrupt();
        }

        @Override
        public void run() {
            super.run();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}
