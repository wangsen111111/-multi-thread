package com.company;
/**
 * 静态代理模式总结：真实对象和代理对象都要实现同一个接口，代理对象要代理真实角色
 * 好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("静态代理：");
            }
        }).start();
        WeddingCompany weddingCompany=new WeddingCompany(new My());
        weddingCompany.HappyMarry();

    }
}
//真实角色，我去结婚
class My implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("王某要结婚啦，😊");
    }
}
interface Marry{
    void HappyMarry();
}
//代理角色，帮助我结婚
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target=target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
    private void before() {
        System.out.println("结婚之前，婚庆公司布置现场");
    }

    private void after() {
        System.out.println("结婚之后，婚庆公司收钱");
    }
}