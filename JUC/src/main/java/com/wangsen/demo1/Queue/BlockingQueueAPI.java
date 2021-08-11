package com.wangsen.demo1.Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueAPI {
    public static void main(String[] args) throws InterruptedException {
        test4();

    }
    //抛出异常
    public static void test1(){
        //队列的大小
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full抛出异常
        //System.out.println(blockingQueue.add("d"));
        System.out.println("----------");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException抛出异常
        System.out.println(blockingQueue.remove());
    }
    //有返回值，不抛出异常
    public static void test2(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.offer("d"));//false  不抛出异常
        System.out.println("----------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//null   不抛出异常
    }
    //阻塞等待(一直阻塞)
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");//队列没有位置了，一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());//没有这个元素，一直阻塞
    }
    //阻塞等待(等待超时)
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));//等待超过两秒就退出
        System.out.println("----------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));//等待超过两秒就退出
    }
}
