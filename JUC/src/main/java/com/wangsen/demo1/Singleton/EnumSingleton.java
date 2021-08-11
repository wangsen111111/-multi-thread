package com.wangsen.demo1.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//enum本身就是一个Class 类
public enum  EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance1=EnumSingleton.INSTANCE;
        Constructor<EnumSingleton> enumSingletonConstructor=EnumSingleton.class.
                getDeclaredConstructor(String.class,int.class);
        enumSingletonConstructor.setAccessible(true);
        EnumSingleton instance2=enumSingletonConstructor.newInstance();
        System.out.println("instance1--->"+instance1.hashCode());
        System.out.println("instance2--->"+instance2.hashCode());
    }
}
