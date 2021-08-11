package com.company;
//不安全的取钱，两个人去一行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(100,"结婚基金");//账户
        Take me=new Take(account,50,"我");
        Take girlFriend=new Take(account,100,"某某某");
        me.start();
        girlFriend.start();
    }
}
//账户
class Account{
    int money;//余额
    String name;//卡名
    public Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}
//银行，模拟取款
class Take extends Thread{
    Account account;//账户
    int takeMoney;//取了多少钱
    int nowMoney;//现在手里有多少钱
    public Take(Account account,int takeMoney,String name){
        super(name);
        this.account=account;
        this.takeMoney=takeMoney;
    }
    //取钱
    //synchronized默认锁的是this
    @Override
    public void run() {
        synchronized(account){
            //判断有没有钱
            if(account.money-takeMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-取的钱
            account.money=account.money-takeMoney;
            //现在手里的钱
            nowMoney=nowMoney+takeMoney;
            System.out.println(account.name+"余额为："+account.money);
            System.out.println(Thread.currentThread().getName()+"手里的钱："+nowMoney);
        }
    }
}
