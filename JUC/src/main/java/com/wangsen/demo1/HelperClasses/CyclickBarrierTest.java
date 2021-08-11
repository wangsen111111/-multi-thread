package com.wangsen.demo1.HelperClasses;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//加法计数器,集齐7颗龙珠召唤神龙
public class CyclickBarrierTest {
    public static void main(String[] args) {
        //召唤龙珠的线程
        CyclicBarrier cyclickBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            //子线程
            int finalI=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+finalI+"颗龙珠");
                try {
                    cyclickBarrier.await();//加法等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
