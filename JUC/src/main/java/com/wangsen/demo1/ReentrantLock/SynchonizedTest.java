package com.wangsen.demo1.ReentrantLock;

public class SynchonizedTest {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendMessage();
        },"A").start();
        new Thread(()->{
            phone.sendMessage();
        },"B").start();
    }
}
class Phone{
    public synchronized void sendMessage(){
        System.out.println(Thread.currentThread().getName()+"-->sendMessage()");
        call();//这里也有锁
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"-->call()");
    }
}
