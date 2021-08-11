package com.wangsen.demo1;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//CAS : compareAndSet 比较并交换
public class casTest {
    /**
     * AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
     * 正常在业务操作，这里面比较的都是一个个对象
     */
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(21,1);
    public static void main(String[] args) {
        Lock lock=new ReentrantLock(true);
        //平时写的SQL：乐观锁！
        //AtomicInteger atomicInteger = new AtomicInteger(2021);
        new Thread(()->{
            int version=atomicStampedReference.getStamp();//获得版本号
            System.out.println("A1 version-->"+version);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Version +1
            atomicStampedReference.compareAndSet(21,22,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("21-->22 A2 version-->"+atomicStampedReference.getStamp());
            System.out.println("A3:"+atomicStampedReference.compareAndSet(22, 21,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("22-->21 A3 version-->"+atomicStampedReference.getStamp());
        },"A").start();

        // 乐观锁的原理相同！
        new Thread(() -> {
            int version = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("B1 version-->"+version);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B2:"+atomicStampedReference.compareAndSet(21, 18,
                    version, version + 1));
            System.out.println("21-->18 B2 version-->"+atomicStampedReference.getStamp());
        }, "B").start(); }
}
