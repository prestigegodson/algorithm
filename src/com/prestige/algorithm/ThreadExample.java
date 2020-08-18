package com.prestige.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by prest on 10/10/2019.
 */
public class ThreadExample {

    public ThreadExample() {
    }

    public static void main(String[] args) {

        int cpus = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cpus);
        int num = 100;

        System.out.println(String.format("Available CPU : %d", cpus));
        while(num > 0){
            DoWork dowork = new DoWork();
            executorService.execute(dowork);
            num--;
        }
    }
}

class DoWork extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": running");
    }
}


