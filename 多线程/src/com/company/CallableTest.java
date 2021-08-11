package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三：实现Callable接口   好处：可以定义返回值，可以抛出异常
public class CallableTest implements Callable<Boolean> {
    private String url;//网络图片地址
    private String name;//保存的文件名
    public CallableTest(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了图片的文件名为："+name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest thread1Test1=new CallableTest("http://222.186.12.235:41001/Uploads/vod/2021-02-03/601a19c71e562.jpg","窥探1.jpg");
        CallableTest thread1Test2=new CallableTest("http://pic.baike.soso.com/p/20110826/20110826220618-1504115653.jpg","窥探2.jpg");
        CallableTest thread1Test3=new CallableTest("https://p0.itc.cn/images01/20210423/a454b56b139e433c81cf2f1aaad2ae7a.png","窥探3.jpg");
        //创建执行服务
        ExecutorService service= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=service.submit(thread1Test1);
        Future<Boolean> r2=service.submit(thread1Test2);
        Future<Boolean> r3=service.submit(thread1Test3);
        //获取结果
        boolean res1=r1.get();
        boolean res2=r2.get();
        boolean res3=r3.get();
        //关闭服务
        service.shutdownNow();
    }
}

