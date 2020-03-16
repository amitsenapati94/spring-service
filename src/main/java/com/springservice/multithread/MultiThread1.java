//https://dzone.com/articles/20-examples-of-using-javas-completablefuture



package com.springservice.multithread;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiThread1 {

    public static void main(String[] args) {

        MultiThread1 multiThread1 = new MultiThread1();

        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        List<String> list = Arrays.asList("123","456");

        for (final String item : list) {
            final ListenableFuture<String> future = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return serviceCall1(item);
                }
            });

            future.addListener(new Runnable() {
                @Override
                public void run() {
                    try {
                        final String contents = future.get();
                        //...process web site contents
                        if(contents!=null) {
                            System.out.println("contents: " + contents);
                            future.cancel(true);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted"+ e);
                    } catch (ExecutionException e) {
                        System.out.println("Exception in task"+ e.getCause());
                    }
                }
            }, MoreExecutors.sameThreadExecutor());
        }


    }

    public static String serviceCall1(String s){
        try {
            if(s.equals("123")) {

                TimeUnit.SECONDS.sleep(1);
            }
            else if (s.equals("456")){
                TimeUnit.SECONDS.sleep(10);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String serviceCall2(String s){
        try {

            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }
}
