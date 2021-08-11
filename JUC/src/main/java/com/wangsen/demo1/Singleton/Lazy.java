package com.wangsen.demo1.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//懒汉式例子
public class Lazy {
    private static boolean flag=false;
    private Lazy() {
        synchronized(Lazy.class){
            if(flag==false){
                flag=true;
            }else{
                throw new RuntimeException("异常：不要试图使用反射破坏");
            }
        }
        System.out.println(Thread.currentThread().getName()+"--->OK");
    }
    //避免指令重排
    private volatile static Lazy lazy;
    //双重检测锁模式--DCL懒汉式
    public static Lazy getInstance(){
        if(lazy==null){
            //加了锁保证只有一个
            synchronized (Lazy.class){
                if(lazy==null){
                    lazy=new Lazy();//不是一个原子性操作
                    /**
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     *
                     *  就有可能出现指令重排问题
                     *  比如执行的顺序是1 3 2 A线程
                     *                    B线程//此时的lazy还没有完成构造
                     *  我们就可以添加volatile避免指令重排问题
                     */
                }
            }
        }
        return lazy;
    }
    //反射
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
        //反射可破坏单例模式
        //Lazy instance=Lazy.getInstance();
        Field flag=Lazy.class.getDeclaredField("flag");
        flag.setAccessible(true);

        //通过构造器创建对象
        Constructor<Lazy> lazyConstructor=Lazy.class.getDeclaredConstructor(null);
        lazyConstructor.setAccessible(true);//取消安全检测
        Lazy instance=lazyConstructor.newInstance();
        flag.set(instance,false);
        Lazy instance2=lazyConstructor.newInstance();//创建类的对象，本质上是调用了类的无参构造器

        System.out.println("instance-->"+instance.hashCode());
        System.out.println("instance2-->"+instance2.hashCode());
    }
}
