package com.wangsen.demo1.JMM;

import java.util.concurrent.atomic.AtomicInteger;

//volatile不保证原子性
public class volatileTest {
    //volatile不保证原子性
    private volatile static AtomicInteger num=new AtomicInteger();
    public static void add(){
        //num++;//不是一个原子性操作
        num.getAndIncrement();//getAndIncrement +1方法
    }
    public static void main(String[] args) {
       //理论上num结果是20000
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }
        while(Thread.activeCount()>2){//main和gc线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"   num="+num);
    }
}
