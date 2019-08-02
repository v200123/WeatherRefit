package com.example.weatherrefit.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
    private static ThreadPoolUtils utils;
    private ThreadPoolExecutor executor;
//采用了双重加锁的单例
    public static ThreadPoolUtils getInstance()
    {
        if (utils == null)
        {
            synchronized (utils)
            {
                if (utils==null)
                    utils = new ThreadPoolUtils();
            }
        }
        return utils;
    }


    public ThreadPoolExecutor init(){
        if(executor==null)
        {
            synchronized (executor)
            {
                if (executor==null)
                {
                    executor = new ThreadPoolExecutor(20,100,60L, TimeUnit.MICROSECONDS
                            ,new ArrayBlockingQueue<>(20));
                }
            }
        }
        return executor;
    }


}
