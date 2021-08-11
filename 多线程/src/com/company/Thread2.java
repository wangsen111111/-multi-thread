package com.company;
//创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start开启线程
public class Thread2 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<10;i++){
            System.out.println("run方法线程体"+i);
        }
    }
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        Thread2 thread2=new Thread2();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        Thread thread=new Thread(thread2);
        thread.start();
        //main线程，主线程
        for(int i=0;i<100;i++){
            System.out.println("main线程，主线程"+i);
        }
    }
}
