package com.wangsen.demo1.Lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        Phone4 phone=new Phone4();
        new Thread(()->{
            phone.sendMessage();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);//休息一秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        },"B").start();
    }
}
class Phone4{
    //锁的Class类模板
    public static synchronized void sendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);//休息四秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendMessage");
    }
    //锁的调用者
    public synchronized void call(){
        System.out.println("call");
    }
}
