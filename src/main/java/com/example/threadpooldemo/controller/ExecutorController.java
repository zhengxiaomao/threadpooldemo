package com.example.threadpooldemo.controller;

import com.example.threadpooldemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExecutorController {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired

    private AsyncService asyncService;



    @RequestMapping("/executor")

    public String submit(){




        //调用service层的任务

        asyncService.executeAsync();



        return "success";

    }


}