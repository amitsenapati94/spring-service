package com.springservice.multithread;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplyAsyncExample4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);

        Stream<CompletableFuture<String>> completableFutureStream = list.stream().map(n -> CompletableFuture.supplyAsync(() -> getDataById(n)));


        completableFutureStream.forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        });

        System.out.println("running main thread");


        //System.out.println("Number of elements:"+ count);

    }
    private static String getDataById(int id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getDataById: "+ Thread.currentThread().getName());
	return "Data:"+ id;
    }
    private static String sendData(String data) {
	System.out.println("sendData: "+ Thread.currentThread().getName());
	System.out.println(data);
	return data;
    }    
} 