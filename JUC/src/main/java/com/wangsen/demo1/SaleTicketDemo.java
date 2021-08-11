package com.wangsen.demo1;
//基本的卖票例子
/**
 * 多线程开发
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1，属性，方法
 * 2，
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        //并发：多线程操作同一个资源类，把资源丢入线程
        Ticket ticket=new Ticket();
        //@FunctionalInterface函数式接口   lambda表达式：(参数)->{代码}
        new Thread(()->{
            for (int i = 0; i <= 20; i++) {
                ticket.sale();
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i <= 20; i++) {
                ticket.sale();
            }

        },"B").start();
        new Thread(()->{
            for (int i = 0; i <= 20; i++) {
                ticket.sale();
            }

        },"C").start();

    }
}
//资源类 OOP
class Ticket{
    //属性，方法
    private int number=20;
    //卖票的方式
    //synchronized本质：队列 锁<对象  Class>
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"张票"+"剩余"+number+"张票");
        }
    }
}


