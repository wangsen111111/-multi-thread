package com.company;

import java.util.concurrent.locks.ReentrantLock;

//买票测试Lock锁
public class LockTest {
    public static void main(String[] args) {
        LockTest2 lockTest2=new LockTest2();
        new Thread(lockTest2).start();
        new Thread(lockTest2).start();
        new Thread(lockTest2).start();
    }
}
class LockTest2 implements Runnable{
    int ticketNums=10;
    //定义lock锁
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();//加锁
                if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else{
                    break;
                }
            }finally {
                lock.unlock();//释放锁
            }
        }
    }
}
