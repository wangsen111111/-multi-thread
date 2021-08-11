package com.wangsen.demo1.unsafe;

import javax.jnlp.ClipboardService;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
          //单线程很安全
//        List<String> list = Arrays.asList("1", "2", "3");
//        list.forEach(System.out::println);
        //java.util.ConcurrentModificationException  并发修改异常
        //并发下ArrayList不安全
        /**
         * 解决方案
         * 1. List<String> list = new Vector<>();
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3. List<String> list = new CopyOnWriteArrayList<>();
         */
        //1,List<String> list=new Vector<>();
        //2,List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
