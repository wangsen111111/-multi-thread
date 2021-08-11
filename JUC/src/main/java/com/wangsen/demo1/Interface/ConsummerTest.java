package com.wangsen.demo1.Interface;

import java.util.function.Consumer;

//Consummer 消费型接口,只有输入，没有返回值
public class ConsummerTest {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer=(str)->{System.out.println(str);};
        consumer.accept("happy");
    }
}
