package com.company;
//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
//主线程和子线程并行交替执行
public class Thread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<10;i++){
            System.out.println("run方法线程体"+i);
        }
    }
    public static void main(String[] args) {
        //创建一个线程对象,并调用start()方法开启线程
        Thread1 thread1=new Thread1();
        thread1.start();
        //main线程，主线程
        for(int i=0;i<100;i++){
            System.out.println("main线程，主线程"+i);
        }
    }
}
