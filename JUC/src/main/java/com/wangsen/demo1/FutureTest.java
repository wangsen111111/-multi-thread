package com.wangsen.demo1;
//异步调用：Ajax
//异步调用：CompletableFuture  异步执行 成功回调  失败回调
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //没有返回值的runAsync异步回调
//        //发起一个请求,异步任务
//        CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
//        });
//        System.out.println("11111");
//        completableFuture.get();//获取阻塞执行结果
        //有返回值的
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            int i=10/0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t,u)->{
            System.out.println("t=>"+t);//正常的返回结果
            System.out.println("u=>"+u);//错误信息 java.lang.ArithmeticException: / by zero
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
