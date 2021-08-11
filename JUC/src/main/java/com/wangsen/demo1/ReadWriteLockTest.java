package com.wangsen.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//ReadWriteLock
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        //写入
        for (int i = 1; i <= 5; i++) {
                final int temp=i;
                new Thread(()->{
                    myCache.put(temp+"",temp);
                },String.valueOf(temp)).start();
        }
        //读取
        for (int i = 1; i <= 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(temp)).start();
        }
    }
}
//加锁的自定义缓存
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    //存，  写入的时候，只希望同时只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    //取，  读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
