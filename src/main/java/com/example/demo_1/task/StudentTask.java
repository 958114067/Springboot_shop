package com.example.demo_1.task;

import com.example.demo_1.controller.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component()
//@EnableScheduling
//@EnableAsync
public class StudentTask {
    //@Autowired
    private StudentController sc;
    private int count = 0;

    //@Autowired
    private AsyncTask asyncTask;

    //@Scheduled(fixedDelay = 3000)
    public void sayHello() {
        asyncTask.index();
        //System.out.println("这是在执行第："+ ++count +"次方法。");
        sc.sayHello();
    }
}
