package com.wangsen.demo1.Interface;

import java.util.function.Function;

//Function 函数型接口,有一个输入参数，有一个输出
//只要是函数式接口可以用lambda表达式简化
public class FunctionTest {
    public static void main(String[] args) {
        //工具类，输出输入的值
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function<String, String> function=(str)->{return str;};
        System.out.println(function.apply("sososos"));
    }
}
