package com.wangsen.demo1.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new SynchronousQueue<>();//同步队列
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"->"+"put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"->"+"put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"->"+"put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-----take"+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-----take"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-----take"+ blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
