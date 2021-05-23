package com.example.threadpooldemo.service;

import com.example.threadpooldemo.tools.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service

public class AsyncServiceImpl implements AsyncService {


    @Autowired
    RedisUtil redisUtil;

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);


    Lock lock=new ReentrantLock();


    @Override

    @Async("asyncServiceExecutor2")

    public void executeAsync() {


        logger.info("线程"+Thread.currentThread().getName()+"尝试加锁。。。");
        Boolean lock=redisUtil.lock("s",5);
        if(lock){
            logger.info(Thread.currentThread().getName()+"加锁成功，修改redis的i...");
            int i=(int)redisUtil.get("i");
            int i2 = i-1;
            redisUtil.set("i",i2);
            logger.info("修改成功");

        }else {
            logger.warn("加锁失败");
        }


    }

}