package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printThrowable(e);
     }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread();
        solution.uncaughtException( thread,new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
    public void printThrowable(Throwable e){
        if(e.getCause() != null){

            printThrowable(e.getCause());

        }System.out.println(e.fillInStackTrace());
    }
}
