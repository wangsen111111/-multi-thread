package com.wangsen.demo1;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

//自旋锁
public class SpinlockTest {
    //Thread null
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"-->myLock");
        //自旋锁
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    //解锁
    public void myUnLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"-->myUnLock");
        atomicReference.compareAndSet(thread,null);
    }
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock=new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
        //底层使用的是自旋锁CAS
        SpinlockTest spinlock=new SpinlockTest();
//        spinlock.myLock();
//        spinlock.myUnLock();
        new Thread(()->{
            spinlock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinlock.myUnLock();
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinlock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinlock.myUnLock();
            }
        },"T2").start();
    }
}


