package com.wangsen.demo1.Lock8;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        //两个对象，两个同步方法
        //两个对象的Class类模板只有一个，static锁的是Class
        Phone3 phone=new Phone3();
        Phone3 phone2=new Phone3();
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
//Phone3唯一的一个Class对象
class Phone3{
    public static synchronized void sendMessage(){
        /**
         * synchronized锁的对象是方法的调用者
         * static 静态方法  类一加载就有了，锁的是Class
         */
        try {
            TimeUnit.SECONDS.sleep(4);//休息四秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendMessage");
    }
    public static synchronized void call(){
        System.out.println("call");
    }
}
