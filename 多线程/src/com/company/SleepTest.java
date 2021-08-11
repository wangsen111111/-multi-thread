package com.company;
//模拟网络延时：放大问题的发生性
public class SleepTest implements Runnable{
    private int ticketNums=10;//票数
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
        }
    }
    public static void main(String[] args) {
        SleepTest ticket=new SleepTest();
        new Thread(ticket,"王某").start();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"小黄牛").start();
    }
}
