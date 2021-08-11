package com.wangsen.demo1.Interface;

import java.util.function.Supplier;

//Suppier 供给型接口，没有参数，只有返回值
public class SuppierTest {
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };
        Supplier<Integer> supplier=()->{System.out.println("get()");return 1024;};
        System.out.println(supplier.get());
    }
}
