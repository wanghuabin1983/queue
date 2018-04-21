package com.iwwenbo;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ScheduleThreadDemo {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                2);
        ScheduledFuture future1 = executor.schedule(new Task1(), 5,
                TimeUnit.SECONDS);
        ScheduledFuture future2 = executor.schedule(new LongTask(), 3,
                TimeUnit.SECONDS);

        BlockingQueue<ScheduledFuture> blockingQueue = new ArrayBlockingQueue<ScheduledFuture>(
                2, true);
        // 想BlockingQueue中存放对象，如果可以容纳，返回true，否则抛出异常
        blockingQueue.add(future2);
        blockingQueue.add(future1);

        System.out.println(new Date());
        // 如果BlockingQueue不为空
        while (!blockingQueue.isEmpty()) {
            // 取走BlockingQueue中排在首位的对象，取不到返回null
            ScheduledFuture future = blockingQueue.poll();
            // 如果没有执行
            if (!future.isDone()) {
//            	System.out.println("blockingQueue.size() :" + blockingQueue.size());
                // 将任务再次加入队列
                blockingQueue.add(future);
//                System.out.println("blockingQueue.size2() :" + blockingQueue.size());
            } else {
                // 若果执行了，返回执行结果
                System.out.println(future.get());
            }
        }
        System.out.println(new Date());
        //executor.shutdown();
    }
}