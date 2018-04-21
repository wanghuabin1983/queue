package com.iwwenbo;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
public class Task1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        String base = "2sdfasdf2e3reasdfasdf";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = random.nextInt(base.length());
            sb.append(base.charAt(num));
        }
        System.out.println("Task running :" + new Date());
        return sb.toString();
    }
}