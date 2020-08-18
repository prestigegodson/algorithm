package com.prestige.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by prest on 3/11/2019.
 */
public class ThreadPool {

    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count : " + coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for(int i = 0; i < 100; i++){

            executorService.execute(new ThreadJob());
        }

    }

    static class ThreadJob implements Runnable {


        @Override
        public void run() {
            System.out.println("Running Thread : " + Thread.currentThread().getName());
        }
    }
}
