package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//网图下载,练习Thread1，实现多线程同步下载图片
public class Thread1Test extends Thread {
    private String url;//网络图片地址
    private String name;//保存的文件名
    public Thread1Test(String url,String name){
        this.url=url;
        this.name=name;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了图片的文件名为："+name);
    }

    public static void main(String[] args) {
        Thread1Test thread1Test1=new Thread1Test("http://222.186.12.235:41001/Uploads/vod/2021-02-03/601a19c71e562.jpg","窥探1.jpg");
        Thread1Test thread1Test2=new Thread1Test("http://pic.baike.soso.com/p/20110826/20110826220618-1504115653.jpg","窥探2.jpg");
        Thread1Test thread1Test3=new Thread1Test("https://p0.itc.cn/images01/20210423/a454b56b139e433c81cf2f1aaad2ae7a.png","窥探3.jpg");
        thread1Test1.start();
        thread1Test2.start();
        thread1Test3.start();
    }
}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name) {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
