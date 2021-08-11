package com.company;
//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket=new BuyTicket();
        new Thread(ticket,"王某").start();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"小黄牛").start();
    }
}
class BuyTicket implements Runnable{
    private int ticketNums=10;//票
    boolean flag=true;//外部停止方式
    @Override
    public void run() {
        //买票
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到第"+ticketNums--+"张票");
    }
}
