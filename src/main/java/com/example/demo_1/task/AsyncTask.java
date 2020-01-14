package com.example.demo_1.task;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//@Component
public class AsyncTask {

    //@Async
    public void index() {
        System.out.println(Thread.currentThread().toString());
    }
}
