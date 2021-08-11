package com.wangsen.demo1.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//A执行完调用B，B执行完调用C，C执行完调用A  A->B->C
public class ConditionDemo {
    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}
//判断等待，业务，通知唤醒
//数字，资源类
class Data3{
    private Lock lock=new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();
    private Condition conditionC=lock.newCondition();
    private int number=1;//1A 2B 3C
    public void printA(){
        lock.lock();
        try {
            //业务，判断-->执行-->通知
            while(number!=1){
                //等待
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"----->AAAAA");
            //唤醒，唤醒指定的B
            number=2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            //业务，判断->执行->通知
            while (number!=2){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"----->BBBBB");
            //唤醒，唤醒指定的C
            number=3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            //业务，判断->执行->通知
            while (number!=3){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"----->CCCCC");
            //唤醒，唤醒指定的A
            number=1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
