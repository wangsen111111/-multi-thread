package com.company;

public class LambdaTest2 {
    //2.静态内部类
    static class Love2 implements ILove{
        @Override
        public void love(String name) {
            System.out.println("i love you-->"+name);
        }
    }
    public static void main(String[] args) {
        ILove love=new Love();
        love.love("1，定义一个函数式接口,然后实现类");
        love=new Love2();
        love.love("2,静态内部类");
        //3,局部内部类
        class Love3 implements ILove{

            @Override
            public void love(String name) {
                System.out.println("i love you-->"+name);
            }
        }
        love=new Love3();
        love.love("3,局部内部类");
        //4,匿名内部类，没有类的名称，必须借助接口或者父类
        love=new ILove() {
            @Override
            public void love(String name) {
                System.out.println("i love you-->"+name);
            }
        };
        love.love("4,匿名内部类，没有类的名称，必须借助接口或者父类");
        //5,用lambda简化
        love=(String name)->{
            System.out.println("i love you-->"+name);
        };
        love.love("5,用lambda简化");


    }
}
interface ILove{
    void love(String name);
}
class Love implements ILove{

    @Override
    public void love(String name) {
        System.out.println("i love you-->"+name);
    }
}
