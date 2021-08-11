package com.wangsen.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo2 {
    public static void main(String[] args) {
        //并发：多线程操作同一个资源类，把资源丢入线程
        Ticket2 ticket=new Ticket2();
        new Thread(()->{
            for (int i = 0; i <= 20; i++) ticket.sale();
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <= 20; i++) ticket.sale();
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <= 20; i++) ticket.sale();
        },"C").start();
    }
}
//资源类 OOP
class Ticket2{
    //属性，方法
    private int number=20;
    Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();//加锁
        try {
            //业务代码
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"张票"+"剩余"+number+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//解锁
        }
    }
}

