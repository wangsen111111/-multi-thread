package com.wangsen.demo1.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndConsumeLock {
    public static void main(String[] args) {
        Data2 data=new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//判断等待，业务，通知唤醒
//数字，资源类
class Data2{
    private int number=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    //condition.await();//等待
    //condition.signalAll();//唤醒全部
    //+1
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            //业务代码
            while(number!=0){
                //等待
                condition.await();//等待
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"-->"+number);
            //通知其他线程，我+1完毕啦
            condition.signalAll();//唤醒全部
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //-1
    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
            //业务代码
            while(number==0){
                //等待
                condition.await();//等待
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"-->"+number);
            //通知其他线程，我-1完毕啦
            condition.signalAll();//唤醒全部
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

