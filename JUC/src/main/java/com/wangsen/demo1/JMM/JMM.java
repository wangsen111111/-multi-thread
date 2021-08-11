package com.wangsen.demo1.JMM;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
////保证可见性
//public class JMM {
//    private volatile static int num=0;
//
//    public static void main(String[] args) throws InterruptedException {//main线程
//        new Thread(()->{//线程1,对主内存的变化是不知道的
//            while(num==0){
//
//            }
//        }).start();
//        TimeUnit.SECONDS.sleep(1);
//        num=1;
//        System.out.println(num);
//    }
//}
public class JMM{
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));

    }
    //思路1：循环计算 n次 x相乘，时间复杂度O(n), 当n非常大时，效率低
    public static double myPow(double x, int n) {
        if(n==0) return 1.0;
        double result = 1;
        if (n >0) {
            for (int i = 0; i < n; i++) {
                result*=x;
            }
        } else {
            n=-n;
            for (int i = 0; i < n; i++) {
                result*=x;
            }
            result=1 / result;
        }
        return  result;
    }
    //
}
