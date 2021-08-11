package com.company;
//多个线程同时操作同一个对象
//买火车票问题
public class Thread2Test implements Runnable{
    private int ticketNums=10;//票数
    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                break;
            }
            //模拟延时
            try{
                Thread.sleep(250);
            }catch(InterruptedException e){
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"张票");
        }
    }
    public static void main(String[] args) {
        Thread2Test ticket=new Thread2Test();
        new Thread(ticket,"王某").start();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"小黄牛").start();
    }
}
