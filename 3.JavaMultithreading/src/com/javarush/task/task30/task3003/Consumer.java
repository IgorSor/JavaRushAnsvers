package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by MadHarry on 09.08.2017.
 */
public class Consumer implements Runnable {
    public Consumer(TransferQueue<ShareItem> queue) {
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
