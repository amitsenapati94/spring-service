package com.springservice.multithread;

import java.util.concurrent.CompletableFuture;

public class AsyncProcess {

    public static void main(String[] args) {

        System.out.println("start");
        AsyncProcess asyncProcess = new AsyncProcess();


        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            
            for(int i=0;i<3;i++) {
              asyncProcess.someMethod();
            }


            System.out.println("I'll run in a separate thread than the main thread.");
        });
        System.out.println("continue main thread");

    }

    public static void someMethod(){

        System.out.println("exec method");
    }
}
