package com.company;
//测试守护线程
public class DaemonTest {
    public static void main(String[] args) {
        God god=new God();
        Me me=new Me();
        Thread thread=new Thread(god);
        thread.setDaemon(true);//默认false表示式用户线程，正常的线程都是用户线程
        thread.start();
        new Thread(me).start();//用户线程启动
    }
}
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑我");
        }
    }
}
class Me implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=365;i++){
            System.out.println("美好的一天开始了");
        }
        System.out.println("~~~~~~~~~~~~~goodbye~~~~~~~~~~~~~~");
    }
}