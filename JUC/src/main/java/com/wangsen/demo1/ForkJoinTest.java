package com.wangsen.demo1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//求和计算的任务
public class ForkJoinTest extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp=10000L;//临界值

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    //计算方法
    @Override
    protected Long compute() {
        if((end-start)<temp){
            Long sum=0L;
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else {//ForkJoin递归
            //分支合并计算
            long middle=(start+end)/2;//中间值
            ForkJoinTest task1=new ForkJoinTest(start,middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinTest task2=new ForkJoinTest(middle+1,end);
            task2.fork();//拆分任务，把任务压入线程队列
            return task1.join()+task2.join();
        }
    }
}
