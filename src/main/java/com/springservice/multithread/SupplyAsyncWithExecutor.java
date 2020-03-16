package com.springservice.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SupplyAsyncWithExecutor {

   /* public static void main(String[] args) {

        SupplyAsyncWithExecutor supplyAsyncWithExecutor = new SupplyAsyncWithExecutor();

        supplyAsyncWithExecutor.callerMethod();


    }

    private  void callerMethod() {
        List<String> inputList = Arrays.asList("abc","def","xyz");

        final ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<String>> partitions = new ArrayList<Callable<String>>();


        for(String input : inputList) {
            //partitions.add(new Worker(input));
        }

        //CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> service)


    final class Worker implements Callable<String> {

        private final String input;


        Worker(final String input) {
            this.input=input;
        }

        @Override
        public String call() {
            System.out.println("call()::Entry");
            String result = null;
            try {
                result = externalService(input);
            } catch (Exception e) {
                System.out.println("Exception in call() while calling service: " + e);
            }
            System.out.println("call()::Exit");
            return result;
        }
    }

    public String externalService(String input){

        System.out.println("inside external service");

        return input;
    }*/

}
