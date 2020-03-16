//https://community.oracle.com/docs/DOC-995305
//https://www.concretepage.com/java/java-8/java-completablefuture-supplyasync#Executor

package com.springservice.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SupplyAsync {

    public String someMethod(String input){

        try {
            /*if(input.equals("abc"))
            {
                TimeUnit.SECONDS.sleep(5);

            }*/
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("exec method");

        return input;
    }


    public static void main(String[] args) {

        SupplyAsync supplyAsync = new SupplyAsync();
        List<String> finalResult = new ArrayList<>();

        List<String> responseList = Collections.synchronizedList(new ArrayList<>());
        List<String> inputList = Arrays.asList("abc","def","xyz");
        CompletableFuture<List<String>> future = null;


        for(String input:inputList) {
            future = processTasks(supplyAsync, responseList, input);
        }

        //System.out.println("continue");

        /*try {
            List<String> myList = future.get();
            myList.stream().forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        future.thenAccept(s -> s.stream().forEach(e -> System.out.println(e)));
        //finalResult.stream().forEach( e -> System.out.println(e));



    }

    private static CompletableFuture<List<String>> processTasks(SupplyAsync supplyAsync, List<String> responseList, String input) {
        return CompletableFuture.supplyAsync(()-> {

                String result = supplyAsync.someMethod(input);

            responseList.add(result);
                return responseList;

                    });
    }

}
