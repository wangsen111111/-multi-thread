package com.wangsen.demo1.Lock8;

import java.util.concurrent.TimeUnit;

//问题1：两个同步方法，先执行发短信还是打电话
/**
 * 结果：
 * sendMessage
 * call
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone=new Phone();
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
class Phone{
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
}
