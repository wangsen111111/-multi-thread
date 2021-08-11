package com.wangsen.demo1.unsafe;

import com.wangsen.demo1.ForkJoinTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
        test3();
    }
    /**
     * 使用普通方法
     */
    public static void test1() {
        long star = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 1; i <= 10_0000_0000L ; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("使用普通方法----->sum: "+sum+"时间：" + (end - star));
        System.out.println("----------------------");
    }
    /**
     * 使用ForkJoin方法
     */
    public static void test2() throws ExecutionException, InterruptedException {
        long star = System.currentTimeMillis();
        //1，通过ForkJoinPool来执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //3，计算类ForkJoinTest要去继承ForkJoinTask；
        ForkJoinTask<Long> task = new ForkJoinTest(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("使用ForkJoin方法----->sum: "+sum+"时间：" + (end - star));
        System.out.println("-----------");
    }
    /**
     * 使用 Stream 流计算
     */
    public static void test3() {
        long star = System.currentTimeMillis();
        //Stream并行流
        long sum = LongStream.range(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("使用 Stream 流计算----->sum: "+sum+"时间：" + (end - star));
    }
}
