package com.wangsen.demo1.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Phone2 phone=new Phone2();
        new Thread(()->{
            phone.sendMessage();
        },"A").start();
        new Thread(()->{
            phone.sendMessage();
        },"B").start();
    }
}
class Phone2{
    Lock lock=new ReentrantLock();
    public synchronized void sendMessage(){
        lock.lock();//细节:这是两把锁，两个钥匙
        //lock锁必须配对，否则就会死锁在里面
        try {
            System.out.println(Thread.currentThread().getName()+"-->sendMessage()");
            call();//这里也有锁
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public synchronized void call(){
        lock.lock();
        //lock锁必须配对，否则就会死锁在里面
        try {
            System.out.println(Thread.currentThread().getName()+"-->call()");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

