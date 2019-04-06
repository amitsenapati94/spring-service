//https://www.callicoder.com/java-8-completablefuture-tutorial/

/*
program to get CompletableFuture from any of CompletableFuture completes first
*/

package com.springservice.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MultiThread2 {

    public static void main(String[] args) {
        MultiThread2 multiThread2 = new MultiThread2();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 2";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2);

        try {
            System.out.println(anyOfFuture.get()); // Result of Future 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
