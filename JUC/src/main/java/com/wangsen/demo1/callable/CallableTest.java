package com.wangsen.demo1.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread=new MyThread();
        FutureTask futureTask=new FutureTask(thread);//适配器
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//结果会被缓存
        //这个get方法可能会产生阻塞，把get放到最后，或者使用异步通信来处理
        Integer integer=(Integer) futureTask.get();//获取Callable的返回结果
        System.out.println(integer);
    }
}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
