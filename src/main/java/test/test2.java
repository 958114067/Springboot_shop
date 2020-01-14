package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        Date time = new Date("Oct 28, 2019 1:12:00 PM");
        Long times = time.getTime();
        System.out.println(times);
    }
}

