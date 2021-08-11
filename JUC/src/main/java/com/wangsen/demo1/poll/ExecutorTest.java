package com.wangsen.demo1.poll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Executors工具类，三大方法
public class ExecutorTest {
    public static void main(String[] args) {
        // 获取cpu 的核数
        int max = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU的核数："+max);
        //自定义线程池ThreadPoolExecutor
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i <= 9; i++) {
                //使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"   ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}
