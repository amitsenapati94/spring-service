package com.springservice.multithread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MultiThread {

    public static void main(String[] args) {

        MultiThread multiThread = new MultiThread();
        //Future<String> result = null;
        Future<List<String>> result = null;

        List<String> inputList = Arrays.asList("abc","def","xyz");

        for(String input: inputList){
            //result = multiThread.getResultOverNetwork(input);
            //String s = multiThread.getResultOverNetwork(input);

        }


        //Future<String> result = multiThread.getResultOverNetwork("abc");

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        /*ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> result = executorService.submit(() -> {
            delay(); //simulate network call
            return "{\"result\":\"success\"}";
        });

        IntStream.range(1, 10).forEach(i -> {
            try {
                delay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Doing useful work");
        });
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }

    public static void delay() throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);

    }

   /* public Future<String> getResultOverNetwork() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "{\"result\":\"success\"}";
        });
    }
*/
    public Future<String> getResultOverNetwork(String input) {
        return CompletableFuture.supplyAsync(() -> {

            return networkCall(input);
        });
    }


    public String networkCall(String input){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return input;
    }
}
