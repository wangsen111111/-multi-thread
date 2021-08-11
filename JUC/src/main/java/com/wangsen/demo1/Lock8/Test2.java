package com.wangsen.demo1.Lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        //两个对象，两个同步方法
        Phone2 phone=new Phone2();
        Phone2 phone2=new Phone2();
        new Thread(()->{
            phone.sendMessage();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);//休息一秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}
class Phone2{
    public synchronized void sendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);//休息四秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendMessage");
    }
    public synchronized void call(){
        System.out.println("call");
    }
    //这里没有锁，不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}

