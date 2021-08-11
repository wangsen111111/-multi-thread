package com.wangsen.demo1.Singleton;

import org.omg.PortableInterceptor.INACTIVE;

//静态内部类
public class Holder {
    private Holder(){

    }
    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }
    public static class InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}